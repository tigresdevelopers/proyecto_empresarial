package com.network.social.services.service;

import java.util.List;

import com.network.social.domain.entities.Etiqueta;

public interface EtiquetaService extends BaseService<Etiqueta, Integer> {

	public List<Etiqueta> getAllbyMultimedia(Integer id);
}
