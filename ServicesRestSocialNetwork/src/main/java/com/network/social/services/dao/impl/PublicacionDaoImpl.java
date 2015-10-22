package com.network.social.services.dao.impl;

import static com.network.social.services.util.DAOUtil.QUERY_HQL.PUBLICACION_GRUPO;
import static com.network.social.services.util.DAOUtil.QUERY_HQL.PUBLICACION_USUARIO;
import static com.network.social.services.util.DAOUtil.SP_ORACLE.SP_PUBLICACION_USUARIO_LISTA;
import static com.network.social.services.util.DAOUtil.SP_ORACLE.SP_PUBLICACION_USUARIO_TIPO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.network.social.domain.entities.Publicacion;
import com.network.social.domain.entities.Usuario;
import com.network.social.services.config.PropiedadService;
import com.network.social.services.dao.PublicacionDao;

@SuppressWarnings("unchecked")
@Repository(value="publicacionDao")
public class PublicacionDaoImpl extends BaseDaoImpl<Publicacion, Integer> implements PublicacionDao {

	@Autowired
	private PropiedadService propiedadService;

	@Override
	public List<Publicacion> getAllbyUser(Integer id) {
		return (List<Publicacion>)getSessionFactory().getCurrentSession().createQuery(
				propiedadService.getProperty(PUBLICACION_USUARIO.getQuery()))
				.setParameter(PUBLICACION_USUARIO.getParameters()[0],id)
				.list();
	}

	@Override
	public List<Publicacion> getAllbyGrupo(Integer id) {
		return (List<Publicacion>)getSessionFactory().getCurrentSession().createQuery(
				propiedadService.getProperty(PUBLICACION_GRUPO.getQuery()))
				.setParameter(PUBLICACION_GRUPO.getParameters()[0],id)
				.list();
	}

	@Override
	public List<Publicacion> getAllbyUserTipo(Integer id, Integer idtipo) {
		
		List<Map<String, Object>> metadata=return_cursor(SP_PUBLICACION_USUARIO_TIPO.getProcedure(), id,idtipo);
		List<Publicacion> lista=new ArrayList<>(0);
		Publicacion p=null;
		
		for (Map<String, Object> map : metadata) {
			p=new Publicacion();
			p.setIdpublicacion(Integer.parseInt(map.get("idpublicacion").toString()));
			p.setContenido(map.get("contenido").toString());
			p.setLikes(Integer.parseInt(map.get("likes").toString()));
			p.setUsuarioByIdusuario(new Usuario(Integer.parseInt(map.get("idusuario").toString())));
			p.setUsuarioByIdusuarioReceiver(new Usuario(Integer.parseInt(map.get("idreceiver").toString())));
			lista.add(p);
		}
		
		return lista;
	}

	@Override
	public List<Publicacion> getAllbyUserLista(Integer id, Integer idlista) {
		
		List<Map<String, Object>> metadata=return_cursor(SP_PUBLICACION_USUARIO_LISTA.getProcedure(), id,idlista);
		List<Publicacion> lista=new ArrayList<>(0);
		Publicacion p=null;
		
		for (Map<String, Object> map : metadata) {
			p=new Publicacion();
			p.setIdpublicacion(Integer.parseInt(map.get("idpublicacion").toString()));
			p.setContenido(map.get("contenido").toString());
			p.setLikes(Integer.parseInt(map.get("likes").toString()));
			p.setUsuarioByIdusuario(new Usuario(Integer.parseInt(map.get("idusuario").toString())));
			p.setUsuarioByIdusuarioReceiver(new Usuario(Integer.parseInt(map.get("idreceiver").toString())));
			lista.add(p);
		}
		
		return lista;
	}

}
