package com.network.social.services.dao;

import java.util.List;

import com.network.social.domain.entities.ListaContacto;
/**
 * @author :Alexander Chavez Simbron
 * @date   :21/10/2015
 * @time   :16:22:07
 */
public interface ListaContactoDao  extends BaseDao<ListaContacto, Integer>{

	public List<ListaContacto> getAllbyUser(Integer id);
}
