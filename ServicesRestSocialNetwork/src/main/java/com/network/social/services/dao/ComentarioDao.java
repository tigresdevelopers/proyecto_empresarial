package com.network.social.services.dao;

import java.util.List;

import com.network.social.domain.entities.Comentario;
/**
 * @author :Alexander Chavez Simbron
 * @date   :21/10/2015
 * @time   :16:12:17
 */
public interface ComentarioDao extends BaseDao<Comentario,Integer> {

	public List<Comentario> getAllbyMultimedia(Integer id);
	
	public List<Comentario> getAllbyAlbum(Integer id);
	
	public List<Comentario> getAllbyPublicacion(Integer id);
	
	public List<Comentario> getAllbyComentario(Integer id);
}
