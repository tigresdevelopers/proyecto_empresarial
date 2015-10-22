package com.network.social.services.controller;

import static com.network.social.services.util.RestURIConstants.*;
import static com.network.social.services.util.RestURIConstants.GET;
import static com.network.social.services.util.RestURIConstants.GET_ALL;
import static com.network.social.services.util.RestURIConstants.MULTIMEDIA;
import static com.network.social.services.util.RestURIConstants.MULTIMEDIA_BULKINSERT;
import static com.network.social.services.util.RestURIConstants.POST;
import static com.network.social.services.util.RestURIConstants.PUT;

import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.network.social.domain.entities.Album;
import com.network.social.domain.entities.Multimedia;
import com.network.social.domain.entities.Publicacion;
import com.network.social.domain.util.BResult;
import com.network.social.services.config.PropiedadService;
import com.network.social.services.service.MultimediaService;
import com.network.social.services.service.PublicacionService;
import com.network.social.services.util.UtilEnum;
import com.network.social.services.util.UtilEnum.ESTADO_OPERACION;

/**
* @author : Alexander Chavez Simbron
* @date   : 18 de oct. de 2015
* @time   : 11:38:51 p. m.
*/
@RestController
@RequestMapping(value=MULTIMEDIA)
public class ServiceMultimediaController {

	private static final Logger LOGGER =LoggerFactory.getLogger(ServiceMultimediaController.class);
	
	@Autowired
	private PropiedadService propiedadService;
	
	@Autowired
	private PublicacionService publicacionService;
	
	@Autowired
	private MultimediaService multimediaService;

	
	@RequestMapping(value=GET,method=RequestMethod.GET)
	private ResponseEntity<Multimedia> get(@PathVariable Integer id){
		
		Multimedia multimedia=multimediaService.findById(id);
		return new ResponseEntity<Multimedia>(multimedia, HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(value=GET_ALL,method=RequestMethod.GET)
	private @ResponseBody List<Multimedia> getAll(){
		return multimediaService.findAll();
	}
	
	@RequestMapping(value=GET_FILTERING,method=RequestMethod.GET)
	private @ResponseBody List<Multimedia> getAllbyUser(@PathVariable Integer filter){
		return multimediaService.getAllbyUser(filter);
	}
	
	@RequestMapping(value=GET_FILTERING_ALBUM,method=RequestMethod.GET)
	private @ResponseBody List<Multimedia> getAllbyAlbum(@PathVariable Integer filter){
		return multimediaService.getAllbyAlbum(filter);
	}
	
	@RequestMapping(value=GET_FILTERING_GROUP,method=RequestMethod.GET)
	private @ResponseBody List<Multimedia> getAllbyGrupo(@PathVariable Integer filter){
		return multimediaService.getAllbyGrupo(filter);
	}
	
	@RequestMapping(value=GET_FILTERING_PUBLICACION,method=RequestMethod.GET)
	private @ResponseBody List<Multimedia> getAllbyPublicacion(@PathVariable Integer filter){
		return multimediaService.getAllbyPublicacion(filter);
	}
	
	
	@RequestMapping(value=POST,method=RequestMethod.POST)
	private @ResponseBody BResult create(@RequestBody Multimedia multimedia){

		LOGGER.info("## ServiceMultimedia -->create");
		BResult bResult =null;
		try{
			if(multimedia!=null){
				bResult=new BResult();
				
				Publicacion publicacion=new Publicacion();
				publicacion.setContenido(propiedadService.getProperty(UtilEnum.MESSAGES.PUBLICACION_GENERADA_FOTO.getMessage())
						.replace("{username}",multimedia.getAlbum().getUsuario().getNombre()));
				publicacion.setUsuarioByIdusuario(multimedia.getAlbum().getUsuario());
				publicacion.setUsuarioByIdusuarioReceiver(multimedia.getAlbum().getUsuario());
				
				//create publish before to create photo or video
				Integer idPublicacion=publicacionService.save(publicacion);
				
				publicacion.setIdpublicacion(idPublicacion);
				
				//setter idPublicacion to file
				multimedia.setPublicacion(publicacion);
				
				//create file into database
				bResult.setEstado(multimediaService.save(multimedia));
				
				if (bResult.getEstado()>0) {
					bResult.setEstado(ESTADO_OPERACION.EXITO.getCodigo());
				}else{
					LOGGER.info("Error al registrar Multimedia -->"+multimedia.getIdmultimedia()+":"+multimedia.getNombreArchivo());
					bResult = new BResult();
					bResult.setEstado(ESTADO_OPERACION.TRANSACCION_NO_PROCESADO.getCodigo());
				}
			}	
		}catch(Exception ex){
			LOGGER.info("EXCEPTION SERVICE", ex);
			bResult = new BResult();
			bResult.setEstado(ESTADO_OPERACION.EXCEPTION.getCodigo());
			bResult.setMensaje("excepion proceso");
		}
		LOGGER.info("## response :"+bResult.getCodigo());
		return bResult;
	}
	
	
	@RequestMapping(value=MULTIMEDIA_BULKINSERT,method=RequestMethod.POST)
	private @ResponseBody BResult bulkinsert(@RequestBody List<Multimedia> multimedias){

		LOGGER.info("## ServiceMultimedia -->bulkInsert");
		BResult bResult =null;
		try{
			if(multimedias!=null && multimedias.size()>0){
				bResult=new BResult();
				
				Album album=multimedias.get(0).getAlbum();
				
				Publicacion publicacion=new Publicacion();
				publicacion.setContenido(propiedadService.getProperty(UtilEnum.MESSAGES.PUBLICACION_GENERADA_FOTOS.getMessage())
						.replace("{username}",album.getUsuario().getNombre()));
				publicacion.setUsuarioByIdusuario(album.getUsuario());
				publicacion.setUsuarioByIdusuarioReceiver(album.getUsuario());
				
				//create publish before to create photos or videos
				Integer idPublicacion=publicacionService.save(publicacion);
				
				publicacion.setIdpublicacion(idPublicacion);
				
				//setter idPublicacion to list of photos or videos
				for (Iterator<Multimedia> iterator = multimedias.iterator(); iterator.hasNext();) {
					Multimedia multimedia = (Multimedia) iterator.next();
					multimedia.setPublicacion(publicacion);
				}
//				for (Multimedia multimedia : multimedias) {
//					multimedia.setPublicacion(publicacion);
//				}
				
				//insert files into database
				multimediaService.saveCollection(multimedias);
				bResult.setEstado(multimedias.size());
				
				if (bResult.getEstado()>0) {
					bResult.setEstado(ESTADO_OPERACION.EXITO.getCodigo());
				}else{
					LOGGER.info("Error al registrar --> Archivos Multimedia");
					bResult = new BResult();
					bResult.setEstado(ESTADO_OPERACION.TRANSACCION_NO_PROCESADO.getCodigo());
				}
			}else{
				bResult=new BResult();
				bResult.setEstado(ESTADO_OPERACION.ERROR_DATOS_FORMULARIO.getCodigo());
			}	
		}catch(Exception ex){
			LOGGER.info("EXCEPTION SERVICE", ex);
			bResult = new BResult();
			bResult.setEstado(ESTADO_OPERACION.EXCEPTION.getCodigo());
			bResult.setMensaje("excepion proceso");
		}
		LOGGER.info("## response :"+bResult.getCodigo());
		return bResult;
	}
	
	@RequestMapping(value=PUT,method=RequestMethod.POST)
	private @ResponseBody BResult update(@RequestBody Multimedia multimedia){

		LOGGER.info("## ServiceMultimedia -->update");
		BResult bResult =null;
		try{
			if(multimedia!=null){
				bResult=new BResult();
				
				Publicacion publicacion=new Publicacion();
				publicacion.setContenido(propiedadService.getProperty(UtilEnum.MESSAGES.PUBLICACION_GENERADA_FOTO_UPDATE.getMessage())
						.replace("{username}",multimedia.getAlbum().getUsuario().getNombre()));
				publicacion.setUsuarioByIdusuario(multimedia.getAlbum().getUsuario());
				publicacion.setUsuarioByIdusuarioReceiver(multimedia.getAlbum().getUsuario());
				
				//create publish before to create photo or video
				Integer idPublicacion=publicacionService.save(publicacion);
				
				publicacion.setIdpublicacion(idPublicacion);
				
				//setter idPublicacion to file
				multimedia.setPublicacion(publicacion);
				
				//create file into database
				multimediaService.update(multimedia);
				bResult.setEstado(multimedia.getIdmultimedia());
				
				if (bResult.getEstado()>0) {
					bResult.setEstado(ESTADO_OPERACION.EXITO.getCodigo());
				}else{
					LOGGER.info("Error al actualizar Multimedia -->"+multimedia.getIdmultimedia()+":"+multimedia.getNombreArchivo());
					bResult = new BResult();
					bResult.setEstado(ESTADO_OPERACION.TRANSACCION_NO_PROCESADO.getCodigo());
				}
			}	
		}catch(Exception ex){
			LOGGER.info("EXCEPTION SERVICE", ex);
			bResult = new BResult();
			bResult.setEstado(ESTADO_OPERACION.EXCEPTION.getCodigo());
			bResult.setMensaje("excepion proceso");
		}
		LOGGER.info("## response :"+bResult.getCodigo());
		return bResult;
	}
	
	
	@RequestMapping(value=DELETE,method=RequestMethod.POST)
	private @ResponseBody BResult delete(@RequestBody Multimedia multimedia){

		LOGGER.info("## ServiceMultimedia -->delete");
		BResult bResult =null;
		try{
			if(multimedia!=null){
				bResult=new BResult();
				
				//delete  file from database
				multimediaService.delete(multimedia);
				bResult.setEstado(multimedia.getIdmultimedia());
				
				if (bResult.getEstado()>0) {
					bResult.setEstado(ESTADO_OPERACION.EXITO.getCodigo());
				}else{
					LOGGER.info("Error al eliminar Multimedia -->"+multimedia.getIdmultimedia()+":"+multimedia.getNombreArchivo());
					bResult = new BResult();
					bResult.setEstado(ESTADO_OPERACION.TRANSACCION_NO_PROCESADO.getCodigo());
				}
			}	
		}catch(Exception ex){
			LOGGER.info("EXCEPTION SERVICE", ex);
			bResult = new BResult();
			bResult.setEstado(ESTADO_OPERACION.EXCEPTION.getCodigo());
			bResult.setMensaje("excepion proceso");
		}
		LOGGER.info("## response :"+bResult.getCodigo());
		return bResult;
	}
}


