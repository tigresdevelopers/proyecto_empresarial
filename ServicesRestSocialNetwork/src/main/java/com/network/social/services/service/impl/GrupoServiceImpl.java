package com.network.social.services.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.network.social.domain.entities.Grupo;
import com.network.social.services.dao.GrupoDao;
import com.network.social.services.service.GrupoService;

@Service(value="grupoService")
public class GrupoServiceImpl extends BaseServiceImpl<Grupo, Integer> implements GrupoService {

	GrupoDao grupoDao;
	
	@Autowired
	public GrupoServiceImpl(GrupoDao grupoDao) {
		super(grupoDao);
		this.grupoDao=grupoDao;
	}

	@Override
	public List<Grupo> getAllbyUser(Integer id) {
		return grupoDao.getAllbyUser(id);
	}

}
