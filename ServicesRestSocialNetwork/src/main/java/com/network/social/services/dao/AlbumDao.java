package com.network.social.services.dao;

import java.util.List;

import com.network.social.domain.entities.Album;
/**
 * @author :Alexander Chavez Simbron
 * @date   :21/10/2015
 * @time   :16:12:17
 */
public interface AlbumDao extends BaseDao<Album, Integer> {

	public List<Album> listAlbumbyUserId(Integer id);
	
	public List<Album> getAllbyUser(Integer id);
	
	public List<Album> getAllbyGrupo(Integer id);
	
}
