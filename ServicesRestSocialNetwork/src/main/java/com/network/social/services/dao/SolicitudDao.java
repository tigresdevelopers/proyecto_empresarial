package com.network.social.services.dao;

import java.util.List;

import com.network.social.domain.entities.Solicitud;

public interface SolicitudDao extends BaseDao<Solicitud, Integer> {

	public List<Solicitud> getAllbyUser(Integer id);
}
