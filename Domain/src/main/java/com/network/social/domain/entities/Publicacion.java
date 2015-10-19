package com.network.social.domain.entities;


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
@Table(name = "PUBLICACION")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Publicacion extends BaseBean {
	private static final long serialVersionUID = 1L;

	private Integer idpublicacion;
	private ListaContacto listaContactos;
	private Usuario usuarioByIdusuarioReceiver;
	private Usuario usuarioByIdusuario;
	private TipoContacto tipoContacto;
	private Grupo grupo;
	private String contenido;
	private String nombreArchivo;
	private Integer likes;
	private Set<Etiqueta> etiquetas = new HashSet<Etiqueta>();
	private Set<Album> albums = new HashSet<Album>();
	private Set<Actividad> actividads = new HashSet<Actividad>();
	private Set<Multimedia> multimedias = new HashSet<Multimedia>();
	private Set<Like> likes_1 = new HashSet<Like>();
	private Set<Comentario> comentarios = new HashSet<Comentario>();
	private Set<Notificacion> notificacioneses = new HashSet<Notificacion>();

	public Publicacion() {
	}

	public Publicacion(Integer idpublicacion) {
		this.idpublicacion = idpublicacion;
	}

	public Publicacion(Integer idpublicacion, ListaContacto listaContactos, Usuario usuarioByIdusuarioReceiver,
			Usuario usuarioByIdusuario, TipoContacto tipoContacto, Grupo grupo, String contenido, String nombreArchivo,
			Integer likes, Set<Etiqueta> etiquetas, Set<Album> albums, Set<Actividad> actividads,
			Set<Multimedia> multimedias, Set<Like> likes_1, Set<Comentario> comentarios,
			Set<Notificacion> notificacioneses) {
		this.idpublicacion = idpublicacion;
		this.listaContactos = listaContactos;
		this.usuarioByIdusuarioReceiver = usuarioByIdusuarioReceiver;
		this.usuarioByIdusuario = usuarioByIdusuario;
		this.tipoContacto = tipoContacto;
		this.grupo = grupo;
		this.contenido = contenido;
		this.nombreArchivo = nombreArchivo;
		this.likes = likes;
		this.etiquetas = etiquetas;
		this.albums = albums;
		this.actividads = actividads;
		this.multimedias = multimedias;
		this.likes_1 = likes_1;
		this.comentarios = comentarios;
		this.notificacioneses = notificacioneses;
	}

	@Id
	@GenericGenerator(name="SQ_GENERATOR",strategy="sequence",parameters={@Parameter(name="sequence",value="SQ_PUBLICACION")})
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SQ_GENERATOR")
	@Column(name = "IDPUBLICACION", unique = true, nullable = false, precision = 22, scale = 0)
	public Integer getIdpublicacion() {
		return this.idpublicacion;
	}

	public void setIdpublicacion(Integer idpublicacion) {
		this.idpublicacion = idpublicacion;
	}

	@JsonBackReference
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDLISTA_CONTACTOS")
	public ListaContacto getListaContactos() {
		return this.listaContactos;
	}

	public void setListaContactos(ListaContacto listaContactos) {
		this.listaContactos = listaContactos;
	}

	@JsonBackReference
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDUSUARIO_RECEIVER")
	public Usuario getUsuarioByIdusuarioReceiver() {
		return this.usuarioByIdusuarioReceiver;
	}

	public void setUsuarioByIdusuarioReceiver(Usuario usuarioByIdusuarioReceiver) {
		this.usuarioByIdusuarioReceiver = usuarioByIdusuarioReceiver;
	}

	@JsonBackReference
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDUSUARIO")
	public Usuario getUsuarioByIdusuario() {
		return this.usuarioByIdusuario;
	}

	public void setUsuarioByIdusuario(Usuario usuarioByIdusuario) {
		this.usuarioByIdusuario = usuarioByIdusuario;
	}

	@JsonBackReference
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDTIPO_CONTACTO")
	public TipoContacto getTipoContacto() {
		return this.tipoContacto;
	}

	public void setTipoContacto(TipoContacto tipoContacto) {
		this.tipoContacto = tipoContacto;
	}

	@JsonBackReference
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDGRUPO")
	public Grupo getGrupo() {
		return this.grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	@Column(name = "CONTENIDO")
	public String getContenido() {
		return this.contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	@Column(name = "NOMBRE_ARCHIVO", length = 200)
	public String getNombreArchivo() {
		return this.nombreArchivo;
	}

	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	@Column(name = "LIKES", precision = 22, scale = 0)
	public Integer getLikes() {
		return this.likes;
	}

	public void setLikes(Integer likes) {
		this.likes = likes;
	}
	
	@JsonManagedReference
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "publicacion")
	public Set<Etiqueta> getEtiquetas() {
		return this.etiquetas;
	}

	public void setEtiquetas(Set<Etiqueta> etiquetas) {
		this.etiquetas = etiquetas;
	}
	
	@JsonManagedReference
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "publicacion")
	public Set<Album> getAlbums() {
		return this.albums;
	}

	public void setAlbums(Set<Album> albums) {
		this.albums = albums;
	}

	@JsonManagedReference
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "publicacion")
	public Set<Actividad> getActividads() {
		return this.actividads;
	}

	public void setActividads(Set<Actividad> actividads) {
		this.actividads = actividads;
	}

	@JsonManagedReference
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "publicacion")
	public Set<Multimedia> getMultimedias() {
		return this.multimedias;
	}

	public void setMultimedias(Set<Multimedia> multimedias) {
		this.multimedias = multimedias;
	}

	@JsonManagedReference
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "publicacion")
	public Set<Like> getLikes_1() {
		return this.likes_1;
	}

	public void setLikes_1(Set<Like> likes_1) {
		this.likes_1 = likes_1;
	}
	
	@JsonManagedReference
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "publicacion")
	public Set<Comentario> getComentarios() {
		return this.comentarios;
	}

	public void setComentarios(Set<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	@JsonManagedReference
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "publicacion")
	public Set<Notificacion> getNotificacioneses() {
		return this.notificacioneses;
	}

	public void setNotificacioneses(Set<Notificacion> notificacioneses) {
		this.notificacioneses = notificacioneses;
	}

}
