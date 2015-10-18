package com.network.social.services.service.impl;

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
}
