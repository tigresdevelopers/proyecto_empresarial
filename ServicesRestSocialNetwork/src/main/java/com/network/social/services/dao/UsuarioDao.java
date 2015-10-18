package com.network.social.services.dao;

import com.network.social.domain.entities.Usuario;

public interface UsuarioDao extends BaseDao<Usuario, Integer> {

	public Usuario findByUsername(String username);
	
}
