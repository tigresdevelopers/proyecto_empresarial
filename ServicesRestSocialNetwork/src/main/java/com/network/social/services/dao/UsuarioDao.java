package com.network.social.services.dao;

import java.util.List;

import com.network.social.domain.entities.Usuario;
/**
 * @author :Alexander Chavez Simbron
 * @date   :21/10/2015
 * @time   :16:24:21
 */
public interface UsuarioDao extends BaseDao<Usuario, Integer> {

	public Usuario findByUsername(String username);
	
	public List<Usuario> getAllbyUser(Integer id);
	
	public List<Usuario> getAllbyGrupo(Integer id);
	
	public List<Usuario> getAllbyListaContacto(Integer id,Integer idlista);
	
	public List<Usuario> getAllbyTipoContacto(Integer id,Integer tipo);
	
}
