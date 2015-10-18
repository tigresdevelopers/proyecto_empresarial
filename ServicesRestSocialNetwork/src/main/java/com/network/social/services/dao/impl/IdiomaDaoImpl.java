package com.network.social.services.dao.impl;

import org.springframework.stereotype.Repository;

import com.network.social.domain.entities.Idioma;
import com.network.social.services.dao.IdiomaDao;

@Repository(value="idiomaDao")
public class IdiomaDaoImpl  extends BaseDaoImpl<Idioma, Integer> implements IdiomaDao{

}
