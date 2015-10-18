package com.network.social.services.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.network.social.domain.entities.Solicitud;
import com.network.social.services.dao.SolicitudDao;
import com.network.social.services.service.SolicitudService;

@Service(value="solicitudService")
public class SolicitudServiceImpl extends BaseServiceImpl<Solicitud, Integer> implements SolicitudService {

	SolicitudDao solicitudDao;
	
	@Autowired
	public SolicitudServiceImpl(SolicitudDao solicitudDao) {
		super(solicitudDao);
		this.solicitudDao=solicitudDao;
	}

}
