package com.network.social.services.dao.impl;

import org.springframework.stereotype.Repository;

import com.network.social.domain.entities.Actividad;
import com.network.social.services.dao.ActividadDao;

@Repository(value="actividadDao")
public class ActividadDaoImpl extends BaseDaoImpl<Actividad, Integer> implements ActividadDao {

}
