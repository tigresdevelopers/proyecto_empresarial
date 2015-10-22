package com.network.social.services.dao;

import java.util.List;

import com.network.social.domain.entities.Comentario;

public interface ComentarioDao extends BaseDao<Comentario,Integer> {

	public List<Comentario> getAllbyMultimedia(Integer id);
	
	public List<Comentario> getAllbyAlbum(Integer id);
	
	public List<Comentario> getAllbyPublicacion(Integer id);
	
	public List<Comentario> getAllbyComentario(Integer id);
}
