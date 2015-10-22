package com.network.social.services.controller;

import static com.network.social.services.util.RestURIConstants.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.network.social.domain.entities.ListaContacto;
import com.network.social.services.service.ListaContactoService;
/**
 * @author :Alexander Chavez Simbron
 * @date   :21/10/2015
 * @time   :16:22:07
 */
@RestController
@RequestMapping(value=LISTA_CONTACTO)
public class ServiceListaContactoController {

	@Autowired
	private ListaContactoService listaContactoService;
	
	@RequestMapping(value=GET,method=RequestMethod.GET)
	private @ResponseBody ListaContacto get(@PathVariable Integer id){
		return listaContactoService.findById(id);
	}
	
	@RequestMapping(value=GET_FILTERING,method=RequestMethod.GET)
	private @ResponseBody List<ListaContacto> getAllbyUser(@PathVariable Integer filter){
		return listaContactoService.getAllbyUser(filter);
	}
	
	@RequestMapping(value=GET_ALL,method=RequestMethod.GET)
	private @ResponseBody List<ListaContacto> getAll(){
		return listaContactoService.findAll();
	}
	
}
