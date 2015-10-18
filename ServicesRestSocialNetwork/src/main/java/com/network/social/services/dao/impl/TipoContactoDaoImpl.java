package com.network.social.services.dao.impl;

import org.springframework.stereotype.Repository;

import com.network.social.domain.entities.TipoContacto;
import com.network.social.services.dao.TipoContactoDao;

@Repository(value="tipoContactoDao")
public class TipoContactoDaoImpl extends BaseDaoImpl<TipoContacto, Integer> implements TipoContactoDao {

}
