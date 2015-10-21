package com.network.social.services.controller;

import static com.network.social.services.util.RestURIConstants.GET_ALL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.network.social.domain.entities.Publicacion;
import com.network.social.services.service.PublicacionService;

/**
* @author : Alexander Chavez Simbron
* @date   : 18 de oct. de 2015
* @time   : 8:34:53 p. m.
*/
@RestController
@RequestMapping(value="publicacion")
public class ServicePublicacionController {


	@Autowired
	private PublicacionService publicacionService;
	
	@RequestMapping(value=GET_ALL,method=RequestMethod.GET)
	private @ResponseBody List<Publicacion> getAll(){
		return publicacionService.findAll();
	}
	
}


