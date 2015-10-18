package com.network.social.services.dao.impl;

import org.springframework.stereotype.Repository;

import com.network.social.domain.entities.Comentario;
import com.network.social.services.dao.ComentarioDao;

@Repository(value="comentarioDao")
public class ComentarioDaoImpl  extends BaseDaoImpl<Comentario, Integer> implements ComentarioDao{

}
