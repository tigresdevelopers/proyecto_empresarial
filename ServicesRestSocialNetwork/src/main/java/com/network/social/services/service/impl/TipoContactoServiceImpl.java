package com.network.social.services.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.network.social.domain.entities.TipoContacto;
import com.network.social.services.dao.TipoContactoDao;
import com.network.social.services.service.TipoContactoService;


@Service(value="tipoContactoService")
public class TipoContactoServiceImpl  extends BaseServiceImpl<TipoContacto, Integer> implements TipoContactoService{

	TipoContactoDao tipoContactoDao;
	
	@Autowired
	public TipoContactoServiceImpl(TipoContactoDao tipoContactoDao) {
		super(tipoContactoDao);
		this.tipoContactoDao=tipoContactoDao;
	}

}
