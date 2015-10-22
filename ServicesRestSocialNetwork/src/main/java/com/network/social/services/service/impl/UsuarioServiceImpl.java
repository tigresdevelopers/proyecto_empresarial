package com.network.social.services.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.network.social.domain.entities.Usuario;
import com.network.social.services.dao.UsuarioDao;
import com.network.social.services.service.UsuarioService;

@Service(value="usuarioService")
public class UsuarioServiceImpl extends BaseServiceImpl<Usuario,Integer> implements UsuarioService {

	UsuarioDao usuarioDao;
	
	@Autowired
	public UsuarioServiceImpl(UsuarioDao usuarioDao) {
		super(usuarioDao);
		this.usuarioDao=usuarioDao;
	}

	@Override
	public Usuario findByUsername(String username) {
		return usuarioDao.findByUsername(username);
	}

	@Override
	public List<Usuario> getAllbyUser(Integer id) {
		return usuarioDao.getAllbyUser(id);
	}

	@Override
	public List<Usuario> getAllbyGrupo(Integer id) {
		return usuarioDao.getAllbyGrupo(id);
	}

	@Override
	public List<Usuario> getAllbyListaContacto(Integer id,Integer idlista) {
		return usuarioDao.getAllbyListaContacto(id,idlista);
	}

	@Override
	public List<Usuario> getAllbyTipoContacto(Integer id,Integer idtipo) {
		return usuarioDao.getAllbyTipoContacto(id,idtipo);
	}

}
