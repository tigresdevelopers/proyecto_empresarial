package com.network.social.services.dao.impl;

import org.springframework.stereotype.Repository;

import com.network.social.domain.entities.Situacion;
import com.network.social.services.dao.SituacionDao;

@Repository(value="situacionDao")
public class SituacionDaoImpl  extends BaseDaoImpl<Situacion, Integer> implements SituacionDao{

}
