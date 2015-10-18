package com.network.social.services.dao.impl;

import org.springframework.stereotype.Repository;

import com.network.social.domain.entities.Publicacion;
import com.network.social.services.dao.PublicacionDao;

@Repository(value="publicacionDao")
public class PublicacionDaoImpl extends BaseDaoImpl<Publicacion, Integer> implements PublicacionDao {

}
