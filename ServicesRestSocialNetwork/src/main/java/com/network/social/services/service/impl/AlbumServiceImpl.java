package com.network.social.services.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.network.social.domain.entities.Album;
import com.network.social.services.dao.AlbumDao;
import com.network.social.services.service.AlbumService;

@Service(value="albumService")
public class AlbumServiceImpl extends BaseServiceImpl<Album, Integer> implements AlbumService {

	AlbumDao albumDao;
	
	@Autowired
	public AlbumServiceImpl(AlbumDao albumDao) {
		super(albumDao);
		this.albumDao=albumDao;
	}

	@Override
	public List<Album> listAlbumbyUserId(Integer id) {
		return albumDao.listAlbumbyUserId(id);
	}

	@Override
	public List<Album> getAllbyUser(Integer id) {
		return albumDao.getAllbyUser(id);
	}

	@Override
	public List<Album> getAllbyGrupo(Integer id) {
		return albumDao.getAllbyGrupo(id);
	}
	

}
