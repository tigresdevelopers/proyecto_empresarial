package com.network.social.domain.entities;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
/**
 * 
 * @author :Alexander Chavez Simbron
 * @date   :19/10/2015
 * @time   :17:25 P.M
 */
@Entity
@Table(name = "\"Like\"")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Like extends BaseBean {
	private static final long serialVersionUID = 1L;

	private Integer idlike;
	private Multimedia multimedia;
	private Publicacion publicacion;
	private Album album;
	private Comentario comentario;
	private Usuario usuario;
	private Date fechaRegistro;
	private Set<Notificacion> notificacioneses = new HashSet<Notificacion>();
	private Set<Actividad> actividads = new HashSet<Actividad>();

	public Like() {
	}

	public Like(Integer idlike, Usuario usuario, Date fechaRegistro) {
		this.idlike = idlike;
		this.usuario = usuario;
		this.fechaRegistro = fechaRegistro;
	}

	public Like(Integer idlike, Multimedia multimedia, Publicacion publicacion, Album album, Comentario comentario,
			Usuario usuario, Date fechaRegistro, Set<Notificacion> notificacioneses,
			Set<Actividad> actividads) {
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

	@Id
	@GenericGenerator(name="SQ_GENERATOR",strategy="sequence",parameters={@Parameter(name="sequence",value="SQ_LIKE")})
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SQ_GENERATOR")
	@Column(name = "IDLIKE", unique = true, nullable = false, precision = 22, scale = 0)
	public Integer getIdlike() {
		return this.idlike;
	}

	public void setIdlike(Integer idlike) {
		this.idlike = idlike;
	}

	@JsonBackReference
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDMULTIMEDIA")
	public Multimedia getMultimedia() {
		return this.multimedia;
	}

	public void setMultimedia(Multimedia multimedia) {
		this.multimedia = multimedia;
	}

	@JsonBackReference
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDPUBLICACION")
	public Publicacion getPublicacion() {
		return this.publicacion;
	}

	public void setPublicacion(Publicacion publicacion) {
		this.publicacion = publicacion;
	}

	@JsonBackReference
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDALBUM")
	public Album getAlbum() {
		return this.album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	@JsonBackReference
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDCOMENTARIO")
	public Comentario getComentario() {
		return this.comentario;
	}

	public void setComentario(Comentario comentario) {
		this.comentario = comentario;
	}
	
	@JsonBackReference
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDUSUARIO", nullable = false)
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Column(name = "FECHA_REGISTRO", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	
	@JsonManagedReference
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "like")
	public Set<Notificacion> getNotificacioneses() {
		return this.notificacioneses;
	}

	public void setNotificacioneses(Set<Notificacion> notificacioneses) {
		this.notificacioneses = notificacioneses;
	}
	
	@JsonManagedReference
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "like")
	public Set<Actividad> getActividads() {
		return this.actividads;
	}

	public void setActividads(Set<Actividad> actividads) {
		this.actividads = actividads;
	}

}
