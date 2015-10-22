package com.network.social.services.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.network.social.domain.entities.ListaContacto;
import com.network.social.services.dao.ListaContactoDao;
import com.network.social.services.service.ListaContactoService;

@Service(value="listaContactoService")
public class ListaContactoServiceImpl extends BaseServiceImpl<ListaContacto, Integer> implements ListaContactoService {

	ListaContactoDao listaContactoDao;
	
	@Autowired
	public ListaContactoServiceImpl(ListaContactoDao listaContactoDao) {
		super(listaContactoDao);
		this.listaContactoDao=listaContactoDao;
	}

	@Override
	public List<ListaContacto> getAllbyUser(Integer id) {
		return listaContactoDao.getAllbyUser(id);
	}

}
