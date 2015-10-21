package com.network.social.services.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.network.social.domain.entities.Etiqueta;
import com.network.social.services.service.EtiquetaService;

import static com.network.social.services.util.RestURIConstants.*;
/**
 * @author :Alexander Chavez Simbron
 * @date   :21/10/2015
 * @time   :16:19:29
 */
@RestController
@RequestMapping(value=ETIQUETA)
public class ServiceEtiquetaController {

	@Autowired
	private EtiquetaService etiquetaService;
	
	@RequestMapping(value=GET_ALL,method=RequestMethod.GET)
	private @ResponseBody List<Etiqueta> getEtiquetas(){
		return etiquetaService.findAll();
	}
	
}
