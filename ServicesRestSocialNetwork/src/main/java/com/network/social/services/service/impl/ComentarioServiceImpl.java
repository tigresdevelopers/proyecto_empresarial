package com.network.social.services.service.impl;

import java.util.List;

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

	@Override
	public List<Comentario> getAllbyMultimedia(Integer id) {
		return comentarioDao.getAllbyMultimedia(id);
	}

	@Override
	public List<Comentario> getAllbyAlbum(Integer id) {
		return comentarioDao.getAllbyAlbum(id);
	}

	@Override
	public List<Comentario> getAllbyPublicacion(Integer id) {
		return comentarioDao.getAllbyPublicacion(id);
	}

	@Override
	public List<Comentario> getAllbyComentario(Integer id) {
		return comentarioDao.getAllbyComentario(id);
	}

}
