package com.network.social.services.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.network.social.domain.entities.Contacto;
import com.network.social.services.dao.ContactoDao;
import com.network.social.services.service.ContactoService;

@Service(value="contactoService")
public class ContactoServiceImpl extends BaseServiceImpl<Contacto, Integer> implements ContactoService {

	ContactoDao contactoDao;
	
	@Autowired
	public ContactoServiceImpl(ContactoDao contactoDao) {
		super(contactoDao);
		this.contactoDao=contactoDao;
	}

	@Override
	public List<Contacto> getAllbyUser(Integer id) {
		return contactoDao.getAllbyUser(id);
	}

	
}
