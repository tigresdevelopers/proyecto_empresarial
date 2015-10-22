package com.network.social.services.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.network.social.domain.entities.Grupo;
import com.network.social.services.config.PropiedadService;
import com.network.social.services.dao.GrupoDao;
import static com.network.social.services.util.DAOUtil.QUERY_HQL.*;

@SuppressWarnings("unchecked")
@Repository(value="grupoDao")
public class GrupoDaoImpl extends BaseDaoImpl<Grupo, Integer> implements GrupoDao {

	@Autowired
	private PropiedadService propiedadService;
	
	@Override
	public List<Grupo> getAllbyUser(Integer id) {
		return (List<Grupo>)getSessionFactory().getCurrentSession().createQuery(
				propiedadService.getProperty(GRUPO_USUARIO.getQuery()))
				.setParameter(GRUPO_USUARIO.getParameters()[0],id)
				.list();
	}

}
