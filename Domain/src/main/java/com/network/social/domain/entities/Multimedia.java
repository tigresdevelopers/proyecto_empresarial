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

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
/**
 * 
 * @author :Alexander Chavez Simbron
 * @date   :19/10/2015
 * @time   :17:25 P.M
 */
@Entity
@Table(name = "MULTIMEDIA")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class,property="@id")
public class Multimedia extends BaseBean {
	private static final long serialVersionUID = 1L;

	private Integer idmultimedia;
	private Publicacion publicacion;
	private Album album;
	private ListaContacto listaContactos;
	private TipoContacto tipoContacto;
	private String nombreArchivo;
	private String descripcion;
	private Integer tipo;
	private Integer likes;
	private Set<Comentario> comentarios = new HashSet<Comentario>();
	private Set<Like> likes_1 = new HashSet<Like>();
	private Set<Etiqueta> etiquetas = new HashSet<Etiqueta>();

	public Multimedia() {
	}

	public Multimedia(Integer idmultimedia, Publicacion publicacion, Album album, String nombreArchivo) {
		this.idmultimedia = idmultimedia;
		this.publicacion = publicacion;
		this.album = album;
		this.nombreArchivo = nombreArchivo;
	}

	public Multimedia(Integer idmultimedia, Publicacion publicacion, Album album, ListaContacto listaContactos,
			TipoContacto tipoContacto, String nombreArchivo, String descripcion, Integer tipo, Integer likes,
			Set<Comentario> comentarios, Set<Like> likes_1, Set<Etiqueta> etiquetas) {
		this.idmultimedia = idmultimedia;
		this.publicacion = publicacion;
		this.album = album;
		this.listaContactos = listaContactos;
		this.tipoContacto = tipoContacto;
		this.nombreArchivo = nombreArchivo;
		this.descripcion = descripcion;
		this.tipo = tipo;
		this.likes = likes;
		this.comentarios = comentarios;
		this.likes_1 = likes_1;
		this.etiquetas = etiquetas;
	}

	@Id
	@GenericGenerator(name="SQ_GENERATOR",strategy="sequence",parameters={@Parameter(name="sequence",value="SQ_MULTIMEDIA")})
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SQ_GENERATOR")
	@Column(name = "IDMULTIMEDIA", unique = true, nullable = false, precision = 22, scale = 0)
	public Integer getIdmultimedia() {
		return this.idmultimedia;
	}

	public void setIdmultimedia(Integer idmultimedia) {
		this.idmultimedia = idmultimedia;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDPUBLICACION", nullable = false)
	public Publicacion getPublicacion() {
		return this.publicacion;
	}

	public void setPublicacion(Publicacion publicacion) {
		this.publicacion = publicacion;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDALBUM", nullable = false)
	public Album getAlbum() {
		return this.album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDLISTA_CONTACTOS")
	public ListaContacto getListaContactos() {
		return this.listaContactos;
	}

	public void setListaContactos(ListaContacto listaContactos) {
		this.listaContactos = listaContactos;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDTIPO_CONTACTO")
	public TipoContacto getTipoContacto() {
		return this.tipoContacto;
	}

	public void setTipoContacto(TipoContacto tipoContacto) {
		this.tipoContacto = tipoContacto;
	}

	@Column(name = "NOMBRE_ARCHIVO", nullable = false, length = 200)
	public String getNombreArchivo() {
		return this.nombreArchivo;
	}

	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	@Column(name = "DESCRIPCION")
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Column(name = "TIPO", precision = 22, scale = 0)
	public Integer getTipo() {
		return this.tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	@Column(name = "LIKES", precision = 22, scale = 0)
	public Integer getLikes() {
		return this.likes;
	}

	public void setLikes(Integer likes) {
		this.likes = likes;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "multimedia")
	public Set<Comentario> getComentarios() {
		return this.comentarios;
	}

	public void setComentarios(Set<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "multimedia")
	public Set<Like> getLikes_1() {
		return this.likes_1;
	}

	public void setLikes_1(Set<Like> likes_1) {
		this.likes_1 = likes_1;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "multimedia")
	public Set<Etiqueta> getEtiquetas() {
		return this.etiquetas;
	}

	public void setEtiquetas(Set<Etiqueta> etiquetas) {
		this.etiquetas = etiquetas;
	}

}
