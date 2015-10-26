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

import com.network.social.domain.entities.Notificacion;
import com.network.social.domain.util.BResult;
import com.network.social.services.service.NotificacionService;
import com.network.social.services.util.UtilEnum.ESTADO_OPERACION;
/**
 * @author :Alexander Chavez Simbron
 * @date   :21/10/2015
 * @time   :16:22:35
 */
@RestController
@RequestMapping(value=NOTIFICACION)
public class ServiceNotificacionController {

	Logger LOGGER=LoggerFactory.getLogger(ServiceNotificacionController.class);
	
	@Autowired
	private NotificacionService notificacionService;
	
	
	@RequestMapping(value=GET,method=RequestMethod.GET)
	private @ResponseBody Notificacion get(@PathVariable Integer id){
		return notificacionService.findById(id);
	}
	
	@RequestMapping(value=GET_FILTERING,method=RequestMethod.GET)
	private @ResponseBody List<Notificacion> getAllbyUser(@PathVariable Integer filter){
		return notificacionService.getAllbyUser(filter);
	}
	
	@RequestMapping(value=GET_ALL,method=RequestMethod.GET)
	private @ResponseBody List<Notificacion> getAll(){
		return notificacionService.findAll();
	}
	
	@RequestMapping(value=POST,method=RequestMethod.POST,consumes="application/json") 
	   private @ResponseBody BResult post(@RequestBody Notificacion notificacion){
		 
			LOGGER.info("## ServiceNotificacionController -->post");
			BResult bResult =null;
			try{
				if(notificacion!=null){
					bResult=new BResult();
					bResult.setEstado(notificacionService.save(notificacion));
					LOGGER.info("## notificacion registrado ->"+bResult.getEstado());
					if (bResult.getEstado()>0) {
						bResult.setEstado(ESTADO_OPERACION.EXITO.getCodigo());
					}else{
						LOGGER.info("Error al Registrar notificacion -->"+notificacion.getIdnotificacion());
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
	   private @ResponseBody BResult put(@RequestBody Notificacion notificacion){
		 
			LOGGER.info("## ServiceNotificacionController -->put");
			BResult bResult =null;
			try{
				if(notificacion!=null){
					bResult=new BResult();
					notificacionService.update(notificacion);
					bResult.setEstado(ESTADO_OPERACION.CORRECTO.getCodigo());
					LOGGER.info("## notificacion actualizado ->"+notificacion.getIdnotificacion());
					if (bResult.getEstado()>0) {
						bResult.setEstado(ESTADO_OPERACION.EXITO.getCodigo());
					}else{
						LOGGER.info("Error al Actualizar notificacion -->"+notificacion.getIdnotificacion());
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
	   private @ResponseBody BResult delete(@RequestBody Notificacion notificacion){
		 
			LOGGER.info("## ServiceListaContactoController -->delete");
			BResult bResult =null;
			try{
				if(notificacion.getIdnotificacion()>0){
					bResult=new BResult();
					notificacionService.delete(notificacion);
					bResult.setEstado(ESTADO_OPERACION.CORRECTO.getCodigo());
					LOGGER.info("## notificacion eliminado ->"+bResult.getEstado());
					if (bResult.getEstado()>0) {
						bResult.setEstado(ESTADO_OPERACION.EXITO.getCodigo());
					}else{
						LOGGER.info("Error al eliminar notificacion -->"+notificacion.getIdnotificacion());
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
