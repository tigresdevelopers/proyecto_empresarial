package com.network.social.services.controller;

import static com.network.social.services.util.RestURIConstants.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.network.social.domain.entities.Idioma;
import com.network.social.services.service.IdiomaService;
/**
 * @author :Alexander Chavez Simbron
 * @date   :21/10/2015
 * @time   :16:21:07
 */
@RestController
@RequestMapping(value=IDIOMA)
public class ServiceIdiomaController {


	@Autowired
	private IdiomaService idiomaService;
	
	@RequestMapping(value=GET,method=RequestMethod.GET)
	private @ResponseBody Idioma get(@PathVariable Integer id){
		return idiomaService.findById(id);
	}
	
	@RequestMapping(value=GET_FILTERING,method=RequestMethod.GET)
	private @ResponseBody List<Idioma> getAllbyUser(@PathVariable Integer filter){
		return idiomaService.getAllbyUser(filter);
	}
	
	@RequestMapping(value=GET_ALL,method=RequestMethod.GET)
	private @ResponseBody List<Idioma> getAll(){
		return idiomaService.findAll();
	}
}
