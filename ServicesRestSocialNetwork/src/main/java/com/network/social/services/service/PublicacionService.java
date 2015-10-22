package com.network.social.services.service;

import java.util.List;

import com.network.social.domain.entities.Publicacion;

public interface PublicacionService extends BaseService<Publicacion, Integer> {

	public List<Publicacion> getAllbyUser(Integer id);
	
	public List<Publicacion> getAllbyGrupo(Integer id);
	
	public List<Publicacion> getAllbyUserTipo(Integer id,Integer idtipo);
	
	public List<Publicacion> getAllbyUserLista(Integer id,Integer idlista);
	
}
