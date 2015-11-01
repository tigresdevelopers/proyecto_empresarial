package com.network.social.web.form;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
/**
 * 
 * @author :Alexander Chavez Simbron
 * @date   :19/10/2015
 * @time   :17:25 P.M
 */
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class,property="idlike")
public class LikeForm extends BaseForm {
	private static final long serialVersionUID = 1L;

	private Integer idlike;
	private MultimediaForm multimedia;
	private PublicacionForm publicacion;
	private AlbumForm album;
	private ComentarioForm comentario;
	private UsuarioForm usuario;
	private Date fechaRegistro;
	private Set<NotificacionForm> notificacioneses = new HashSet<NotificacionForm>();
	private Set<ActividadForm> actividads = new HashSet<ActividadForm>();

	public LikeForm() {
	}

	public LikeForm(Integer idlike) {
		super();
		this.idlike = idlike;
	}

	public LikeForm(Integer idlike, MultimediaForm multimedia,
			PublicacionForm publicacion, AlbumForm album,
			ComentarioForm comentario, UsuarioForm usuario, Date fechaRegistro,
			Set<NotificacionForm> notificacioneses,
			Set<ActividadForm> actividads) {
		super();
		this.idlike = idlike;
		this.multimedia = multimedia;
		this.publicacion = publicacion;
		this.album = album;
		this.comentario = comentario;
		this.usuario = usuario;
		this.fechaRegistro = fechaRegistro;
		this.notificacioneses = notificacioneses;
		this.actividads = actividads;
	}

	public Integer getIdlike() {
		return idlike;
	}

	public void setIdlike(Integer idlike) {
		this.idlike = idlike;
	}

	public MultimediaForm getMultimedia() {
		return multimedia;
	}

	public void setMultimedia(MultimediaForm multimedia) {
		this.multimedia = multimedia;
	}

	public PublicacionForm getPublicacion() {
		return publicacion;
	}

	public void setPublicacion(PublicacionForm publicacion) {
		this.publicacion = publicacion;
	}

	public AlbumForm getAlbum() {
		return album;
	}

	public void setAlbum(AlbumForm album) {
		this.album = album;
	}

	public ComentarioForm getComentario() {
		return comentario;
	}

	public void setComentario(ComentarioForm comentario) {
		this.comentario = comentario;
	}

	public UsuarioForm getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioForm usuario) {
		this.usuario = usuario;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Set<NotificacionForm> getNotificacioneses() {
		return notificacioneses;
	}

	public void setNotificacioneses(Set<NotificacionForm> notificacioneses) {
		this.notificacioneses = notificacioneses;
	}

	public Set<ActividadForm> getActividads() {
		return actividads;
	}

	public void setActividads(Set<ActividadForm> actividads) {
		this.actividads = actividads;
	}

	
}
