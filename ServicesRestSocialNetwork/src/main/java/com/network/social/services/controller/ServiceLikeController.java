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

import com.network.social.domain.entities.Like;
import com.network.social.domain.util.BResult;
import com.network.social.services.service.LikeService;
import com.network.social.services.util.UtilEnum.ESTADO_OPERACION;
/**
 * @author :Alexander Chavez Simbron
 * @date   :21/10/2015
 * @time   :16:21:30
 */
@RestController
@RequestMapping(value=LIKE)
public class ServiceLikeController {

	Logger LOGGER=LoggerFactory.getLogger(ServiceLikeController.class);
	
	@Autowired
	private LikeService likeService;
	
	@RequestMapping(value=GET,method=RequestMethod.GET)
	private @ResponseBody Like get(@PathVariable Integer id){
		return likeService.findById(id);
	}
	
	@RequestMapping(value=GET_FILTERING_MULTIMEDIA,method=RequestMethod.GET)
	private @ResponseBody List<Like> getAllbyMultimedia(@PathVariable Integer filter){
		return likeService.getAllbyMultimedia(filter);
	}
	
	@RequestMapping(value=GET_FILTERING_ALBUM,method=RequestMethod.GET)
	private @ResponseBody List<Like> getAllbyAlbum(@PathVariable Integer filter){
		return likeService.getAllbyAlbum(filter);
	}
	
	@RequestMapping(value=GET_FILTERING_PUBLICACION,method=RequestMethod.GET)
	private @ResponseBody List<Like> getAllbyPublicacion(@PathVariable Integer filter){
		return likeService.getAllbyPublicacion(filter);
	}
	
	@RequestMapping(value=GET_FILTERING_COMENTARIO,method=RequestMethod.GET)
	private @ResponseBody List<Like> getAllbyComentario(@PathVariable Integer filter){
		return likeService.getAllbyComentario(filter);
	}
	
	@RequestMapping(value=GET_ALL,method=RequestMethod.GET)
	private @ResponseBody List<Like> getAll(){
		return likeService.findAll();
	}
	
	
	@RequestMapping(value=POST,method=RequestMethod.POST,consumes="application/json") 
	   private @ResponseBody BResult post(@RequestBody Like like){
		 
			LOGGER.info("## ServiceLikeController -->post");
			BResult bResult =null;
			try{
				if(like!=null){
					bResult=new BResult();
					bResult.setEstado(likeService.save(like));
					LOGGER.info("## like registrado ->"+bResult.getEstado());
					if (bResult.getEstado()>0) {
						bResult.setEstado(ESTADO_OPERACION.EXITO.getCodigo());
					}else{
						LOGGER.info("Error al Registrar like -->"+like.getIdlike());
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
	   private @ResponseBody BResult put(@RequestBody Like like){
		 
			LOGGER.info("## ServiceLikeController -->put");
			BResult bResult =null;
			try{
				if(like!=null){
					bResult=new BResult();
					likeService.update(like);
					bResult.setEstado(ESTADO_OPERACION.CORRECTO.getCodigo());
					LOGGER.info("## like actualizado ->"+like.getIdlike());
					if (bResult.getEstado()>0) {
						bResult.setEstado(ESTADO_OPERACION.EXITO.getCodigo());
					}else{
						LOGGER.info("Error al Actualizar like -->"+like.getIdlike());
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
		 
			LOGGER.info("## ServiceLikeController -->delete");
			BResult bResult =null;
			try{
				if(id>0){
					bResult=new BResult();
					Like like=new Like();
					like.setIdlike(id);
					likeService.delete(like);
					bResult.setEstado(ESTADO_OPERACION.CORRECTO.getCodigo());
					LOGGER.info("## like eliminado ->"+bResult.getEstado());
					if (bResult.getEstado()>0) {
						bResult.setEstado(ESTADO_OPERACION.EXITO.getCodigo());
					}else{
						LOGGER.info("Error al eliminar like -->"+like.getIdlike());
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
