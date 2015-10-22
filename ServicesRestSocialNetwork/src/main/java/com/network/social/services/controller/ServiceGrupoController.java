package com.network.social.services.controller;

import static com.network.social.services.util.RestURIConstants.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.network.social.domain.entities.Grupo;
import com.network.social.services.service.GrupoService;
/**
 * @author :Alexander Chavez Simbron
 * @date   :21/10/2015
 * @time   :16:20:05
 */
@RestController
@RequestMapping(value=GRUPO)
public class ServiceGrupoController {

	@Autowired
	private GrupoService grupoService;
	
	@RequestMapping(value=GET,method=RequestMethod.GET)
	private @ResponseBody Grupo get(@PathVariable Integer id){
		return grupoService.findById(id);
	}
	
	@RequestMapping(value=GET_FILTERING,method=RequestMethod.GET)
	private @ResponseBody List<Grupo> getAllbyUser(@PathVariable Integer filter){
		return grupoService.getAllbyUser(filter);
	}
	
	@RequestMapping(value=GET_ALL,method=RequestMethod.GET)
	private @ResponseBody List<Grupo> getAll(){
		return grupoService.findAll();
	}
}
