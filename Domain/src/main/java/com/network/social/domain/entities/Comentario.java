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

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * 
 * @author :Alexander Chavez Simbron
 * @date   :19/10/2015
 * @time   :17:25 P.M
 */
@Entity
@Table(name = "COMENTARIO")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idcomentario")
public class Comentario extends BaseBean {
	private static final long serialVersionUID = 1L;

	private Integer idcomentario;
	private Multimedia multimedia;
	private Publicacion publicacion;
	private Album album;
	private Usuario usuario;
	private String contenido;
	private Date fechaComentario;
	private Integer likes;
	private Set<Etiqueta> etiquetas = new HashSet<Etiqueta>();
	private Set<Notificacion> notificacioneses = new HashSet<Notificacion>();
	private Set<Like> likes_1 = new HashSet<Like>();
	private Set<Actividad> actividads = new HashSet<Actividad>();

	public Comentario() {
	}

	public Comentario(Integer idcomentario, Usuario usuario) {
		this.idcomentario = idcomentario;
		this.usuario = usuario;
	}

	public Comentario(Integer idcomentario, Multimedia multimedia, Publicacion publicacion, Album album,
			Usuario usuario, String contenido, Date fechaComentario, Integer likes, Set<Etiqueta> etiquetas,
			Set<Notificacion> notificacioneses, Set<Like> likes_1, Set<Actividad> actividads) {
		this.idcomentario = idcomentario;
		this.multimedia = multimedia;
		this.publicacion = publicacion;
		this.album = album;
		this.usuario = usuario;
		this.contenido = contenido;
		this.fechaComentario = fechaComentario;
		this.likes = likes;
		this.etiquetas = etiquetas;
		this.notificacioneses = notificacioneses;
		this.likes_1 = likes_1;
		this.actividads = actividads;
	}

	@Id
	@GenericGenerator(name="SQ_GENERATOR",strategy="sequence",parameters={@Parameter(name="sequence",value="SQ_COMENTARIO")})
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SQ_GENERATOR")
	@Column(name = "IDCOMENTARIO", unique = true, nullable = false, precision = 22, scale = 0)
	public Integer getIdcomentario() {
		return this.idcomentario;
	}

	public void setIdcomentario(Integer idcomentario) {
		this.idcomentario = idcomentario;
	}

	@JsonIdentityReference(alwaysAsId=true)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDMULTIMEDIA")
	public Multimedia getMultimedia() {
		return this.multimedia;
	}

	public void setMultimedia(Multimedia multimedia) {
		this.multimedia = multimedia;
	}
	
	@JsonSetter
	public void setMultimedia(Integer id) {
		this.multimedia =new Multimedia();
		this.multimedia.setIdmultimedia(id);
	}

	@JsonIdentityReference(alwaysAsId=true)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDPUBLICACION")
	public Publicacion getPublicacion() {
		return this.publicacion;
	}

	public void setPublicacion(Publicacion publicacion) {
		this.publicacion = publicacion;
	}
	
	@JsonSetter
	public void setPublicacion(Integer id) {
		this.publicacion = new Publicacion();
		this.publicacion.setIdpublicacion(id);
	}

	@JsonIdentityReference(alwaysAsId=true)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDALBUM")
	public Album getAlbum() {
		return this.album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	@JsonSetter
	public void setAlbum(Integer id) {
		this.album =new Album();
		this.album.setIdalbum(id);
	}

	@JsonManagedReference(value="comentario-usuario")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDUSUARIO", nullable = false)
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Column(name = "CONTENIDO")
	public String getContenido() {
		return this.contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	@Column(name = "FECHA_COMENTARIO")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getFechaComentario() {
		return this.fechaComentario;
	}

	public void setFechaComentario(Date fechaComentario) {
		this.fechaComentario = fechaComentario;
	}

	@Column(name = "LIKES", precision = 22, scale = 0)
	public Integer getLikes() {
		return this.likes;
	}

	public void setLikes(Integer likes) {
		this.likes = likes;
	}
	
	@JsonManagedReference(value="comentario-etiqueta")
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "comentario")
	public Set<Etiqueta> getEtiquetas() {
		return this.etiquetas;
	}

	public void setEtiquetas(Set<Etiqueta> etiquetas) {
		this.etiquetas = etiquetas;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "comentario")
	public Set<Notificacion> getNotificacioneses() {
		return this.notificacioneses;
	}

	public void setNotificacioneses(Set<Notificacion> notificacioneses) {
		this.notificacioneses = notificacioneses;
	}
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "comentario")
	public Set<Like> getLikes_1() {
		return this.likes_1;
	}

	public void setLikes_1(Set<Like> likes_1) {
		this.likes_1 = likes_1;
	}
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "comentario")
	public Set<Actividad> getActividads() {
		return this.actividads;
	}

	public void setActividads(Set<Actividad> actividads) {
		this.actividads = actividads;
	}

}
