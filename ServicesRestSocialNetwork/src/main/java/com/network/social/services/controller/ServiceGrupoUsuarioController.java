package com.network.social.services.controller;

import static com.network.social.services.util.RestURIConstants.DELETE;
import static com.network.social.services.util.RestURIConstants.GET_ALL;
import static com.network.social.services.util.RestURIConstants.GRUPO_USUARIO;
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

import com.network.social.domain.entities.GrupoUsuario;
import com.network.social.domain.util.BResult;
import com.network.social.services.service.GrupoUsuarioService;
import com.network.social.services.util.UtilEnum.ESTADO_OPERACION;
/**
 * @author :Alexander Chavez Simbron
 * @date   :21/10/2015
 * @time   :16:20:35
 */
@RestController
@RequestMapping(value=GRUPO_USUARIO)
public class ServiceGrupoUsuarioController {
	
	Logger LOGGER=LoggerFactory.getLogger(ServiceGrupoUsuarioController.class);

	@Autowired
	private GrupoUsuarioService grupoUsuarioService;

	
	@RequestMapping(value=GET_ALL,method=RequestMethod.GET)
	private @ResponseBody List<GrupoUsuario> getAll(){
		return grupoUsuarioService.findAll();
	}
	
	@RequestMapping(value=POST,method=RequestMethod.POST,consumes="application/json") 
	   private @ResponseBody BResult post(@RequestBody GrupoUsuario grupoUsuario){
		 
			LOGGER.info("## ServiceGrupoUsuarioController -->post");
			BResult bResult =null;
			try{
				if(grupoUsuario!=null){
					bResult=new BResult();
					bResult.setEstado(grupoUsuarioService.save(grupoUsuario).getIdgrupo());
					LOGGER.info("## grupoUsuario registrado ->"+bResult.getEstado());
					if (bResult.getEstado()>0) {
						bResult.setEstado(ESTADO_OPERACION.EXITO.getCodigo());
					}else{
						LOGGER.info("Error al Registrar grupoUsuario -->"+grupoUsuario.getId());
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
	   private @ResponseBody BResult put(@RequestBody GrupoUsuario grupoUsuario){
		 
			LOGGER.info("## ServiceGrupoUsuarioController -->put");
			BResult bResult =null;
			try{
				if(grupoUsuario!=null){
					bResult=new BResult();
					grupoUsuarioService.update(grupoUsuario);
					bResult.setEstado(ESTADO_OPERACION.CORRECTO.getCodigo());
					LOGGER.info("## grupoUsuario actualizado ->"+grupoUsuario.getId());
					if (bResult.getEstado()>0) {
						bResult.setEstado(ESTADO_OPERACION.EXITO.getCodigo());
					}else{
						LOGGER.info("Error al Actualizar grupoUsuario -->"+grupoUsuario.getId());
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
	   private @ResponseBody BResult delete(@RequestBody GrupoUsuario grupoUsuario){
		 
			LOGGER.info("## ServiceGrupoUsuarioController -->delete");
			BResult bResult =null;
			try{
				if(grupoUsuario!=null){
					bResult=new BResult();
					grupoUsuarioService.delete(grupoUsuario);
					bResult.setEstado(ESTADO_OPERACION.CORRECTO.getCodigo());
					LOGGER.info("## grupoUsuario eliminado ->"+bResult.getEstado());
					if (bResult.getEstado()>0) {
						bResult.setEstado(ESTADO_OPERACION.EXITO.getCodigo());
					}else{
						LOGGER.info("Error al eliminar grupoUsuario -->"+grupoUsuario.getId());
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
