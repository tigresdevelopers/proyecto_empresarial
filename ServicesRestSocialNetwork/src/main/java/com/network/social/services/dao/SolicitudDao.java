package com.network.social.services.dao;

import java.util.List;

import com.network.social.domain.entities.Solicitud;
/**
 * @author :Alexander Chavez Simbron
 * @date   :21/10/2015
 * @time   :16:23:53
 */
public interface SolicitudDao extends BaseDao<Solicitud, Integer> {

	public List<Solicitud> getAllbyUser(Integer id);
}
