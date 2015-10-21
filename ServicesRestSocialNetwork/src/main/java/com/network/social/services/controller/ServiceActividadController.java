package com.network.social.services.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.network.social.domain.entities.Actividad;
import com.network.social.domain.entities.Usuario;
import com.network.social.services.service.ActividadService;

import static com.network.social.services.util.RestURIConstants.*;

/**
 * @author :Alexander Chavez Simbron
 * @date   :21/10/2015
 * @time   :16:12:17
 */
@RestController
@RequestMapping(value=ACTIVIDAD)
public class ServiceActividadController {


	@Autowired
	private ActividadService actividadService;
	
	@RequestMapping(value=GET_ALL,method=RequestMethod.GET)
	private @ResponseBody List<Actividad> getAll(){
		return actividadService.findAll();
	}
	
	@RequestMapping(value=GET_FILTERING)
	private @ResponseBody List<Actividad> getFiltering(@PathVariable Integer filter){
		
		Actividad instance=new Actividad();
		instance.setIdusuario(filter);
		return actividadService.findByExample(instance);
	}
}
