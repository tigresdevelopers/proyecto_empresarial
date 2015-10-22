package com.network.social.services.controller;

import static com.network.social.services.util.RestURIConstants.GET_ALL;
import static com.network.social.services.util.RestURIConstants.GRUPO_USUARIO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.network.social.domain.entities.GrupoUsuario;
import com.network.social.services.service.GrupoUsuarioService;
/**
 * @author :Alexander Chavez Simbron
 * @date   :21/10/2015
 * @time   :16:20:35
 */
@RestController
@RequestMapping(value=GRUPO_USUARIO)
public class ServiceGrupoUsuarioController {

	@Autowired
	private GrupoUsuarioService grupoUsuarioService;

	
	@RequestMapping(value=GET_ALL,method=RequestMethod.GET)
	private @ResponseBody List<GrupoUsuario> getAll(){
		return grupoUsuarioService.findAll();
	}
	
}
