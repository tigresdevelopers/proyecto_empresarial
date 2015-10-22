package com.network.social.services.dao;

import java.util.List;

import com.network.social.domain.entities.Idioma;

public interface IdiomaDao  extends BaseDao<Idioma,Integer>{

	public List<Idioma> getAllbyUser(Integer id);
}
