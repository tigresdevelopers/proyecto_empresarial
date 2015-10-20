package com.network.social.services.dao.impl;

import org.springframework.stereotype.Repository;

import com.network.social.domain.entities.GrupoUsuario;
import com.network.social.domain.entities.GrupoUsuarioId;
import com.network.social.services.dao.GrupoUsuarioDao;

/**
* @author : Alexander Chavez Simbron
* @date   : 19 de oct. de 2015
* @time   : 11:40:14 p. m.
*/
@Repository(value="grupoUsuarioDao")
public class GrupoUsuarioDaoImpl extends BaseDaoImpl<GrupoUsuario, GrupoUsuarioId> implements GrupoUsuarioDao {

}


