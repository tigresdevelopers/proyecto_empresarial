package com.network.social.services.service;

import java.util.List;

import com.network.social.domain.entities.Like;

public interface LikeService extends BaseService<Like, Integer>{

	public List<Like> getAllbyMultimedia(Integer id);

	public List<Like> getAllbyAlbum(Integer id);
	
	public List<Like> getAllbyPublicacion(Integer id);
	
	public List<Like> getAllbyComentario(Integer id);
}
