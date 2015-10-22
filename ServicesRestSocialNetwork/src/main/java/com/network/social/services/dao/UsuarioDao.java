package com.network.social.services.dao;

import java.util.List;

import com.network.social.domain.entities.Usuario;

public interface UsuarioDao extends BaseDao<Usuario, Integer> {

	public Usuario findByUsername(String username);
	
	public List<Usuario> getAllbyUser(Integer id);
	
	public List<Usuario> getAllbyGrupo(Integer id);
	
	public List<Usuario> getAllbyListaContacto(Integer id);
	
	public List<Usuario> getAllbyTipoContacto(Integer id);
	
}
