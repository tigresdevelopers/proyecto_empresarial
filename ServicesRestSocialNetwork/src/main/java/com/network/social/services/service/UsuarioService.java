package com.network.social.services.service;

import java.util.List;

import com.network.social.domain.entities.Usuario;

public interface UsuarioService extends BaseService<Usuario, Integer> {

	public Usuario findByUsername(String username);
	
	public List<Usuario> getAllbyUser(Integer id);
	
	public List<Usuario> getAllbyGrupo(Integer id);
	
	public List<Usuario> getAllbyListaContacto(Integer id,Integer idlista);
	
	public List<Usuario> getAllbyTipoContacto(Integer id,Integer idtipo);
}
