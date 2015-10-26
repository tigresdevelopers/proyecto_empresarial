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

import com.network.social.domain.entities.Comentario;
import com.network.social.domain.util.BResult;
import com.network.social.services.service.ComentarioService;
import com.network.social.services.util.UtilEnum.ESTADO_OPERACION;
/**
 * @author :Alexander Chavez Simbron
 * @date   :21/10/2015
 * @time   :16:18:12
 */
@RestController
@RequestMapping(value=COMENTARIO)
public class ServiceComentarioController {
	Logger LOGGER=LoggerFactory.getLogger(ServiceComentarioController.class);
	
	@Autowired
	private ComentarioService comentarioService;
	
	
	@RequestMapping(value=GET,method=RequestMethod.GET)
	private @ResponseBody Comentario get(@PathVariable Integer id){
		return comentarioService.findById(id);
	}
	
	@RequestMapping(value=GET_FILTERING_MULTIMEDIA,method=RequestMethod.GET)
	private  @ResponseBody List<Comentario> getAllbyMultimedia(@PathVariable Integer filter){
		return comentarioService.getAllbyMultimedia(filter);
	}
	
	@RequestMapping(value=GET_FILTERING_ALBUM,method=RequestMethod.GET)
	private @ResponseBody List<Comentario> getAllbyAlbum(@PathVariable Integer filter){
		return comentarioService.getAllbyAlbum(filter);
	}
	
	@RequestMapping(value=GET_FILTERING_PUBLICACION,method=RequestMethod.GET)
	private @ResponseBody List<Comentario> getAllbyPublicacion(@PathVariable Integer filter){
		return comentarioService.getAllbyPublicacion(filter);
	}
	
	@RequestMapping(value=GET_FILTERING_COMENTARIO,method=RequestMethod.GET)
	private @ResponseBody List<Comentario> getAllbyComentario(@PathVariable Integer filter){
		return comentarioService.getAllbyComentario(filter);
	}
	
	@RequestMapping(value=GET_ALL,method=RequestMethod.GET)
	private @ResponseBody List<Comentario> getComentarios(){
		return comentarioService.findAll();
	}
	
	@RequestMapping(value=POST,method=RequestMethod.POST,consumes="application/json") 
	   private @ResponseBody BResult post(@RequestBody Comentario comentario){
		 
			LOGGER.info("## ServiceComentarioController -->post");
			BResult bResult =null;
			try{
				if(comentario!=null){
					bResult=new BResult();
					bResult.setEstado(comentarioService.save(comentario));
					LOGGER.info("## Comentario registrado ->"+bResult.getEstado());
					if (bResult.getEstado()>0) {
						bResult.setEstado(ESTADO_OPERACION.EXITO.getCodigo());
					}else{
						LOGGER.info("Error al Registrar Comentario -->"+comentario.getIdcomentario());
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
	   private @ResponseBody BResult put(@RequestBody Comentario comentario){
		 
			LOGGER.info("## ServiceComentarioController -->put");
			BResult bResult =null;
			try{
				if(comentario!=null){
					bResult=new BResult();
					comentarioService.update(comentario);
					bResult.setEstado(ESTADO_OPERACION.CORRECTO.getCodigo());
					LOGGER.info("## comentario actualizado ->"+comentario.getIdcomentario());
					if (bResult.getEstado()>0) {
						bResult.setEstado(ESTADO_OPERACION.EXITO.getCodigo());
					}else{
						LOGGER.info("Error al Actualizar comentario -->"+comentario.getIdcomentario());
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
	   private @ResponseBody BResult delete(@RequestBody Comentario comentario){
		 
			LOGGER.info("## ServiceCoemntarioController -->delete");
			BResult bResult =null;
			try{
				if(comentario.getIdcomentario()>0){
					bResult=new BResult();
					comentarioService.delete(comentario);
					bResult.setEstado(ESTADO_OPERACION.CORRECTO.getCodigo());
					LOGGER.info("## Comentario eliminado ->"+bResult.getEstado());
					if (bResult.getEstado()>0) {
						bResult.setEstado(ESTADO_OPERACION.EXITO.getCodigo());
					}else{
						LOGGER.info("Error al eliminar Comentario -->"+comentario.getIdcomentario());
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
