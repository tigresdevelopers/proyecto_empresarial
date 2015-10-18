package com.network.social.services.dao.impl;

import org.springframework.stereotype.Repository;

import com.network.social.domain.entities.Solicitud;
import com.network.social.services.dao.SolicitudDao;

@Repository(value="solicitudDao")
public class SolicitudDaoImpl extends BaseDaoImpl<Solicitud, Integer> implements SolicitudDao {

}
