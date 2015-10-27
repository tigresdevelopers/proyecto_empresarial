package com.network.social.services.controller;

import static com.network.social.services.util.RestURIConstants.*;

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

import com.network.social.domain.entities.Contacto;
import com.network.social.domain.util.BResult;
import com.network.social.services.service.ContactoService;
import com.network.social.services.util.UtilEnum.ESTADO_OPERACION;
/**
 * @author :Alexander Chavez Simbron
 * @date   :21/10/2015
 * @time   :16:18:47
 */
@RestController
@RequestMapping(value=CONTACTO)
public class ServiceContactoController {
	
	Logger LOGGER=LoggerFactory.getLogger(ServiceContactoController.class);

	@Autowired
	private ContactoService contactoService;
	
	@RequestMapping(value=GET,method=RequestMethod.GET)
	private @ResponseBody Contacto get(@PathVariable Integer id){
		return contactoService.findById(id);
	}
	
	@RequestMapping(value=GET_FILTERING,method=RequestMethod.GET)
	private @ResponseBody List<Contacto> getAllbyUser(@PathVariable Integer filter){
		return contactoService.getAllbyUser(filter);
	}
	
	@RequestMapping(value=GET_ALL,method=RequestMethod.GET)
	private @ResponseBody List<Contacto> getAll(){
		return contactoService.findAll();
	}
	
	@RequestMapping(value=POST,method=RequestMethod.POST,consumes="application/json") 
	   private @ResponseBody BResult post(@RequestBody Contacto contacto){
		 
			LOGGER.info("## ServiceContactoController -->create");
			BResult bResult =null;
			try{
				if(contacto!=null){
					bResult=new BResult();
					contacto.setFechaInicioAmistad(new Date());
					bResult.setEstado(contactoService.save(contacto));
					LOGGER.info("## contacto registrado ->"+bResult.getEstado());
					if (bResult.getEstado()>0) {
						bResult.setEstado(ESTADO_OPERACION.EXITO.getCodigo());
						bResult.setCodigo(ESTADO_OPERACION.EXITO.getCodigo());
					}else{
						LOGGER.info("Error al registrar contacto -->"+contacto.getUsuarioByIdusuario().getIdusuario());
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
	   private @ResponseBody BResult put(@RequestBody Contacto contacto){
		 
			LOGGER.info("## ServiceContactoController -->create");
			BResult bResult =null;
			try{
				if(contacto!=null){
					bResult=new BResult();
					contactoService.update(contacto);
					bResult.setEstado(ESTADO_OPERACION.CORRECTO.getCodigo());
					LOGGER.info("## contacto registrado ->"+bResult.getEstado());
					if (bResult.getEstado()>0) {
						bResult.setEstado(ESTADO_OPERACION.EXITO.getCodigo());
					}else{
						LOGGER.info("Error al actualizar contacto -->"+contacto.getIdcontacto());
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
	   private @ResponseBody BResult delete(@RequestBody Contacto contacto){
		 
			LOGGER.info("## ServiceContactoController -->create");
			BResult bResult =null;
			try{
				if(contacto.getIdcontacto()>0){
					bResult=new BResult();
					contactoService.delete(contacto);
					bResult.setEstado(ESTADO_OPERACION.CORRECTO.getCodigo());
					LOGGER.info("## contacto registrado ->"+bResult.getEstado());
					if (bResult.getEstado()>0) {
						bResult.setEstado(ESTADO_OPERACION.EXITO.getCodigo());
					}else{
						LOGGER.info("Error al eliminar contacto -->"+contacto.getIdcontacto());
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
