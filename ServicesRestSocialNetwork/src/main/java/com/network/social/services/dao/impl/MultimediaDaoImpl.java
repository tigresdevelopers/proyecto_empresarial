package com.network.social.services.dao.impl;

import org.springframework.stereotype.Repository;

import com.network.social.domain.entities.Multimedia;
import com.network.social.services.dao.MultimediaDao;

@Repository(value="multimediaDao")
public class MultimediaDaoImpl extends BaseDaoImpl<Multimedia, Integer> implements MultimediaDao{

}
