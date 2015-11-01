package com.network.social.web.form;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * 
 * @author :Alexander Chavez Simbron
 * @date   :19/10/2015
 * @time   :17:25 P.M
 */
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class,property="idnotificacion")
public class NotificacionForm extends BaseForm {
	private static final long serialVersionUID = 1L;

	private Integer idnotificacion;
	private LikeForm like;
	private PublicacionForm publicacion;
	private ComentarioForm comentario;
	private Character leido;
	private String descripcion;

	public NotificacionForm() {
	}

	public NotificacionForm(Integer idnotificacion) {
		super();
		this.idnotificacion = idnotificacion;
	}

	public NotificacionForm(Integer idnotificacion, LikeForm like,
			PublicacionForm publicacion, ComentarioForm comentario,
			Character leido, String descripcion) {
		super();
		this.idnotificacion = idnotificacion;
		this.like = like;
		this.publicacion = publicacion;
		this.comentario = comentario;
		this.leido = leido;
		this.descripcion = descripcion;
	}

	public Integer getIdnotificacion() {
		return idnotificacion;
	}

	public void setIdnotificacion(Integer idnotificacion) {
		this.idnotificacion = idnotificacion;
	}

	@JsonIdentityReference(alwaysAsId=true)
	public LikeForm getLike() {
		return like;
	}

	public void setLike(LikeForm like) {
		this.like = like;
	}

	@JsonSetter
	public void setLike(Integer id) {
		if (id!=null) {
			this.like = new LikeForm(id);
		}
	}
	
	@JsonIdentityReference(alwaysAsId=true)
	public PublicacionForm getPublicacion() {
		return publicacion;
	}

	public void setPublicacion(PublicacionForm publicacion) {
		this.publicacion = publicacion;
	}

	@JsonSetter
	public void setPublicacion(Integer id) {
		if (id!=null) {
			this.publicacion = new PublicacionForm(id);
		}
	}
	
	@JsonIdentityReference(alwaysAsId=true)
	public ComentarioForm getComentario() {
		return comentario;
	}

	public void setComentario(ComentarioForm comentario) {
		this.comentario = comentario;
	}

	@JsonSetter
	public void setComentario(Integer id) {
		if (id!=null) {
			this.comentario = new ComentarioForm(id);
		}
	}
	
	public Character getLeido() {
		return leido;
	}

	public void setLeido(Character leido) {
		this.leido = leido;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	
}
