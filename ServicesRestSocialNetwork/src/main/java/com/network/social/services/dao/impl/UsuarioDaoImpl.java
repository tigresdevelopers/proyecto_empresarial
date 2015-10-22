package com.network.social.services.dao.impl;

import static com.network.social.services.util.DAOUtil.QUERY_HQL.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.network.social.domain.entities.Contacto;
import com.network.social.domain.entities.Grupo;
import com.network.social.domain.entities.GrupoUsuario;
import com.network.social.domain.entities.ListaContacto;
import com.network.social.domain.entities.TipoContacto;
import com.network.social.domain.entities.Usuario;
import com.network.social.services.config.PropiedadService;
import com.network.social.services.dao.GrupoDao;
import com.network.social.services.dao.UsuarioDao;


@Repository(value="usuarioDao")
public class UsuarioDaoImpl extends BaseDaoImpl<Usuario, Integer> implements UsuarioDao {
	
	@Autowired
	PropiedadService propiedadService;
	
	@Autowired
	GrupoDao grupoDao;
	
	@Override
	public Usuario findByUsername(String username) {
		
		Map<String, Object> parameters=new HashMap<>();
		parameters.put(USUARIO_BY_EMAIL.getParameters()[0],username);
		
		return getByHQL(propiedadService.getQuery(USUARIO_BY_EMAIL), parameters,null);
	}

	@Override
	public List<Usuario> getAllbyUser(Integer id) {
		
		List<Usuario> contacts=new ArrayList<>(0);
		
		Usuario usuario=findById(id);
		
		Set<Contacto> sets =usuario.getContactosForMyid();
		
		for (Iterator<Contacto> iter = sets.iterator();iter.hasNext(); ) { 
			Contacto contacto = (Contacto) iter.next();
			contacts.add(contacto.getUsuarioByIdusuario());
		}
		
		return contacts;
	}

	@Override
	public List<Usuario> getAllbyGrupo(Integer id) {
		
		List<Usuario> members=new ArrayList<Usuario>(0);
		Grupo group=grupoDao.findById(id);
		
		if (group!=null) {

			Set<GrupoUsuario> groupUsers=group.getGrupoUsuarios();
			
			for (Iterator<GrupoUsuario> iterator = groupUsers.iterator(); iterator.hasNext();) {
				GrupoUsuario grupoUsuario =iterator.next();
				members.add(grupoUsuario.getUsuario());
			}
		}
		
		return members;
	}

	@Override
	public List<Usuario> getAllbyListaContacto(Integer id,Integer idlista) {
		
		List<Usuario> contacts=new ArrayList<>(0);
		
		Usuario usuario=findById(id);
		
		Set<Contacto> sets =usuario.getContactosForMyid();
		
		for (Iterator<Contacto> iter = sets.iterator();iter.hasNext(); ) { 
			 Contacto contacto = (Contacto) iter.next();
			 ListaContacto lstcontacto=contacto.getListaContactos();
				if(lstcontacto!=null){
					if (lstcontacto.getIdlistaContactos()==idlista){
						contacts.add(contacto.getUsuarioByIdusuario());
					}
				}
		}
		return contacts;
	}

	@Override
	public List<Usuario> getAllbyTipoContacto(Integer id,Integer idtipo) {
List<Usuario> contacts=new ArrayList<>(0);
		
		Usuario usuario=findById(id);
		
		Set<Contacto> sets =usuario.getContactosForMyid();
		
		for (Iterator<Contacto> iter = sets.iterator();iter.hasNext(); ) { 
			 Contacto contacto = (Contacto) iter.next();
			 TipoContacto tipocontacto=contacto.getTipoContacto();
				if(tipocontacto!=null){
					if (tipocontacto.getIdtipoContacto()==idtipo){
						contacts.add(contacto.getUsuarioByIdusuario());
					}
				}
		}
		return contacts;
	}

}
