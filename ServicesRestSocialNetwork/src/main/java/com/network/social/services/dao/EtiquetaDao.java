package com.network.social.services.dao;

import java.util.List;

import com.network.social.domain.entities.Etiqueta;

public interface EtiquetaDao extends BaseDao<Etiqueta, Integer> {

	public List<Etiqueta> getAllbyMultimedia(Integer id);
	
}
