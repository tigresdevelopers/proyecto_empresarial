package com.network.social.services.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.network.social.domain.entities.Idioma;
import com.network.social.services.dao.IdiomaDao;
import com.network.social.services.service.IdiomaService;

@Service(value="idiomaService")
public class IdiomaServiceImpl  extends BaseServiceImpl<Idioma, Integer> implements IdiomaService{
	
	IdiomaDao idiomaDao;
	
	@Autowired
	public IdiomaServiceImpl(IdiomaDao idiomaDao) {
		super(idiomaDao);
		this.idiomaDao=idiomaDao;
	}

	@Override
	public List<Idioma> getAllbyUser(Integer id) {
		return idiomaDao.getAllbyUser(id);
	}

}
