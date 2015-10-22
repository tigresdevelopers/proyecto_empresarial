package com.network.social.services.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.network.social.domain.entities.Like;
import com.network.social.services.config.PropiedadService;
import com.network.social.services.dao.LikeDao;
import static com.network.social.services.util.DAOUtil.QUERY_HQL.*;

@SuppressWarnings("unchecked")
@Repository(value="likeDao")
public class LikeDaoImpl extends BaseDaoImpl<Like, Integer> implements LikeDao {

	@Autowired
	private PropiedadService propiedadService;
	@Override
	public List<Like> getAllbyMultimedia(Integer id) {
		return (List<Like>)getSessionFactory().getCurrentSession().createQuery(
				propiedadService.getProperty(LIKE_MULTIMEDIA.getQuery()))
				.setParameter(LIKE_MULTIMEDIA.getParameters()[0],id)
				.list();
	}

	@Override
	public List<Like> getAllbyAlbum(Integer id) {
		return (List<Like>)getSessionFactory().getCurrentSession().createQuery(
				propiedadService.getProperty(LIKE_ALBUM.getQuery()))
				.setParameter(LIKE_ALBUM.getParameters()[0],id)
				.list();
	}

	@Override
	public List<Like> getAllbyPublicacion(Integer id) {
		return (List<Like>)getSessionFactory().getCurrentSession().createQuery(
				propiedadService.getProperty(LIKE_PUBLICACION.getQuery()))
				.setParameter(LIKE_PUBLICACION.getParameters()[0],id)
				.list();
	}

	@Override
	public List<Like> getAllbyComentario(Integer id) {
		return (List<Like>)getSessionFactory().getCurrentSession().createQuery(
				propiedadService.getProperty(LIKE_COMENTARIO.getQuery()))
				.setParameter(LIKE_COMENTARIO.getParameters()[0],id)
				.list();
	}

}
