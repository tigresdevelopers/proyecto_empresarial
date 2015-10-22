package com.network.social.services.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.network.social.domain.entities.Actividad;
import com.network.social.services.config.PropiedadService;
import com.network.social.services.dao.ActividadDao;
import com.network.social.services.util.DAOUtil;

@Repository(value="actividadDao")
public class ActividadDaoImpl extends BaseDaoImpl<Actividad, Integer> implements ActividadDao {

	@Autowired
	PropiedadService propiedadService;
	
	@Override
	public List<Actividad> getAllbyUser(Integer id) {
		return findByQuery(propiedadService.getQuery(DAOUtil.QUERY_HQL.ACTIVIDAD_USUARIO)+id);
	}

}
