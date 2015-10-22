package com.network.social.services.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.network.social.domain.entities.Idioma;
import com.network.social.services.config.PropiedadService;
import com.network.social.services.dao.IdiomaDao;

import static com.network.social.services.util.DAOUtil.QUERY_HQL.*;

@SuppressWarnings("unchecked")
@Repository(value="idiomaDao")
public class IdiomaDaoImpl  extends BaseDaoImpl<Idioma, Integer> implements IdiomaDao{

	@Autowired
	private PropiedadService propiedadService;
	
	@Override
	public List<Idioma> getAllbyUser(Integer id) {
		return (List<Idioma>)getSessionFactory().getCurrentSession().createQuery(
				propiedadService.getProperty(IDIOMA_USUARIO.getQuery()))
				.setParameter(IDIOMA_USUARIO.getParameters()[0],id)
				.list();
	}

}
