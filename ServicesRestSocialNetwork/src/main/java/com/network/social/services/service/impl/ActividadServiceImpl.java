package com.network.social.services.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.network.social.domain.entities.Actividad;
import com.network.social.services.dao.ActividadDao;
import com.network.social.services.service.ActividadService;

@Service(value="actividadService")
public class ActividadServiceImpl extends BaseServiceImpl<Actividad, Integer> implements ActividadService {

	ActividadDao actividadDao;
	
	@Autowired
	public ActividadServiceImpl(ActividadDao actividadDao) {
		super(actividadDao);
		this.actividadDao=actividadDao;
	}

	@Override
	public List<Actividad> getAllbyUser(Integer id) {
		return actividadDao.getAllbyUser(id);
	}

}
