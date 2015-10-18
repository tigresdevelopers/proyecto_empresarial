package com.network.social.services.service.impl;

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

	
}
