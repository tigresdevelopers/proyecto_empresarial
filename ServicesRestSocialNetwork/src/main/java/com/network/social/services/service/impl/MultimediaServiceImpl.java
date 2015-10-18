package com.network.social.services.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.network.social.domain.entities.Multimedia;
import com.network.social.services.dao.MultimediaDao;
import com.network.social.services.service.MultimediaService;

@Service(value="multimediaService")
public class MultimediaServiceImpl extends BaseServiceImpl<Multimedia, Integer> implements MultimediaService {

	MultimediaDao multimediaDao;
	
	@Autowired
	public MultimediaServiceImpl(MultimediaDao multimediaDao) {
		super(multimediaDao);
		this.multimediaDao=multimediaDao;
	}

}
