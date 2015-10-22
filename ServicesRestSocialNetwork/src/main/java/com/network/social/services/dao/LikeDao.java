package com.network.social.services.dao;

import java.util.List;

import com.network.social.domain.entities.Like;
/**
 * @author :Alexander Chavez Simbron
 * @date   :21/10/2015
 * @time   :16:21:30
 */
public interface LikeDao extends BaseDao<Like, Integer> {

	public List<Like> getAllbyMultimedia(Integer id);
	
	public List<Like> getAllbyAlbum(Integer id);
	
	public List<Like> getAllbyPublicacion(Integer id);
	
	public List<Like> getAllbyComentario(Integer id);
}
