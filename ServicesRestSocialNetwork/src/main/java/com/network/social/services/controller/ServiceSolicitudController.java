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

import com.network.social.domain.entities.Solicitud;
import com.network.social.domain.util.BResult;
import com.network.social.services.service.SolicitudService;
import com.network.social.services.util.UtilEnum.ESTADO_OPERACION;
/**
 * @author :Alexander Chavez Simbron
 * @date   :21/10/2015
 * @time   :16:23:53
 */
@RestController
@RequestMapping(value=SOLICITUD)
public class ServiceSolicitudController {

	Logger LOGGER=LoggerFactory.getLogger(ServiceSolicitudController.class);
	
	@Autowired
	private SolicitudService solicitudService;
	
	
	@RequestMapping(value=GET,method=RequestMethod.GET)
	private @ResponseBody Solicitud get(@PathVariable Integer id){
		return solicitudService.findById(id);
	}
	
	@RequestMapping(value=GET_FILTERING,method=RequestMethod.GET)
	private @ResponseBody List<Solicitud> getAllbyUser(@PathVariable Integer filter){
		return solicitudService.getAllbyUser(filter);
	}

	@RequestMapping(value=GET_ALL,method=RequestMethod.GET)
	private @ResponseBody List<Solicitud> getAll(){
		return solicitudService.findAll();
	}
	
	@RequestMapping(value=POST,method=RequestMethod.POST,consumes="application/json") 
	   private @ResponseBody BResult post(@RequestBody Solicitud solicitud){
		 
			LOGGER.info("## ServiceSolicitudController -->post");
			BResult bResult =null;
			try{
				if(solicitud!=null){
					bResult=new BResult();
					bResult.setEstado(solicitudService.save(solicitud));
					LOGGER.info("## solicitud registrado ->"+bResult.getEstado());
					if (bResult.getEstado()>0) {
						bResult.setEstado(ESTADO_OPERACION.EXITO.getCodigo());
					}else{
						LOGGER.info("Error al Registrar solicitud -->"+solicitud.getIdsolicitud());
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
	   private @ResponseBody BResult put(@RequestBody Solicitud solicitud){
		 
			LOGGER.info("## ServiceSolicitudController -->put");
			BResult bResult =null;
			try{
				if(solicitud!=null){
					bResult=new BResult();
					solicitudService.update(solicitud);
					bResult.setEstado(ESTADO_OPERACION.CORRECTO.getCodigo());
					LOGGER.info("## solicitud actualizado ->"+solicitud.getIdsolicitud());
					if (bResult.getEstado()>0) {
						bResult.setEstado(ESTADO_OPERACION.EXITO.getCodigo());
					}else{
						LOGGER.info("Error al Actualizar solicitud -->"+solicitud.getIdsolicitud());
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
	   private @ResponseBody BResult delete(@PathVariable Integer id){
		 
			LOGGER.info("## ServiceSolicitudController -->delete");
			BResult bResult =null;
			try{
				if(id>0){
					bResult=new BResult();
					Solicitud solicitud=new Solicitud();
					solicitud.setIdsolicitud(id);
					solicitudService.delete(solicitud);
					bResult.setEstado(ESTADO_OPERACION.CORRECTO.getCodigo());
					LOGGER.info("## solicitud eliminado ->"+bResult.getEstado());
					if (bResult.getEstado()>0) {
						bResult.setEstado(ESTADO_OPERACION.EXITO.getCodigo());
					}else{
						LOGGER.info("Error al eliminar solicitud -->"+solicitud.getIdsolicitud());
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
}
