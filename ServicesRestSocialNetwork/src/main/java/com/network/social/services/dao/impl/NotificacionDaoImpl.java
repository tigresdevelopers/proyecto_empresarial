package com.network.social.services.dao.impl;

import org.springframework.stereotype.Repository;

import com.network.social.domain.entities.Notificacion;
import com.network.social.services.dao.NotificacionDao;

@Repository(value="notificacionDao")
public class NotificacionDaoImpl extends BaseDaoImpl<Notificacion, Integer> implements NotificacionDao {

}
