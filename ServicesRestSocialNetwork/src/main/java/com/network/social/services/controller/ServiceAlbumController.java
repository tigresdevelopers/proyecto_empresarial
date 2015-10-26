package com.network.social.services.controller;

import static com.network.social.services.util.RestURIConstants.ALBUM;
import static com.network.social.services.util.RestURIConstants.ALBUM_LIST_BY_USER;
import static com.network.social.services.util.RestURIConstants.DELETE;
import static com.network.social.services.util.RestURIConstants.GET;
import static com.network.social.services.util.RestURIConstants.GET_ALL;
import static com.network.social.services.util.RestURIConstants.GET_FILTERING;
import static com.network.social.services.util.RestURIConstants.GET_FILTERING_GROUP;
import static com.network.social.services.util.RestURIConstants.POST;
import static com.network.social.services.util.RestURIConstants.PUT;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.network.social.domain.entities.Album;
import com.network.social.domain.util.BResult;
import com.network.social.domain.util.ResultObject;
import com.network.social.services.service.AlbumService;
import com.network.social.services.util.UtilEnum.ESTADO_OPERACION;
/**
 * @author :Alexander Chavez Simbron
 * @date   :21/10/2015
 * @time   :16:12:17
 */
@RestController
@RequestMapping(value=ALBUM)
public class ServiceAlbumController {

	Logger LOGGER=LoggerFactory.getLogger(ServiceAlbumController.class);
	
	@Autowired
	private AlbumService albumService;
		
	
	@RequestMapping(value=GET,method=RequestMethod.GET)
	private @ResponseBody Album get(@PathVariable Integer id){
		return albumService.findById(id);
	}
	
	@RequestMapping(value=GET_ALL,method=RequestMethod.GET)
	private @ResponseBody List<Album> getAll(){
		return albumService.findAll();
	}
	
	@RequestMapping(value=GET_FILTERING,method=RequestMethod.GET)
	private @ResponseBody List<Album> getFiltering(@PathVariable Integer filter){
		return albumService.getAllbyUser(filter);
	}
	
	@RequestMapping(value=GET_FILTERING_GROUP,method=RequestMethod.GET)
	private @ResponseBody List<Album> getFilteringGroup(@PathVariable Integer filter){
		return albumService.getAllbyGrupo(filter);
	}
	
	@RequestMapping(value=ALBUM_LIST_BY_USER,method=RequestMethod.GET)
	private @ResponseBody ResultObject list(@PathVariable Integer idusuario){
		
		ResultObject result=new ResultObject();
		List<Map<String,Object>> data=new ArrayList<>();
	
		List<Album> lista=albumService.listAlbumbyUserId(idusuario);
			
			for (Album obj: lista) {
				Map<String, Object> map=new LinkedHashMap<>();
				map.put("id",obj.getIdalbum());
				map.put("nombre",obj.getNombre());
				map.put("descripcion",obj.getDescripcion());
				map.put("likes",obj.getLikes());
				data.add(map);
			}

		result.setData(data);

		return result;
	}
	
	@RequestMapping(value=POST,method=RequestMethod.POST,consumes="application/json") 
	   private @ResponseBody BResult post(@RequestBody Album album){
		 
			LOGGER.info("## ServiceAlbumController -->post");
			BResult bResult =null;
			try{
				if(album!=null){
					bResult=new BResult();
					bResult.setEstado(albumService.save(album));
					LOGGER.info("## Album registrado ->"+bResult.getEstado());
					if (bResult.getEstado()>0) {
						bResult.setEstado(ESTADO_OPERACION.EXITO.getCodigo());
					}else{
						LOGGER.info("Error al Registrar Album -->"+album.getIdalbum());
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
	   private @ResponseBody BResult put(@RequestBody Album album){
		 
			LOGGER.info("## ServiceAlbumController -->put");
			BResult bResult =null;
			try{
				if(album!=null){
					bResult=new BResult();
					albumService.update(album);
					bResult.setEstado(ESTADO_OPERACION.CORRECTO.getCodigo());
					LOGGER.info("## Album actualizado ->"+album.getIdalbum());
					if (bResult.getEstado()>0) {
						bResult.setEstado(ESTADO_OPERACION.EXITO.getCodigo());
					}else{
						LOGGER.info("Error al Registrar Album -->"+album.getIdalbum());
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
	   private @ResponseBody BResult delete(@RequestBody Album album){
		 
			LOGGER.info("## ServiceAlbumController -->delete");
			BResult bResult =null;
			try{
				if(album.getIdalbum()>0){
					albumService.delete(album);
					bResult=new BResult();
					bResult.setEstado(ESTADO_OPERACION.CORRECTO.getCodigo());
					LOGGER.info("## Album eliminado ->"+bResult.getEstado());
					if (bResult.getEstado()>0) {
						bResult.setEstado(ESTADO_OPERACION.EXITO.getCodigo());
					}else{
						LOGGER.info("Error al eliminar Album -->"+album.getIdalbum());
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
