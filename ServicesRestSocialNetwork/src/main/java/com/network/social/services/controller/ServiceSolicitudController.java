package com.network.social.services.controller;

import static com.network.social.services.util.RestURIConstants.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.network.social.domain.entities.Solicitud;
import com.network.social.services.service.SolicitudService;
/**
 * @author :Alexander Chavez Simbron
 * @date   :21/10/2015
 * @time   :16:23:53
 */
@RestController
@RequestMapping(value=SOLICITUD)
public class ServiceSolicitudController {

	@Autowired
	private SolicitudService solicitudService;
	
	
	@RequestMapping(value=GET,method=RequestMethod.GET)
	private @ResponseBody Solicitud get(@PathVariable Integer id){
		return solicitudService.findById(id);
	}
	
	@RequestMapping(value=GET_FILTERING,method=RequestMethod.GET)
	private @ResponseBody List<Solicitud> getAllbyUser(@PathVariable Integer filter){
		return solicitudService.getAllbyUser(filter);
	}

	@RequestMapping(value=GET_ALL,method=RequestMethod.GET)
	private @ResponseBody List<Solicitud> getAll(){
		return solicitudService.findAll();
	}
	
}
