package com.network.social.web.form;

import java.util.Date;
/**
 * 
 * @author :Alexander Chavez Simbron
 * @date   :19/10/2015
 * @time   :17:25 P.M
 */
public class ActividadForm extends BaseForm {
	private static final long serialVersionUID = 1L;
	
	private Integer idactividad;
	private LikeForm like;
	private PublicacionForm publicacion;
	private ComentarioForm comentario;
	private String descripcion;
	private Integer idusuario;
	private Date fechaActividad;

	public ActividadForm() {
	}

	
	
	public ActividadForm(Integer idactividad) {
		super();
		this.idactividad = idactividad;
	}



	public ActividadForm(Integer idactividad, LikeForm like,
			PublicacionForm publicacion, ComentarioForm comentario,
			String descripcion, Integer idusuario, Date fechaActividad) {
		super();
		this.idactividad = idactividad;
		this.like = like;
		this.publicacion = publicacion;
		this.comentario = comentario;
		this.descripcion = descripcion;
		this.idusuario = idusuario;
		this.fechaActividad = fechaActividad;
	}



	public Integer getIdactividad() {
		return idactividad;
	}

	public void setIdactividad(Integer idactividad) {
		this.idactividad = idactividad;
	}

	public LikeForm getLike() {
		return like;
	}

	public void setLike(LikeForm like) {
		this.like = like;
	}

	public PublicacionForm getPublicacion() {
		return publicacion;
	}

	public void setPublicacion(PublicacionForm publicacion) {
		this.publicacion = publicacion;
	}

	public ComentarioForm getComentario() {
		return comentario;
	}

	public void setComentario(ComentarioForm comentario) {
		this.comentario = comentario;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(Integer idusuario) {
		this.idusuario = idusuario;
	}

	public Date getFechaActividad() {
		return fechaActividad;
	}

	public void setFechaActividad(Date fechaActividad) {
		this.fechaActividad = fechaActividad;
	}

	

}