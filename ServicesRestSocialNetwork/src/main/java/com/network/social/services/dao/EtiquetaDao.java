package com.network.social.services.dao;

import java.util.List;

import com.network.social.domain.entities.Etiqueta;
/**
 * @author :Alexander Chavez Simbron
 * @date   :21/10/2015
 * @time   :16:19:29
 */
public interface EtiquetaDao extends BaseDao<Etiqueta, Integer> {

	public List<Etiqueta> getAllbyMultimedia(Integer id);
	
}
