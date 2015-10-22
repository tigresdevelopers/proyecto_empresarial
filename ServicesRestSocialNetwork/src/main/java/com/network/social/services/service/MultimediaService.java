package com.network.social.services.service;

import java.util.List;

import com.network.social.domain.entities.Multimedia;

public interface MultimediaService extends BaseService<Multimedia, Integer> {

	public List<Multimedia> getAllbyUser(Integer id);
	
	public List<Multimedia> getAllbyAlbum(Integer id);
	
	public List<Multimedia> getAllbyGrupo(Integer id);

	public List<Multimedia> getAllbyPublicacion(Integer id);
}
