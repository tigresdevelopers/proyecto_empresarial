package com.network.social.services.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.network.social.domain.entities.ListaContacto;
import com.network.social.services.config.PropiedadService;
import com.network.social.services.dao.ListaContactoDao;

import static com.network.social.services.util.DAOUtil.QUERY_HQL.*;

@SuppressWarnings("unchecked")
@Repository(value="listaContactoDao")
public class ListaContactoDaoImpl extends BaseDaoImpl<ListaContacto, Integer> implements ListaContactoDao {

	@Autowired
	private PropiedadService propiedadService;
	
	@Override
	public List<ListaContacto> getAllbyUser(Integer id) {
		return (List<ListaContacto>)getSessionFactory().getCurrentSession().createQuery(
				propiedadService.getProperty(LISTACONTACTO_USUARIO.getQuery()))
				.setParameter(LISTACONTACTO_USUARIO.getParameters()[0],id)
				.list();
	}

}
