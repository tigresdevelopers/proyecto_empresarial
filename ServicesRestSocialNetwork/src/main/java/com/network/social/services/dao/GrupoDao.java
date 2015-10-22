package com.network.social.services.dao;

import java.util.List;

import com.network.social.domain.entities.Grupo;

public interface GrupoDao extends BaseDao<Grupo, Integer> {

	public List<Grupo> getAllbyUser(Integer id);
	
}
