package com.network.social.services.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.network.social.domain.entities.Comentario;
import com.network.social.domain.entities.Like;
import com.network.social.domain.entities.Notificacion;
import com.network.social.domain.entities.Publicacion;
import com.network.social.services.dao.NotificacionDao;
import com.network.social.services.util.DAOUtil.SP_ORACLE;


@Repository(value="notificacionDao")
public class NotificacionDaoImpl extends BaseDaoImpl<Notificacion, Integer> implements NotificacionDao {

	
	@Override
	public List<Notificacion> getAllbyUser(Integer id) {
		List<Notificacion> notificaciones=new ArrayList<Notificacion>();
		
		List<Map<String, Object>> refcursor=return_cursor(SP_ORACLE.SP_GET_NOTIFICACIONES_RS.getProcedure(), id);
		
		Notificacion obj=null;
		
		if (refcursor!=null && refcursor.size()>0) {
			for (Map<String, Object> row : refcursor) {
				obj=new Notificacion();
				obj.setIdnotificacion(Integer.parseInt(row.get("idnotificacion").toString()));
				obj.setLeido(String.valueOf(row.get("leido")));
				obj.setDescripcion(String.valueOf(row.get("descripcion")));
				obj.setPublicacion(
						new Publicacion(Integer.valueOf(String.valueOf(row.get("idpublicacion"))))
						);
				obj.setComentario(
						new Comentario(Integer.valueOf(String.valueOf(row.get("idcomentario"))))
						);
				obj.setLike(
						new Like(Integer.valueOf(String.valueOf(row.get("idlike"))))
						);
				notificaciones.add(obj);
			}
			
		}
		return notificaciones;
	}

}
