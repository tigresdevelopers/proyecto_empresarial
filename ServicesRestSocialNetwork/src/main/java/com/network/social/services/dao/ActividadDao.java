package com.network.social.services.dao;

import java.util.List;

import com.network.social.domain.entities.Actividad;

public interface ActividadDao extends BaseDao<Actividad, Integer> {

	public List<Actividad> getAllbyUser(Integer id);

}
