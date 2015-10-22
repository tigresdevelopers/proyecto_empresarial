package com.network.social.services.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.network.social.domain.entities.Multimedia;
import com.network.social.services.config.PropiedadService;
import com.network.social.services.dao.MultimediaDao;

import static com.network.social.services.util.DAOUtil.QUERY_HQL.*;

@SuppressWarnings("unchecked")
@Repository(value="multimediaDao")
public class MultimediaDaoImpl extends BaseDaoImpl<Multimedia, Integer> implements MultimediaDao{

	@Autowired
	private PropiedadService propiedadService;
	
	@Override
	public List<Multimedia> getAllbyUser(Integer id) {
		return (List<Multimedia>)getSessionFactory().getCurrentSession().createQuery(
				propiedadService.getProperty(MULTIMEDIA_USUARIO.getQuery()))
				.setParameter(MULTIMEDIA_USUARIO.getParameters()[0],id)
				.list();
	}

	@Override
	public List<Multimedia> getAllbyAlbum(Integer id) {
		return (List<Multimedia>)getSessionFactory().getCurrentSession().createQuery(
				propiedadService.getProperty(MULTIMEDIA_ALBUM.getQuery()))
				.setParameter(MULTIMEDIA_ALBUM.getParameters()[0],id)
				.list();
	}

	@Override
	public List<Multimedia> getAllbyGrupo(Integer id) {
		return (List<Multimedia>)getSessionFactory().getCurrentSession().createQuery(
				propiedadService.getProperty(MULTIMEDIA_GRUPO.getQuery()))
				.setParameter(MULTIMEDIA_GRUPO.getParameters()[0],id)
				.list();
	}

	@Override
	public List<Multimedia> getAllbyPublicacion(Integer id) {
		return (List<Multimedia>)getSessionFactory().getCurrentSession().createQuery(
				propiedadService.getProperty(MULTIMEDIA_PUBLICACION.getQuery()))
				.setParameter(MULTIMEDIA_PUBLICACION.getParameters()[0],id)
				.list();
	}

}
