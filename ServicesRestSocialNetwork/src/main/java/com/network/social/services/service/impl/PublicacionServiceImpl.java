package com.network.social.services.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.network.social.domain.entities.Publicacion;
import com.network.social.services.dao.PublicacionDao;
import com.network.social.services.service.PublicacionService;

@Service(value="publicacionService")
public class PublicacionServiceImpl  extends BaseServiceImpl<Publicacion, Integer> implements PublicacionService{

	PublicacionDao publicacionDao;
	
	@Autowired
	public PublicacionServiceImpl(PublicacionDao publicacionDao) {
		super(publicacionDao);
		this.publicacionDao=publicacionDao;
	}

	@Override
	public List<Publicacion> getAllbyUser(Integer id) {
		return publicacionDao.getAllbyUser(id);
	}

	@Override
	public List<Publicacion> getAllbyGrupo(Integer id) {
		return publicacionDao.getAllbyGrupo(id);
	}

	@Override
	public List<Publicacion> getAllbyUserTipo(Integer id, Integer idtipo) {
		return publicacionDao.getAllbyUserTipo(id, idtipo);
	}

	@Override
	public List<Publicacion> getAllbyUserLista(Integer id, Integer idlista) {
		return publicacionDao.getAllbyUserLista(id, idlista);
	}
}
