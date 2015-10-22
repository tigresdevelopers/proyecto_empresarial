package com.network.social.services.controller;

import static com.network.social.services.util.RestURIConstants.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@RequestMapping(value=GET,method=RequestMethod.GET)
	private @ResponseBody Publicacion get(@PathVariable Integer id){
		return publicacionService.findById(id);
	}
	
	@RequestMapping(value=GET_FILTERING,method=RequestMethod.GET)
	private @ResponseBody List<Publicacion> getAllbyUser(@PathVariable Integer filter){
		return publicacionService.getAllbyUser(filter);
	}
	
	@RequestMapping(value=GET_FILTERING_GROUP,method=RequestMethod.GET)
	private @ResponseBody List<Publicacion> getAllbyGrupo(@PathVariable Integer filter){
		return publicacionService.getAllbyGrupo(filter);
	}
	
	@RequestMapping(value=GET_FILTERING_TIPOCONTACTO,method=RequestMethod.GET)
	private @ResponseBody List<Publicacion> getAllbyUserTipo(@PathVariable Integer id,@PathVariable Integer filter){
		return publicacionService.getAllbyUserTipo(id,filter);
	}
	
	@RequestMapping(value=GET_FILTERING_LISTACONTACTO,method=RequestMethod.GET)
	private @ResponseBody List<Publicacion> getAllbyUserLista(@PathVariable Integer id,@PathVariable Integer filter){
		return publicacionService.getAllbyUserLista(id,filter);
	}
	@RequestMapping(value=GET_ALL,method=RequestMethod.GET)
	private @ResponseBody List<Publicacion> getAll(){
		return publicacionService.findAll();
	}
	
}


