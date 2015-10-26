package com.network.social.services.controller;

import static com.network.social.services.util.RestURIConstants.*;

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

import com.network.social.domain.entities.Publicacion;
import com.network.social.domain.util.BResult;
import com.network.social.services.service.PublicacionService;
import com.network.social.services.util.UtilEnum.ESTADO_OPERACION;

/**
* @author : Alexander Chavez Simbron
* @date   : 18 de oct. de 2015
* @time   : 8:34:53 p. m.
*/
@RestController
@RequestMapping(value="publicacion")
public class ServicePublicacionController {

	Logger LOGGER=LoggerFactory.getLogger(ServicePublicacionController.class);

	@Autowired
	private PublicacionService publicacionService;
	
	@RequestMapping(value=GET,method=RequestMethod.GET)
	private @ResponseBody Publicacion get(@PathVariable Integer id){
		return publicacionService.findById(id);
	}
	
	@RequestMapping(value=GET_FILTERING,method=RequestMethod.GET)
	private @ResponseBody List<Publicacion> getAllbyUser(@PathVariable Integer filter){
		return publicacionService.getAllbyUser(filter);
	}
	
	@RequestMapping(value=GET_FILTERING_GROUP,method=RequestMethod.GET)
	private @ResponseBody List<Publicacion> getAllbyGrupo(@PathVariable Integer filter){
		return publicacionService.getAllbyGrupo(filter);
	}
	
	@RequestMapping(value=GET_FILTERING_TIPOCONTACTO,method=RequestMethod.GET)
	private @ResponseBody List<Publicacion> getAllbyUserTipo(@PathVariable Integer id,@PathVariable Integer filter){
		return publicacionService.getAllbyUserTipo(id,filter);
	}
	
	@RequestMapping(value=GET_FILTERING_LISTACONTACTO,method=RequestMethod.GET)
	private @ResponseBody List<Publicacion> getAllbyUserLista(@PathVariable Integer id,@PathVariable Integer filter){
		return publicacionService.getAllbyUserLista(id,filter);
	}
	@RequestMapping(value=GET_ALL,method=RequestMethod.GET)
	private @ResponseBody List<Publicacion> getAll(){
		return publicacionService.findAll();
	}
	
	
	@RequestMapping(value=POST,method=RequestMethod.POST,consumes="application/json") 
	   private @ResponseBody BResult post(@RequestBody Publicacion publicacion){
		 
			LOGGER.info("## ServicePublicacionController -->post");
			BResult bResult =null;
			try{
				if(publicacion!=null){
					bResult=new BResult();
					bResult.setEstado(publicacionService.save(publicacion));
					LOGGER.info("## publicacion registrado ->"+bResult.getEstado());
					if (bResult.getEstado()>0) {
						bResult.setEstado(ESTADO_OPERACION.EXITO.getCodigo());
					}else{
						LOGGER.info("Error al Registrar publicacion -->"+publicacion.getIdpublicacion());
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
	   private @ResponseBody BResult put(@RequestBody Publicacion publicacion){
		 
			LOGGER.info("## ServicePublicacionController -->put");
			BResult bResult =null;
			try{
				if(publicacion!=null){
					bResult=new BResult();
					publicacionService.update(publicacion);
					bResult.setEstado(ESTADO_OPERACION.CORRECTO.getCodigo());
					LOGGER.info("## publicacion actualizado ->"+publicacion.getIdpublicacion());
					if (bResult.getEstado()>0) {
						bResult.setEstado(ESTADO_OPERACION.EXITO.getCodigo());
					}else{
						LOGGER.info("Error al Actualizar publicacion -->"+publicacion.getIdpublicacion());
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
	   private @ResponseBody BResult delete(@RequestBody Publicacion publicacion){
		 
			LOGGER.info("## ServicePublicacionController -->delete");
			BResult bResult =null;
			try{
				if(publicacion.getIdpublicacion()>0){
					bResult=new BResult();
					publicacionService.delete(publicacion);
					bResult.setEstado(ESTADO_OPERACION.CORRECTO.getCodigo());
					LOGGER.info("## publicacion eliminado ->"+bResult.getEstado());
					if (bResult.getEstado()>0) {
						bResult.setEstado(ESTADO_OPERACION.EXITO.getCodigo());
					}else{
						LOGGER.info("Error al eliminar publicacion -->"+publicacion.getIdpublicacion());
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


