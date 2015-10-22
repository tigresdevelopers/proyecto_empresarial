package com.network.social.services.service;

import java.util.List;

import com.network.social.domain.entities.Notificacion;

public interface NotificacionService  extends BaseService<Notificacion, Integer>{

	public List<Notificacion> getAllbyUser(Integer id);
}
