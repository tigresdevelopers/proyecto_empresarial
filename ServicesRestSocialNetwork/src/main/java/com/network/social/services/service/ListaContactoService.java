package com.network.social.services.service;

import java.util.List;

import com.network.social.domain.entities.ListaContacto;

public interface ListaContactoService extends BaseService<ListaContacto, Integer> {

	public List<ListaContacto> getAllbyUser(Integer id);
	
}
