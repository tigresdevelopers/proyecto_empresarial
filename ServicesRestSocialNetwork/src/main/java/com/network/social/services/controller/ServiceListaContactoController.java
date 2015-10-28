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

import com.network.social.domain.entities.Actividad;
import com.network.social.domain.entities.ListaContacto;
import com.network.social.domain.util.BResult;
import com.network.social.services.service.ActividadService;
import com.network.social.services.service.ListaContactoService;
import com.network.social.services.util.UtilEnum;
import com.network.social.services.util.UtilEnum.ESTADO_OPERACION;
/**
 * @author :Alexander Chavez Simbron
 * @date   :21/10/2015
 * @time   :16:22:07
 */
@RestController
@RequestMapping(value=LISTA_CONTACTO)
public class ServiceListaContactoController {

	Logger LOGGER=LoggerFactory.getLogger(ServiceListaContactoController.class);
	
	@Autowired
	private ListaContactoService listaContactoService;
	
	@Autowired
	private ActividadService actividadService;

	
	@RequestMapping(value=GET,method=RequestMethod.GET)
	private @ResponseBody ListaContacto get(@PathVariable Integer id){
		return listaContactoService.findById(id);
	}
	
	@RequestMapping(value=GET_FILTERING,method=RequestMethod.GET)
	private @ResponseBody List<ListaContacto> getAllbyUser(@PathVariable Integer filter){
		return listaContactoService.getAllbyUser(filter);
	}
	
	@RequestMapping(value=GET_ALL,method=RequestMethod.GET)
	private @ResponseBody List<ListaContacto> getAll(){
		return listaContactoService.findAll();
	}
	
	@RequestMapping(value=POST,method=RequestMethod.POST,consumes="application/json") 
	   private @ResponseBody BResult post(@RequestBody ListaContacto listaContacto){
		 
			LOGGER.info("## ServiceListaContactoontroller -->post");
			BResult bResult =null;
			try{
				if(listaContacto!=null){
					bResult=new BResult();
					bResult.setEstado(listaContactoService.save(listaContacto));
					
					Actividad historial=new Actividad();
					historial.setDescripcion(UtilEnum.MESSAGES.ACTIVIDAD_CREATE_LISTA.getMessage());
					historial.setIdusuario(listaContacto.getUsuario().getIdusuario());
					historial.setFechaActividad(new Date());

					actividadService.save(historial);
					
					LOGGER.info("## listaContacto registrado ->"+bResult.getEstado());
					if (bResult.getEstado()>0) {
						bResult.setEstado(ESTADO_OPERACION.EXITO.getCodigo());
					}else{
						LOGGER.info("Error al Registrar listaContacto -->"+listaContacto.getIdlistaContactos());
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
	   private @ResponseBody BResult put(@RequestBody ListaContacto listaContacto){
		 
			LOGGER.info("## ServiceListaContactoController -->put");
			BResult bResult =null;
			try{
				if(listaContacto!=null){
					bResult=new BResult();
					listaContactoService.update(listaContacto);
					bResult.setEstado(ESTADO_OPERACION.CORRECTO.getCodigo());
					
					Actividad historial=new Actividad();
					historial.setDescripcion(UtilEnum.MESSAGES.ACTIVIDAD_UPDATE_LISTA.getMessage());
					historial.setIdusuario(listaContacto.getUsuario().getIdusuario());
					historial.setFechaActividad(new Date());

					actividadService.save(historial);
					
					LOGGER.info("## listaContacto actualizado ->"+listaContacto.getIdlistaContactos());
					if (bResult.getEstado()>0) {
						bResult.setEstado(ESTADO_OPERACION.EXITO.getCodigo());
					}else{
						LOGGER.info("Error al Actualizar listaContacto -->"+listaContacto.getIdlistaContactos());
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
	   private @ResponseBody BResult delete(@RequestBody ListaContacto listaContacto){
		 
			LOGGER.info("## ServiceListaContactoController -->delete");
			BResult bResult =null;
			try{
				if(listaContacto.getIdlistaContactos()>0){
					bResult=new BResult();
					listaContactoService.delete(listaContacto);
					
					Actividad historial=new Actividad();
					historial.setDescripcion(UtilEnum.MESSAGES.ACTIVIDAD_DELETE_ETIQUETA.getMessage());
					historial.setIdusuario(listaContacto.getUsuario().getIdusuario());
					historial.setFechaActividad(new Date());

					actividadService.save(historial);
					
					bResult.setEstado(ESTADO_OPERACION.CORRECTO.getCodigo());
					LOGGER.info("## listaContacto eliminado ->"+bResult.getEstado());
					if (bResult.getEstado()>0) {
						bResult.setEstado(ESTADO_OPERACION.EXITO.getCodigo());
					}else{
						LOGGER.info("Error al eliminar listaContacto -->"+listaContacto.getIdlistaContactos());
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
