package com.network.social.services.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.network.social.domain.entities.Like;
import com.network.social.services.dao.LikeDao;
import com.network.social.services.service.LikeService;

@Service(value="likeService")
public class LikeServiceImpl extends BaseServiceImpl<Like, Integer> implements LikeService {

	LikeDao likeDao;
	
	@Autowired
	public LikeServiceImpl(LikeDao likeDao) {
		super(likeDao);
		this.likeDao=likeDao;
	}

	@Override
	public List<Like> getAllbyMultimedia(Integer id) {
		return likeDao.getAllbyMultimedia(id);
	}

	@Override
	public List<Like> getAllbyAlbum(Integer id) {
		return likeDao.getAllbyAlbum(id);
	}

	@Override
	public List<Like> getAllbyPublicacion(Integer id) {
		return likeDao.getAllbyPublicacion(id);
	}

	@Override
	public List<Like> getAllbyComentario(Integer id) {
		return likeDao.getAllbyComentario(id);
	}

	
}
