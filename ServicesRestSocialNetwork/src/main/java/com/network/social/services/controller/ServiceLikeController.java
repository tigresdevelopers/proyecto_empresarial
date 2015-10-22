package com.network.social.services.controller;

import static com.network.social.services.util.RestURIConstants.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.network.social.domain.entities.Like;
import com.network.social.services.service.LikeService;
/**
 * @author :Alexander Chavez Simbron
 * @date   :21/10/2015
 * @time   :16:21:30
 */
@RestController
@RequestMapping(value=LIKE)
public class ServiceLikeController {

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
}
