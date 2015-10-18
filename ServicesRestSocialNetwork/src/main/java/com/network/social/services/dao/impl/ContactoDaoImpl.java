package com.network.social.services.dao.impl;

import org.springframework.stereotype.Repository;

import com.network.social.domain.entities.Contacto;
import com.network.social.services.dao.ContactoDao;

@Repository(value="contactoDao")
public class ContactoDaoImpl extends BaseDaoImpl<Contacto, Integer> implements ContactoDao {

}
