package com.network.social.services.dao;

import java.util.List;

import com.network.social.domain.entities.Contacto;

public interface ContactoDao extends BaseDao<Contacto, Integer> {

	public List<Contacto> getAllbyUser(Integer id);
		
}
