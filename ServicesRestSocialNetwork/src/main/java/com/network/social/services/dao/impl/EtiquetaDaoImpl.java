package com.network.social.services.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.network.social.domain.entities.Etiqueta;
import com.network.social.services.config.PropiedadService;
import com.network.social.services.dao.EtiquetaDao;
import static com.network.social.services.util.DAOUtil.QUERY_HQL.*;

@SuppressWarnings("unchecked")
@Repository(value="etiquetaDao")
public class EtiquetaDaoImpl extends BaseDaoImpl<Etiqueta, Integer> implements EtiquetaDao{

	@Autowired
	private PropiedadService propiedadService;
	
	@Override
	public List<Etiqueta> getAllbyMultimedia(Integer id) {
		return (List<Etiqueta>)getSessionFactory().getCurrentSession().createQuery(
				propiedadService.getProperty(ETIQUETA_MULTIMEDIA.getQuery()))
				.setParameter(ETIQUETA_MULTIMEDIA.getParameters()[0],id)
				.list();
	}

}
