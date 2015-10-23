package com.network.social.services.controller;

import static com.network.social.services.util.RestURIConstants.ACTIVIDAD;
import static com.network.social.services.util.RestURIConstants.DELETE;
import static com.network.social.services.util.RestURIConstants.GET;
import static com.network.social.services.util.RestURIConstants.GET_ALL;
import static com.network.social.services.util.RestURIConstants.GET_FILTERING;
import static com.network.social.services.util.RestURIConstants.POST;
import static com.network.social.services.util.RestURIConstants.PUT;

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
import com.network.social.domain.util.BResult;
import com.network.social.services.service.ActividadService;
import com.network.social.services.util.UtilEnum.ESTADO_OPERACION;

/**
 * @author :Alexander Chavez Simbron
 * @date   :21/10/2015
 * @time   :16:12:17
 */
@RestController
@RequestMapping(value=ACTIVIDAD)
public class ServiceActividadController {
	Logger LOGGER=LoggerFactory.getLogger(ServiceActividadController.class);

	@Autowired
	private ActividadService actividadService;
	
	@RequestMapping(value=GET,method=RequestMethod.GET)
	private @ResponseBody Actividad get(@PathVariable Integer id){
		return actividadService.findById(id);
	}
	
	@RequestMapping(value=GET_ALL,method=RequestMethod.GET)
	private @ResponseBody List<Actividad> getAll(){
		return actividadService.findAll();
	}
	
	@RequestMapping(value=GET_FILTERING)
	private @ResponseBody List<Actividad> getFiltering(@PathVariable Integer filter){
		return actividadService.getAllbyUser(filter);
	}
	
	@RequestMapping(value=POST,method=RequestMethod.POST,consumes="application/json") 
	   private @ResponseBody BResult post(@RequestBody Actividad actividad){
		 
			LOGGER.info("## ServiceActividadController -->post");
			BResult bResult =null;
			try{
				if(actividad!=null){
					bResult=new BResult();
					bResult.setEstado(actividadService.save(actividad));
					LOGGER.info("## Album registrado ->"+bResult.getEstado());
					if (bResult.getEstado()>0) {
						bResult.setEstado(ESTADO_OPERACION.EXITO.getCodigo());
					}else{
						LOGGER.info("Error al Registrar Actividad -->"+actividad.getIdactividad());
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
	   private @ResponseBody BResult put(@RequestBody Actividad actividad){
		 
			LOGGER.info("## ServiceActividadController -->put");
			BResult bResult =null;
			try{
				if(actividad!=null){
					bResult=new BResult();
					actividadService.update(actividad);
					bResult.setEstado(ESTADO_OPERACION.CORRECTO.getCodigo());
					LOGGER.info("## Actividad actualizada ->"+actividad.getIdactividad());
					if (bResult.getEstado()>0) {
						bResult.setEstado(ESTADO_OPERACION.EXITO.getCodigo());
					}else{
						LOGGER.info("Error al Registrar Actividad -->"+actividad.getIdactividad());
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
		 
			LOGGER.info("## ServiceActividadController -->delete");
			BResult bResult =null;
			try{
				if(id>0){
					bResult=new BResult();
					Actividad actividad=new Actividad();
					actividad.setIdactividad(id);
					actividadService.delete(actividad);
					bResult.setEstado(ESTADO_OPERACION.CORRECTO.getCodigo());
					LOGGER.info("## Album eliminado ->"+bResult.getEstado());
					if (bResult.getEstado()>0) {
						bResult.setEstado(ESTADO_OPERACION.EXITO.getCodigo());
					}else{
						LOGGER.info("Error al eliminar Album -->"+actividad.getIdactividad());
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
