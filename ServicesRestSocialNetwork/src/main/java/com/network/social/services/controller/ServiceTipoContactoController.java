package com.network.social.services.controller;

import static com.network.social.services.util.RestURIConstants.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.network.social.domain.entities.TipoContacto;
import com.network.social.services.service.TipoContactoService;
/**
 * @author :Alexander Chavez Simbron
 * @date   :21/10/2015
 * @time   :16:24:21
 */
@RestController
@RequestMapping(value=TIPO_CONTACTO)
public class ServiceTipoContactoController {


	@Autowired
	private TipoContactoService tipoContactoService;
	
	@RequestMapping(value=GET_ALL,method=RequestMethod.GET)
	private @ResponseBody List<TipoContacto> getAll(){
		return tipoContactoService.findAll();
	}
}
