package com.network.social.services.service;

import java.util.List;

import com.network.social.domain.entities.Contacto;

public interface ContactoService extends BaseService<Contacto, Integer> {

	public List<Contacto> getAllbyUser(Integer id);
}
