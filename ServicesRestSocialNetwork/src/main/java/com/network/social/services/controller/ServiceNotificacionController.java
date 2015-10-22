package com.network.social.services.controller;

import static com.network.social.services.util.RestURIConstants.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.network.social.domain.entities.Notificacion;
import com.network.social.services.service.NotificacionService;
/**
 * @author :Alexander Chavez Simbron
 * @date   :21/10/2015
 * @time   :16:22:35
 */
@RestController
@RequestMapping(value=NOTIFICACION)
public class ServiceNotificacionController {

	@Autowired
	private NotificacionService notificacionService;
	
	
	@RequestMapping(value=GET,method=RequestMethod.GET)
	private @ResponseBody Notificacion get(@PathVariable Integer id){
		return notificacionService.findById(id);
	}
	
	@RequestMapping(value=GET_FILTERING,method=RequestMethod.GET)
	private @ResponseBody List<Notificacion> getAllbyUser(@PathVariable Integer filter){
		return notificacionService.getAllbyUser(filter);
	}
	
	@RequestMapping(value=GET_ALL,method=RequestMethod.GET)
	private @ResponseBody List<Notificacion> getAll(){
		return notificacionService.findAll();
	}
	
}
