package com.network.social.services.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.network.social.domain.entities.Solicitud;
import com.network.social.services.config.PropiedadService;
import com.network.social.services.dao.SolicitudDao;

import static com.network.social.services.util.DAOUtil.QUERY_HQL.*;

@SuppressWarnings("unchecked")
@Repository(value="solicitudDao")
public class SolicitudDaoImpl extends BaseDaoImpl<Solicitud, Integer> implements SolicitudDao {

	@Autowired
	private PropiedadService propiedadService;
	
	@Override
	public List<Solicitud> getAllbyUser(Integer id) {
		return (List<Solicitud>)getSessionFactory().getCurrentSession().createQuery(
				propiedadService.getProperty(SOLICITUD_USUARIO.getQuery()))
				.setParameter(SOLICITUD_USUARIO.getParameters()[0],id)
				.list();
	}

}
