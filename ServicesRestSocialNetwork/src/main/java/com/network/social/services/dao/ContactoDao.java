package com.network.social.services.dao;

import java.util.List;

import com.network.social.domain.entities.Contacto;
/**
 * @author :Alexander Chavez Simbron
 * @date   :21/10/2015
 * @time   :16:18:47
 */
public interface ContactoDao extends BaseDao<Contacto, Integer> {

	public List<Contacto> getAllbyUser(Integer id);
		
}
