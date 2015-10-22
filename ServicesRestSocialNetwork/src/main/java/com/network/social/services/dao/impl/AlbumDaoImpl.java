package com.network.social.services.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.network.social.domain.entities.Album;
import com.network.social.services.config.PropiedadService;
import com.network.social.services.dao.AlbumDao;
import static com.network.social.services.util.DAOUtil.QUERY_HQL.*;


@SuppressWarnings("unchecked")
@Repository(value="albumDao")
public class AlbumDaoImpl extends BaseDaoImpl<Album, Integer> implements AlbumDao {

	@Autowired
	PropiedadService propiedadService;
	
	@Override
	public List<Album> listAlbumbyUserId(Integer id) {
				
		return (List<Album>)getSessionFactory().getCurrentSession().createQuery(
				propiedadService.getProperty(ALBUM_USUARIO.getQuery()))
				.setParameter(ALBUM_USUARIO.getParameters()[0],id)
				.list();

	}

	@Override
	public List<Album> getAllbyUser(Integer id) {
		return (List<Album>)getSessionFactory().getCurrentSession().createQuery(
				propiedadService.getProperty(ALBUM_USUARIO.getQuery()))
				.setParameter(ALBUM_USUARIO.getParameters()[0],id)
				.list();
	}

	@Override
	public List<Album> getAllbyGrupo(Integer id) {
		return (List<Album>)getSessionFactory().getCurrentSession().createQuery(
				propiedadService.getProperty(ALBUM_GRUPO.getQuery()))
				.setParameter(ALBUM_GRUPO.getParameters()[0],id)
				.list();
	}

}



