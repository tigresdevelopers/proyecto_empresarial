package com.network.social.services.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.network.social.domain.entities.GrupoUsuario;
import com.network.social.domain.entities.GrupoUsuarioId;
import com.network.social.services.dao.GrupoUsuarioDao;
import com.network.social.services.service.GrupoUsuarioService;

/**
* @author : Alexander Chavez Simbron
* @date   : 19 de oct. de 2015
* @time   : 11:41:43 p. m.
*/
@Service(value="grupoUsuarioService")
public class GrupoUsuarioServiceImpl extends BaseServiceImpl<GrupoUsuario, GrupoUsuarioId> implements GrupoUsuarioService {

	@Autowired
	public GrupoUsuarioServiceImpl(GrupoUsuarioDao grupoUsuarioDao) {
		super(grupoUsuarioDao);
	}
}


