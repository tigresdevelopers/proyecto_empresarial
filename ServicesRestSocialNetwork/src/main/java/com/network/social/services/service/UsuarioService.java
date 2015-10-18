package com.network.social.services.service;

import com.network.social.domain.entities.Usuario;

public interface UsuarioService extends BaseService<Usuario, Integer> {

	public Usuario findByUsername(String username);
}
