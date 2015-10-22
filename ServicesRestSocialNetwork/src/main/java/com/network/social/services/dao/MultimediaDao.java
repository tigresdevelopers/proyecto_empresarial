package com.network.social.services.dao;

import java.util.List;

import com.network.social.domain.entities.Multimedia;
/**
* @author : Alexander Chavez Simbron
* @date   : 18 de oct. de 2015
* @time   : 11:38:51 p. m.
*/
public interface MultimediaDao extends BaseDao<Multimedia, Integer> {

	public List<Multimedia> getAllbyUser(Integer id);
	
	public List<Multimedia> getAllbyAlbum(Integer id);
	
	public List<Multimedia> getAllbyGrupo(Integer id);

	public List<Multimedia> getAllbyPublicacion(Integer id);
}
