package com.network.social.services.service;

import java.util.List;

import com.network.social.domain.entities.Actividad;

public interface ActividadService extends BaseService<Actividad, Integer> {

	public List<Actividad> getAllbyUser(Integer id);
}
