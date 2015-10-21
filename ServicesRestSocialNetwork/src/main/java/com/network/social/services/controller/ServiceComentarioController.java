package com.network.social.services.controller;

import static com.network.social.services.util.RestURIConstants.COMENTARIO;
import static com.network.social.services.util.RestURIConstants.GET_ALL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	
	@RequestMapping(value=GET_ALL,method=RequestMethod.GET)
	public @ResponseBody List<Comentario> getComentarios(){
		return comentarioService.findAll();
	}
	
}
