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

import com.network.social.domain.entities.Grupo;
import com.network.social.domain.util.BResult;
import com.network.social.services.service.GrupoService;
import com.network.social.services.util.UtilEnum.ESTADO_OPERACION;
/**
 * @author :Alexander Chavez Simbron
 * @date   :21/10/2015
 * @time   :16:20:05
 */
@RestController
@RequestMapping(value=GRUPO)
public class ServiceGrupoController {

	Logger LOGGER=LoggerFactory.getLogger(ServiceGrupoController.class);
	
	@Autowired
	private GrupoService grupoService;
	
	@RequestMapping(value=GET,method=RequestMethod.GET)
	private @ResponseBody Grupo get(@PathVariable Integer id){
		return grupoService.findById(id);
	}
	
	@RequestMapping(value=GET_FILTERING,method=RequestMethod.GET)
	private @ResponseBody List<Grupo> getAllbyUser(@PathVariable Integer filter){
		return grupoService.getAllbyUser(filter);
	}
	
	@RequestMapping(value=GET_ALL,method=RequestMethod.GET)
	private @ResponseBody List<Grupo> getAll(){
		return grupoService.findAll();
	}
	
	@RequestMapping(value=POST,method=RequestMethod.POST,consumes="application/json") 
	   private @ResponseBody BResult post(@RequestBody Grupo grupo){
		 
			LOGGER.info("## ServicgrupoController -->post");
			BResult bResult =null;
			try{
				if(grupo!=null){
					bResult=new BResult();
					bResult.setEstado(grupoService.save(grupo));
					LOGGER.info("## grupo registrado ->"+bResult.getEstado());
					if (bResult.getEstado()>0) {
						bResult.setEstado(ESTADO_OPERACION.EXITO.getCodigo());
					}else{
						LOGGER.info("Error al Registrar grupo -->"+grupo.getIdgrupo());
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
	   private @ResponseBody BResult put(@RequestBody Grupo grupo){
		 
			LOGGER.info("## ServiceGrupoController -->put");
			BResult bResult =null;
			try{
				if(grupo!=null){
					bResult=new BResult();
					grupoService.update(grupo);
					bResult.setEstado(ESTADO_OPERACION.CORRECTO.getCodigo());
					LOGGER.info("## grupo actualizado ->"+grupo.getIdgrupo());
					if (bResult.getEstado()>0) {
						bResult.setEstado(ESTADO_OPERACION.EXITO.getCodigo());
					}else{
						LOGGER.info("Error al Actualizar grupo -->"+grupo.getIdgrupo());
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
		 
			LOGGER.info("## ServiceGrupoController -->delete");
			BResult bResult =null;
			try{
				if(id>0){
					bResult=new BResult();
					Grupo grupo=new Grupo();
					grupo.setIdgrupo(id);
					grupoService.delete(grupo);
					bResult.setEstado(ESTADO_OPERACION.CORRECTO.getCodigo());
					LOGGER.info("## grupo eliminado ->"+bResult.getEstado());
					if (bResult.getEstado()>0) {
						bResult.setEstado(ESTADO_OPERACION.EXITO.getCodigo());
					}else{
						LOGGER.info("Error al eliminar grupo -->"+grupo.getIdgrupo());
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