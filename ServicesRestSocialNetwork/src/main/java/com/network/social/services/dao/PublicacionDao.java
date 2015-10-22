package com.network.social.services.dao;

import java.util.List;

import com.network.social.domain.entities.Publicacion;

public interface PublicacionDao extends BaseDao<Publicacion, Integer> {

	public List<Publicacion> getAllbyUser(Integer id);
	
	public List<Publicacion> getAllbyGrupo(Integer id);
	
	public List<Publicacion> getAllbyUserTipo(Integer id,Integer idtipo);
	
	public List<Publicacion> getAllbyUserLista(Integer id,Integer idlista);
}
