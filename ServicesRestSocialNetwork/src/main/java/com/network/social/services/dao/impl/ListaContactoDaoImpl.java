package com.network.social.services.dao.impl;

import org.springframework.stereotype.Repository;

import com.network.social.domain.entities.ListaContacto;
import com.network.social.services.dao.ListaContactoDao;

@Repository(value="listaContactoDao")
public class ListaContactoDaoImpl extends BaseDaoImpl<ListaContacto, Integer> implements ListaContactoDao {

}
