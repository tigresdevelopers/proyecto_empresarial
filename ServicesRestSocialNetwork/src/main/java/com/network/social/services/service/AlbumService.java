package com.network.social.services.service;

import java.util.List;

import com.network.social.domain.entities.Album;

public interface AlbumService extends BaseService<Album, Integer> {

	public List<Album> listAlbumbyUserId(Integer id);
	
	public List<Album> getAllbyUser(Integer id);
	
	public List<Album> getAllbyGrupo(Integer id);
}
