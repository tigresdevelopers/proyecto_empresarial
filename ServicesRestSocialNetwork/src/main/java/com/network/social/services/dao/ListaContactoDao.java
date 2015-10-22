package com.network.social.services.dao;

import java.util.List;

import com.network.social.domain.entities.ListaContacto;

public interface ListaContactoDao  extends BaseDao<ListaContacto, Integer>{

	public List<ListaContacto> getAllbyUser(Integer id);
}
