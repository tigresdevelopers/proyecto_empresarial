package com.network.social.services.service;

import java.util.List;

import com.network.social.domain.entities.Idioma;

public interface IdiomaService extends BaseService<Idioma, Integer> {

	public List<Idioma> getAllbyUser(Integer id);
}
