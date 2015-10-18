package com.network.social.services.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.network.social.domain.entities.Situacion;
import com.network.social.services.dao.SituacionDao;
import com.network.social.services.service.SituacionService;


@Service(value="situacionService")
public class SituacionServiceImpl extends BaseServiceImpl<Situacion, Integer> implements SituacionService {

	SituacionDao situacionDao;
	
	@Autowired
	public SituacionServiceImpl(SituacionDao situacionDao) {
		super(situacionDao);
		this.situacionDao=situacionDao;
	}

}
