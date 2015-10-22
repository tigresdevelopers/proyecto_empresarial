package com.network.social.services.service;

import java.util.List;

import com.network.social.domain.entities.Solicitud;

public interface SolicitudService  extends BaseService<Solicitud, Integer>{

	public List<Solicitud> getAllbyUser(Integer id);
}
