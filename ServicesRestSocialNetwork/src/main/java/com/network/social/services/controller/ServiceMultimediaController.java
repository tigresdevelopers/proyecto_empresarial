package com.network.social.services.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.network.social.domain.entities.Album;
import com.network.social.domain.entities.Comentario;
import com.network.social.domain.entities.Multimedia;
import com.network.social.domain.entities.Publicacion;
import com.network.social.domain.util.BResult;
import com.network.social.domain.util.form.AlbumForm;
import com.network.social.domain.util.form.ComentarioForm;
import com.network.social.domain.util.form.MultimediaForm;
import com.network.social.domain.util.form.UsuarioForm;
import com.network.social.services.config.PropiedadService;
import com.network.social.services.service.MultimediaService;
import com.network.social.services.service.PublicacionService;
import com.network.social.services.util.UtilEnum;
import com.network.social.services.util.UtilEnum.ESTADO_OPERACION;
import com.network.social.services.util.UtilEnum.ESTADO_REGISTRO_BASE;

import static  com.network.social.services.util.RestURIConstants.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

	
	@RequestMapping(value=MULTIMEDIA_FIND,method=RequestMethod.GET)
	private ResponseEntity<MultimediaForm> find(@PathVariable Integer idmultimedia){
		
		MultimediaForm multimediaForm=new MultimediaForm();
		Multimedia multimedia=multimediaService.findById(idmultimedia);
		multimediaForm.setIdmultimedia(multimedia.getIdmultimedia());
		multimediaForm.setLikes(multimedia.getLikes());
		multimediaForm.setNombreArchivo(multimedia.getNombreArchivo());
		
		AlbumForm albumFrom=new AlbumForm();
		albumFrom.setIdalbum(multimedia.getAlbum().getIdalbum());
		
		multimediaForm.setAlbum(albumFrom);
		
		List<ComentarioForm> comentarioForms=new ArrayList<>();
		ComentarioForm comentarioForm=null;
		
		for (Comentario comentario : multimedia.getComentarios()) {
			 comentarioForm=new ComentarioForm();
			 comentarioForm.setIdcomentario(comentario.getIdcomentario());
//			 comentarioForm.setContenido(comentario.getContenido());
			 
			 UsuarioForm usuarioForm=new UsuarioForm();
			 usuarioForm.setIdusuario(comentario.getUsuario().getIdusuario());
			 
			 comentarioForm.setUsuario(usuarioForm);
			 comentarioForm.setLikes(comentario.getLikes());
			 comentarioForm.setMultimedia(multimediaForm);
		}
		
//		multimediaForm.setComentarios(multimedia.getComentarios());
//		multimediaForm.setEtiquetas(multimedia.getEtiquetas());
		
		return new ResponseEntity<MultimediaForm>(multimediaForm, HttpStatus.ACCEPTED);
	}
	
	
	@RequestMapping(value=MULTIMEDIA_CREATE,method=RequestMethod.POST)
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
	
	@RequestMapping(value=MULTIMEDIA_UPDATE,method=RequestMethod.POST)
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
	
	
	@RequestMapping(value=MULTIMEDIA_DELETE,method=RequestMethod.POST)
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


