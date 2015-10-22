package com.network.social.services.controller;

import static com.network.social.services.util.RestURIConstants.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.network.social.domain.entities.Situacion;
import com.network.social.services.service.SituacionService;
/**
 * @author :Alexander Chavez Simbron
 * @date   :21/10/2015
 * @time   :16:23:23
 */
@RestController
@RequestMapping(value=SITUACION)
public class ServiceSituacionController {


	@Autowired
	private SituacionService situacionService;
	
	@RequestMapping(value=GET,method=RequestMethod.GET)
	private @ResponseBody Situacion get(@PathVariable Integer id){
		return situacionService.findById(id);
	}
	
	@RequestMapping(value=GET_ALL,method=RequestMethod.GET)
	private @ResponseBody List<Situacion> getAll(){
		return situacionService.findAll();
	}
	
}
