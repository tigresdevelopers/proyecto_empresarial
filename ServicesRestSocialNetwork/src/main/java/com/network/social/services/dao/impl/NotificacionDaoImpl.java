package com.network.social.services.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.network.social.domain.entities.Notificacion;
import com.network.social.services.config.PropiedadService;
import com.network.social.services.dao.NotificacionDao;

import static com.network.social.services.util.DAOUtil.QUERY_HQL.*;

@SuppressWarnings("unchecked")
@Repository(value="notificacionDao")
public class NotificacionDaoImpl extends BaseDaoImpl<Notificacion, Integer> implements NotificacionDao {

	@Autowired
	private PropiedadService propiedadService;
	
	@Override
	public List<Notificacion> getAllbyUser(Integer id) {
		return (List<Notificacion>)getSessionFactory().getCurrentSession().createQuery(
				propiedadService.getProperty(NOTIFICACION_USUARIO.getQuery()))
				.setParameter(NOTIFICACION_USUARIO.getParameters()[0],id)
				.list();
	}

}
