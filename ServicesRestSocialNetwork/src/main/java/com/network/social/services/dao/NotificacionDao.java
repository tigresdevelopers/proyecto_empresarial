package com.network.social.services.dao;

import java.util.List;

import com.network.social.domain.entities.Notificacion;
/**
 * @author :Alexander Chavez Simbron
 * @date   :21/10/2015
 * @time   :16:22:35
 */
public interface NotificacionDao extends BaseDao<Notificacion, Integer> {

	public List<Notificacion> getAllbyUser(Integer id);
	
}
