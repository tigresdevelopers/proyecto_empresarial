package com.network.social.services.controller;

import static com.network.social.services.util.RestURIConstants.DELETE;
import static com.network.social.services.util.RestURIConstants.GET;
import static com.network.social.services.util.RestURIConstants.GET_ALL;
import static com.network.social.services.util.RestURIConstants.GET_FILTERING;
import static com.network.social.services.util.RestURIConstants.GET_FILTERING_GROUP;
import static com.network.social.services.util.RestURIConstants.GET_FILTERING_LISTACONTACTO;
import static com.network.social.services.util.RestURIConstants.GET_FILTERING_TIPOCONTACTO;
import static com.network.social.services.util.RestURIConstants.POST;
import static com.network.social.services.util.RestURIConstants.PUT;
import static com.network.social.services.util.RestURIConstants.USUARIO;
import static com.network.social.services.util.RestURIConstants.USUARIO_FIND_USERNAME;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.network.social.domain.entities.Actividad;
import com.network.social.domain.entities.Publicacion;
import com.network.social.domain.entities.TipoContacto;
import com.network.social.domain.entities.Usuario;
import com.network.social.domain.util.BResult;
import com.network.social.services.service.ActividadService;
import com.network.social.services.service.PublicacionService;
import com.network.social.services.service.UsuarioService;
import com.network.social.services.util.UtilEnum;
import com.network.social.services.util.UtilEnum.ESTADO_OPERACION;

import oracle.net.aso.p;
/**
 * @author :Alexander Chavez Simbron
 * @date   :21/10/2015
 * @time   :16:24:21
 */
@RestController
@RequestMapping(value=USUARIO)
public class ServiceUsuarioController {

	Logger LOGGER=LoggerFactory.getLogger(ServiceUsuarioController.class);
	
	@Autowired
    private UsuarioService usuarioService;
	
	@Autowired
	private ActividadService actividadService;
	
	@Autowired
	private PublicacionService publicacionService;
	
	
    @RequestMapping(value=USUARIO_FIND_USERNAME,method=RequestMethod.POST,consumes="application/json") 
    private @ResponseBody Usuario getByUsername(@RequestBody Usuario usuario){
  	 
     Usuario u=usuarioService.findByUsername(usuario.getEmail());
    if (u!=null) {
    	 u.setEmail(u.getEmail());
         u.setClave(u.getClave());
         u.setSituacionSentimental(u.getSituacionSentimental());
         System.out.println(u.getSituacionSentimental().getIdsituacion());
         u.roles=u.roles;
	}
     return u;
     
    }
	
    @RequestMapping(value=GET,method=RequestMethod.GET)
	private @ResponseBody Usuario get(@PathVariable Integer id){
		return usuarioService.findById(id);
	}
    
    @RequestMapping(value=GET_FILTERING,method=RequestMethod.GET)
   	private @ResponseBody List<Usuario> getAllbyUser(@PathVariable Integer filter){
   		return usuarioService.getAllbyUser(filter);
   	}
    
    @RequestMapping(value=GET_FILTERING_GROUP,method=RequestMethod.GET)
   	private @ResponseBody List<Usuario> getAllbyGrupo(@PathVariable Integer filter){
   		return usuarioService.getAllbyGrupo(filter);
   	}
    
    @RequestMapping(value=GET_FILTERING_LISTACONTACTO,method=RequestMethod.GET)
   	private @ResponseBody List<Usuario> getAllbyListaContacto(@PathVariable Integer id,@PathVariable Integer filter){
   		return usuarioService.getAllbyListaContacto(id,filter);
   	}
    
    @RequestMapping(value=GET_FILTERING_TIPOCONTACTO,method=RequestMethod.GET)
   	private @ResponseBody List<Usuario> getAllbyTipoContacto(@PathVariable Integer id,@PathVariable Integer filter){
   		return usuarioService.getAllbyTipoContacto(id,filter);
   	}
	@RequestMapping(value=GET_ALL,method=RequestMethod.GET)
	private @ResponseBody List<Usuario> getUsuarios(){
		return usuarioService.findAll();
	}
	
	
	
   @RequestMapping(value=POST,method=RequestMethod.POST,consumes="application/json") 
   private @ResponseBody BResult post(@RequestBody Usuario usuario){
	 
		LOGGER.info("## ServiceUsuarioController -->create");
		BResult bResult =null;
		try{
			if(usuario!=null){
				bResult=new BResult();
				usuario.setEstado('1');
				usuario.setFechaRegistro(new Date());
				bResult.setEstado(usuarioService.save(usuario));
				LOGGER.info("## Usuario registrado ->"+bResult.getEstado());
				if (bResult.getEstado()>0) {
					bResult.setEstado(ESTADO_OPERACION.EXITO.getCodigo());
					bResult.setCodigo(ESTADO_OPERACION.EXITO.getCodigo());
				}else{
					LOGGER.info("Error al registrar Usuario -->"+usuario.getEmail()+":"+usuario.getNombre()+"-"+usuario.getApeMaterno());
					bResult = new BResult();
					bResult.setEstado(ESTADO_OPERACION.TRANSACCION_NO_PROCESADO.getCodigo());
				}
			}	
		}catch(Exception ex){
			LOGGER.info("EXCEPTION SERVICE", ex);
			bResult = new BResult();
			bResult.setEstado(ESTADO_OPERACION.EXCEPTION.getCodigo());
			bResult.setMensaje("exception proceso");
		}
		LOGGER.info("## response :"+bResult.getCodigo());
		return bResult;
    }
	
   @RequestMapping(value=PUT,method=RequestMethod.POST,consumes="application/json") 
   private @ResponseBody BResult put(@RequestBody Usuario usuario){
	 
		LOGGER.info("## ServiceUsuarioController -->create");
		BResult bResult =null;
		try{
			if(usuario!=null){
				bResult=new BResult();
				
				Publicacion publicacion=new Publicacion();
				publicacion.setUsuarioByIdusuario(usuario);
				publicacion.setUsuarioByIdusuarioReceiver(usuario);
				publicacion.setTipoContacto(new TipoContacto(2));
				
				Actividad historial=new Actividad();
				historial.setIdusuario(usuario.getIdusuario());
				historial.setFechaActividad(new Date());

				Usuario compare=usuarioService.findById(usuario.getIdusuario());
				
				if (!compare.getSituacionSentimental().equals(usuario.getSituacionSentimental())) {
					
					publicacion.setContenido(UtilEnum.MESSAGES.PUBLICACION_SITUACION_UPDATE_USUARIO.getMessage());
					historial.setDescripcion(UtilEnum.MESSAGES.ACTIVIDAD_SITUACION_UPDATE_USUARIO.getMessage());
					
				}else if (!compare.getCelular().equals(usuario.getCelular())) {
					
					publicacion.setContenido(UtilEnum.MESSAGES.PUBLICACION_CELULAR_UPDATE_USUARIO.getMessage());
					historial.setDescripcion(UtilEnum.MESSAGES.ACTIVIDAD_CELULAR_UPDATE_USUARIO.getMessage());
					
				}
				
				usuarioService.update(usuario);
				
				Integer idpublicacion=publicacionService.save(publicacion);
				
				historial.setPublicacion(idpublicacion);
				actividadService.save(historial);
				
				bResult.setEstado(ESTADO_OPERACION.CORRECTO.getCodigo());
				LOGGER.info("## Usuario registrado ->"+bResult.getEstado());
				if (bResult.getEstado()>0) {
					bResult.setEstado(ESTADO_OPERACION.EXITO.getCodigo());
				}else{
					LOGGER.info("Error al actualizar Usuario -->"+usuario.getEmail()+":"+usuario.getNombre()+"-"+usuario.getApeMaterno());
					bResult = new BResult();
					bResult.setEstado(ESTADO_OPERACION.TRANSACCION_NO_PROCESADO.getCodigo());
				}
			}	
		}catch(Exception ex){
			LOGGER.info("EXCEPTION SERVICE", ex);
			bResult = new BResult();
			bResult.setEstado(ESTADO_OPERACION.EXCEPTION.getCodigo());
			bResult.setMensaje("exception proceso");
		}
		LOGGER.info("## response :"+bResult.getCodigo());
		return bResult;
    }
   
   @RequestMapping(value=DELETE,method=RequestMethod.POST,consumes="application/json") 
   private @ResponseBody BResult delete(@RequestBody Usuario usuario){
	 
		LOGGER.info("## ServiceUsuarioController -->create");
		BResult bResult =null;
		try{
			if(usuario.getIdusuario()>0){
				bResult=new BResult();
				Usuario persistentInstance=new Usuario(usuario.getIdusuario());
				usuarioService.delete(persistentInstance);
				bResult.setEstado(ESTADO_OPERACION.CORRECTO.getCodigo());
				LOGGER.info("## Usuario registrado ->"+bResult.getEstado());
				if (bResult.getEstado()>0) {
					bResult.setEstado(ESTADO_OPERACION.EXITO.getCodigo());
				}else{
					LOGGER.info("Error al eliminar Usuario -->"+usuario.getIdusuario());
					bResult = new BResult();
					bResult.setEstado(ESTADO_OPERACION.TRANSACCION_NO_PROCESADO.getCodigo());
				}
			}	
		}catch(Exception ex){
			LOGGER.info("EXCEPTION SERVICE", ex);
			bResult = new BResult();
			bResult.setEstado(ESTADO_OPERACION.EXCEPTION.getCodigo());
			bResult.setMensaje("exception proceso");
		}
		LOGGER.info("## response :"+bResult.getEstado());
		return bResult;
    }
}
