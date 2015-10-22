package com.network.social.services.service;

import java.util.List;

import com.network.social.domain.entities.Grupo;

public interface GrupoService extends BaseService<Grupo, Integer> {

	public List<Grupo> getAllbyUser(Integer id);
}
