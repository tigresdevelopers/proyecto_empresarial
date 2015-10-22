package com.network.social.services.controller;

import static com.network.social.services.util.RestURIConstants.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.network.social.domain.entities.Comentario;
import com.network.social.services.service.ComentarioService;
/**
 * @author :Alexander Chavez Simbron
 * @date   :21/10/2015
 * @time   :16:18:12
 */
@RestController
@RequestMapping(value=COMENTARIO)
public class ServiceComentarioController {

	@Autowired
	private ComentarioService comentarioService;
	
	
	@RequestMapping(value=GET,method=RequestMethod.GET)
	private @ResponseBody Comentario get(@PathVariable Integer id){
		return comentarioService.findById(id);
	}
	
	@RequestMapping(value=GET_FILTERING_MULTIMEDIA,method=RequestMethod.GET)
	private  @ResponseBody List<Comentario> getAllbyMultimedia(@PathVariable Integer filter){
		return comentarioService.getAllbyComentario(filter);
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
		return comentarioService.getAllbyPublicacion(filter);
	}
	
	@RequestMapping(value=GET_ALL,method=RequestMethod.GET)
	private @ResponseBody List<Comentario> getComentarios(){
		return comentarioService.findAll();
	}
	
}
