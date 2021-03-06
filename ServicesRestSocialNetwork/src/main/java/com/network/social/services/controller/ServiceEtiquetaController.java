package com.network.social.services.controller;

import static com.network.social.services.util.RestURIConstants.DELETE;
import static com.network.social.services.util.RestURIConstants.ETIQUETA;
import static com.network.social.services.util.RestURIConstants.GET;
import static com.network.social.services.util.RestURIConstants.GET_ALL;
import static com.network.social.services.util.RestURIConstants.GET_FILTERING_MULTIMEDIA;
import static com.network.social.services.util.RestURIConstants.POST;
import static com.network.social.services.util.RestURIConstants.PUT;

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
import com.network.social.domain.entities.Etiqueta;
import com.network.social.domain.util.BResult;
import com.network.social.services.service.ActividadService;
import com.network.social.services.service.EtiquetaService;
import com.network.social.services.util.UtilEnum;
import com.network.social.services.util.UtilEnum.ESTADO_OPERACION;
/**
 * @author :Alexander Chavez Simbron
 * @date   :21/10/2015
 * @time   :16:19:29
 */
@RestController
@RequestMapping(value=ETIQUETA)
public class ServiceEtiquetaController {

	Logger LOGGER=LoggerFactory.getLogger(ServiceEtiquetaController.class);
	
	@Autowired
	private EtiquetaService etiquetaService;
	
	@Autowired
	private ActividadService actividadService;
	
	
	@RequestMapping(value=GET,method=RequestMethod.GET)
	private @ResponseBody Etiqueta get(@PathVariable Integer id){
		return etiquetaService.findById(id);
	}
	
	@RequestMapping(value=GET_FILTERING_MULTIMEDIA,method=RequestMethod.GET)
	private @ResponseBody List<Etiqueta> getAllbyMultimedia(@PathVariable Integer filter){
		return etiquetaService.getAllbyMultimedia(filter);
	}
	
	@RequestMapping(value=GET_ALL,method=RequestMethod.GET)
	private @ResponseBody List<Etiqueta> getEtiquetas(){
		return etiquetaService.findAll();
	}
	
	@RequestMapping(value=POST,method=RequestMethod.POST,consumes="application/json") 
	   private @ResponseBody BResult post(@RequestBody Etiqueta etiqueta){
		 
			LOGGER.info("## ServicEtiquetaController -->post");
			BResult bResult =null;
			try{
				if(etiqueta!=null){
					bResult=new BResult();
					bResult.setEstado(etiquetaService.save(etiqueta));
					LOGGER.info("## Etiqueta registrado ->"+bResult.getEstado());
					
					Actividad historial=new Actividad();
					historial.setDescripcion(UtilEnum.MESSAGES.ACTIVIDAD_CREATE_ETIQUETA.getMessage());
					historial.setIdusuario(etiqueta.getUsuario().getIdusuario());
					historial.setFechaActividad(new Date());

					actividadService.save(historial);
					
					if (bResult.getEstado()>0) {
						bResult.setEstado(ESTADO_OPERACION.EXITO.getCodigo());
					}else{
						LOGGER.info("Error al Registrar Etiqueta -->"+etiqueta.getIdetiqueta());
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
	   private @ResponseBody BResult put(@RequestBody Etiqueta etiqueta){
		 
			LOGGER.info("## ServiceEtiquetaController -->put");
			BResult bResult =null;
			try{
				if(etiqueta!=null){
					bResult=new BResult();
					etiquetaService.update(etiqueta);
					
					Actividad historial=new Actividad();
					historial.setDescripcion(UtilEnum.MESSAGES.ACTIVIDAD_UPDATE_ETIQUETA.getMessage());
					historial.setIdusuario(etiqueta.getUsuario().getIdusuario());
					historial.setFechaActividad(new Date());

					actividadService.save(historial);
					
					bResult.setEstado(ESTADO_OPERACION.CORRECTO.getCodigo());
					LOGGER.info("## etiqueta actualizado ->"+etiqueta.getIdetiqueta());
					if (bResult.getEstado()>0) {
						bResult.setEstado(ESTADO_OPERACION.EXITO.getCodigo());
					}else{
						LOGGER.info("Error al Actualizar etiqueta -->"+etiqueta.getIdetiqueta());
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
	   private @ResponseBody BResult delete(@RequestBody Etiqueta etiqueta){
		 
			LOGGER.info("## ServiceCoemntarioController -->delete");
			BResult bResult =null;
			try{
				if(etiqueta.getIdetiqueta()>0){
					bResult=new BResult();
					etiquetaService.delete(etiqueta);
					
					Actividad historial=new Actividad();
					historial.setDescripcion(UtilEnum.MESSAGES.ACTIVIDAD_DELETE_ALBUM.getMessage());
					historial.setIdusuario(etiqueta.getUsuario().getIdusuario());
					historial.setFechaActividad(new Date());

					actividadService.save(historial);
					
					bResult.setEstado(ESTADO_OPERACION.CORRECTO.getCodigo());
					LOGGER.info("## Etiqueta eliminado ->"+bResult.getEstado());
					if (bResult.getEstado()>0) {
						bResult.setEstado(ESTADO_OPERACION.EXITO.getCodigo());
					}else{
						LOGGER.info("Error al eliminar etiqueta -->"+etiqueta.getIdetiqueta());
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
