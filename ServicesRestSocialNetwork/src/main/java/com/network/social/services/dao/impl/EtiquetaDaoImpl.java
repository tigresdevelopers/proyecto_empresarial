package com.network.social.services.dao.impl;

import org.springframework.stereotype.Repository;

import com.network.social.domain.entities.Etiqueta;
import com.network.social.services.dao.EtiquetaDao;

@Repository(value="etiquetaDao")
public class EtiquetaDaoImpl extends BaseDaoImpl<Etiqueta, Integer> implements EtiquetaDao{

}
