package com.network.social.services.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.network.social.domain.entities.Etiqueta;
import com.network.social.services.dao.EtiquetaDao;
import com.network.social.services.service.EtiquetaService;

@Service(value="etiquetaService")
public class EtiquetaServiceImpl extends BaseServiceImpl<Etiqueta, Integer> implements EtiquetaService {

	EtiquetaDao etiquetaDao;
	
	@Autowired
	public EtiquetaServiceImpl(EtiquetaDao etiquetaDao) {
		super(etiquetaDao);
		this.etiquetaDao=etiquetaDao;
	}

	@Override
	public List<Etiqueta> getAllbyMultimedia(Integer id) {
		return etiquetaDao.getAllbyMultimedia(id);
	}

}
