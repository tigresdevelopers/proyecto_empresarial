package com.network.social.services.dao.impl;

import org.springframework.stereotype.Repository;

import com.network.social.domain.entities.Like;
import com.network.social.services.dao.LikeDao;

@Repository(value="likeDao")
public class LikeDaoImpl extends BaseDaoImpl<Like, Integer> implements LikeDao {

}
