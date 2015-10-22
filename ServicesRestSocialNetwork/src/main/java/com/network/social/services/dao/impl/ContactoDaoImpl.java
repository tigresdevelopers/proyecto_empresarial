package com.network.social.services.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.network.social.domain.entities.Contacto;
import com.network.social.services.config.PropiedadService;
import com.network.social.services.dao.ContactoDao;
import static com.network.social.services.util.DAOUtil.QUERY_HQL.*;

@SuppressWarnings("unchecked")
@Repository(value="contactoDao")
public class ContactoDaoImpl extends BaseDaoImpl<Contacto, Integer> implements ContactoDao {

	@Autowired
	private PropiedadService propiedadService;
	
	@Override
	public List<Contacto> getAllbyUser(Integer id) {
		return (List<Contacto>)getSessionFactory().getCurrentSession().createQuery(
				propiedadService.getProperty(CONTACTO_USUARIO.getQuery()))
				.setParameter(CONTACTO_USUARIO.getParameters()[0],id)
				.list();
	}

}
