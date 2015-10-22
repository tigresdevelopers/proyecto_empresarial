package com.network.social.services.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.network.social.domain.entities.Comentario;
import com.network.social.services.config.PropiedadService;
import com.network.social.services.dao.ComentarioDao;
import static com.network.social.services.util.DAOUtil.QUERY_HQL.*;

@SuppressWarnings("unchecked")
@Repository(value="comentarioDao")
public class ComentarioDaoImpl  extends BaseDaoImpl<Comentario, Integer> implements ComentarioDao{

	@Autowired
	private PropiedadService propiedadService;
	
	@Override
	public List<Comentario> getAllbyMultimedia(Integer id) {
		return (List<Comentario>)getSessionFactory().getCurrentSession().createQuery(
				propiedadService.getProperty(COMENTARIO_MULTIMEDIA.getQuery()))
				.setParameter(COMENTARIO_MULTIMEDIA.getParameters()[0],id)
				.list();
	}

	@Override
	public List<Comentario> getAllbyAlbum(Integer id) {
		return (List<Comentario>)getSessionFactory().getCurrentSession().createQuery(
				propiedadService.getProperty(COMENTARIO_ALBUM.getQuery()))
				.setParameter(COMENTARIO_ALBUM.getParameters()[0],id)
				.list();
	}

	@Override
	public List<Comentario> getAllbyPublicacion(Integer id) {
		return (List<Comentario>)getSessionFactory().getCurrentSession().createQuery(
				propiedadService.getProperty(COMENTARIO_PUBLICACION.getQuery()))
				.setParameter(COMENTARIO_ALBUM.getParameters()[0],id)
				.list();
	}

	@Override
	public List<Comentario> getAllbyComentario(Integer id) {
		return (List<Comentario>)getSessionFactory().getCurrentSession().createQuery(
				propiedadService.getProperty(COMENTARIO_COMENTARIO.getQuery()))
				.setParameter(COMENTARIO_COMENTARIO.getParameters()[0],id)
				.list();
	}

}
