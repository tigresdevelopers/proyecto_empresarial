package com.network.social.services.dao.impl;

import org.springframework.stereotype.Repository;

import com.network.social.domain.entities.Grupo;
import com.network.social.services.dao.GrupoDao;


@Repository(value="grupoDao")
public class GrupoDaoImpl extends BaseDaoImpl<Grupo, Integer> implements GrupoDao {

}
