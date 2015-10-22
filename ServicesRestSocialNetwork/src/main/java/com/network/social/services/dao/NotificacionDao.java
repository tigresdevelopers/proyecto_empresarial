package com.network.social.services.dao;

import java.util.List;

import com.network.social.domain.entities.Notificacion;

public interface NotificacionDao extends BaseDao<Notificacion, Integer> {

	public List<Notificacion> getAllbyUser(Integer id);
	
}
