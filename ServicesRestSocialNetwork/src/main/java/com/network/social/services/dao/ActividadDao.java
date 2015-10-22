package com.network.social.services.dao;

import java.util.List;

import com.network.social.domain.entities.Actividad;
/**
 * @author :Alexander Chavez Simbron
 * @date   :21/10/2015
 * @time   :16:12:17
 */
public interface ActividadDao extends BaseDao<Actividad, Integer> {

	public List<Actividad> getAllbyUser(Integer id);

}
