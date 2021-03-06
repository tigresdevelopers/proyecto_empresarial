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

import com.network.social.domain.entities.TipoContacto;
import com.network.social.domain.util.BResult;
import com.network.social.services.service.TipoContactoService;
import com.network.social.services.util.UtilEnum.ESTADO_OPERACION;
/**
 * @author :Alexander Chavez Simbron
 * @date   :21/10/2015
 * @time   :16:24:21
 */
@RestController
@RequestMapping(value=TIPO_CONTACTO)
public class ServiceTipoContactoController {

	Logger LOGGER=LoggerFactory.getLogger(ServiceTipoContactoController.class);
	
	@Autowired
	private TipoContactoService tipoContactoService;
	
	@RequestMapping(value=GET,method=RequestMethod.GET)
	private @ResponseBody TipoContacto get(@PathVariable Integer id){
		return tipoContactoService.findById(id);
	}
	
	@RequestMapping(value=GET_ALL,method=RequestMethod.GET)
	private @ResponseBody List<TipoContacto> getAll(){
		return tipoContactoService.findAll();
	}
	
	@RequestMapping(value=POST,method=RequestMethod.POST,consumes="application/json") 
	   private @ResponseBody BResult post(@RequestBody TipoContacto tipoContacto){
		 
			LOGGER.info("## ServiceTipoContactoController -->post");
			BResult bResult =null;
			try{
				if(tipoContacto!=null){
					bResult=new BResult();
					bResult.setEstado(tipoContactoService.save(tipoContacto));
					LOGGER.info("## tipoContacto registrado ->"+bResult.getEstado());
					if (bResult.getEstado()>0) {
						bResult.setEstado(ESTADO_OPERACION.EXITO.getCodigo());
					}else{
						LOGGER.info("Error al Registrar tipoContacto -->"+tipoContacto.getIdtipoContacto());
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
	   private @ResponseBody BResult put(@RequestBody TipoContacto tipoContacto){
		 
			LOGGER.info("## ServiceTipoContactoController -->put");
			BResult bResult =null;
			try{
				if(tipoContacto!=null){
					bResult=new BResult();
					tipoContactoService.update(tipoContacto);
					bResult.setEstado(ESTADO_OPERACION.CORRECTO.getCodigo());
					LOGGER.info("## tipoContacto actualizado ->"+tipoContacto.getIdtipoContacto());
					if (bResult.getEstado()>0) {
						bResult.setEstado(ESTADO_OPERACION.EXITO.getCodigo());
					}else{
						LOGGER.info("Error al Actualizar tipoContacto -->"+tipoContacto.getIdtipoContacto());
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
	   private @ResponseBody BResult delete(@RequestBody TipoContacto tipoContacto){
		 
			LOGGER.info("## ServiceTipoContactoController -->delete");
			BResult bResult =null;
			try{
				if(tipoContacto.getIdtipoContacto()>0){
					bResult=new BResult();
					tipoContactoService.delete(tipoContacto);
					bResult.setEstado(ESTADO_OPERACION.CORRECTO.getCodigo());
					LOGGER.info("## tipoContacto eliminado ->"+bResult.getEstado());
					if (bResult.getEstado()>0) {
						bResult.setEstado(ESTADO_OPERACION.EXITO.getCodigo());
					}else{
						LOGGER.info("Error al eliminar tipoContacto -->"+tipoContacto.getIdtipoContacto());
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
