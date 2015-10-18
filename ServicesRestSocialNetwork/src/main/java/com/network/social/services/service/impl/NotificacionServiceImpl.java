package com.network.social.services.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.network.social.domain.entities.Notificacion;
import com.network.social.services.dao.NotificacionDao;
import com.network.social.services.service.NotificacionService;

@Service(value="notificacionService")
public class NotificacionServiceImpl extends BaseServiceImpl<Notificacion, Integer> implements NotificacionService {

	NotificacionDao notificacionDao;
	
	@Autowired
	public NotificacionServiceImpl(NotificacionDao notificacionDao) {
		super(notificacionDao);
		this.notificacionDao=notificacionDao;
	}

}
