package com.network.social.services.dao;

import java.util.List;

import com.network.social.domain.entities.Multimedia;

public interface MultimediaDao extends BaseDao<Multimedia, Integer> {

	public List<Multimedia> getAllbyUser(Integer id);
	
	public List<Multimedia> getAllbyAlbum(Integer id);
	
	public List<Multimedia> getAllbyGrupo(Integer id);

	public List<Multimedia> getAllbyPublicacion(Integer id);
}
