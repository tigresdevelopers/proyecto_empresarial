package com.network.social.services.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.network.social.domain.entities.Comentario;
import com.network.social.services.dao.ComentarioDao;
import com.network.social.services.service.ComentarioService;

@Service(value="comentarioService")
public class ComentarioServiceImpl extends BaseServiceImpl<Comentario, Integer> implements ComentarioService {

	ComentarioDao comentarioDao;
	
	@Autowired
	public ComentarioServiceImpl(ComentarioDao comentarioDao) {
		super(comentarioDao);
		this.comentarioDao=comentarioDao;
	}

}
