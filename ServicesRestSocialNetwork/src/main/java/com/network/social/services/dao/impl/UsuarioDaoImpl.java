package com.network.social.services.dao.impl;

import static com.network.social.services.util.DAOUtil.QUERY_HQL.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.network.social.domain.entities.Contacto;
import com.network.social.domain.entities.Usuario;
import com.network.social.services.config.PropiedadService;
import com.network.social.services.dao.UsuarioDao;


@Repository(value="usuarioDao")
public class UsuarioDaoImpl extends BaseDaoImpl<Usuario, Integer> implements UsuarioDao {
	
	@Autowired
	PropiedadService propiedadService;
	
	@Override
	public Usuario findByUsername(String username) {
		
		Map<String, Object> parameters=new HashMap<>();
		parameters.put(USUARIO_BY_EMAIL.getParameters()[0],username);
		
		return getByHQL(propiedadService.getQuery(USUARIO_BY_EMAIL), parameters,null);
	}

	@Override
	public List<Usuario> getAllbyUser(Integer id) {
		
		List<Usuario> contacts=new ArrayList<>(0);
		
		Usuario usuario=new Usuario(id);

		Set<Contacto> sets =usuario.getContactosForMyid();
		
		for (Iterator<Contacto> iter = sets.iterator();iter.hasNext(); ) { 
			Contacto contacto = (Contacto) iter.next();
			contacts.add(contacto.getUsuarioByIdusuario());
		}
		
		return contacts;
	}

	@Override
	public List<Usuario> getAllbyGrupo(Integer id) {
		return null;
	}

	@Override
	public List<Usuario> getAllbyListaContacto(Integer id) {
		return null;
	}

	@Override
	public List<Usuario> getAllbyTipoContacto(Integer id) {
		return null;
	}

}
