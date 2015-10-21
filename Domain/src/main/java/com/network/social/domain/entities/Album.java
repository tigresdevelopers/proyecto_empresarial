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
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
/**
 * 
 * @author :Alexander Chavez Simbron
 * @date   :19/10/2015
 * @time   :17:25 P.M
 */
@Entity
@Table(name = "ALBUM", uniqueConstraints = @UniqueConstraint(columnNames = "IDPUBLICACION") )
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idalbum")
public class Album extends BaseBean {
	private static final long serialVersionUID = 1L;

	private Integer idalbum;
	private Publicacion publicacion;
	private Usuario usuario;
	private Grupo grupo;
	private String nombre;
	private String descripcion;
	private Integer likes;
	private Set<Multimedia> multimedias = new HashSet<Multimedia>();
	private Set<Like> likes_1 = new HashSet<Like>();
	private Set<Comentario> comentarios = new HashSet<Comentario>();

	public Album() {
	}

	public Album(Integer idalbum, Publicacion publicacion) {
		this.idalbum = idalbum;
		this.publicacion = publicacion;
	}

	public Album(Integer idalbum, Publicacion publicacion, Usuario usuario, Grupo grupo, String nombre,
			String descripcion, Integer likes, Set<Multimedia> multimedias, Set<Like> likes_1,
			Set<Comentario> comentarios) {
		this.idalbum = idalbum;
		this.publicacion = publicacion;
		this.usuario = usuario;
		this.grupo = grupo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.likes = likes;
		this.multimedias = multimedias;
		this.likes_1 = likes_1;
		this.comentarios = comentarios;
	}

	@Id
	@GenericGenerator(name="SQ_GENERATOR",strategy="sequence",parameters={@Parameter(name="sequence",value="SQ_ALBUM")})
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SQ_GENERATOR")
	@Column(name = "IDALBUM", unique = true, nullable = false, precision = 22, scale = 0)
	public Integer getIdalbum() {
		return this.idalbum;
	}

	public void setIdalbum(Integer idalbum) {
		this.idalbum = idalbum;
	}

	@JsonIdentityReference(alwaysAsId=true)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDPUBLICACION", unique = true, nullable = false)
	public Publicacion getPublicacion() {
		return this.publicacion;
	}

	public void setPublicacion(Publicacion publicacion) {
		this.publicacion = publicacion;
	}
	
	@JsonSetter
	public void setPublicacion(Integer id) {
		this.publicacion =new Publicacion();
		this.publicacion.setIdpublicacion(id);
	}

	@JsonIdentityReference(alwaysAsId=true)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDUSUARIO")
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	@JsonSetter
	public void setUsuario(Integer id) {
		this.usuario = new Usuario();
		this.usuario.setIdusuario(id);
	}

	@JsonIdentityReference(alwaysAsId=true)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDGRUPO")
	public Grupo getGrupo() {
		return this.grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	@JsonSetter
	public void setGrupo(Integer id) {
		this.grupo =new Grupo();
		this.grupo.setIdgrupo(id);
	}
	
	@Column(name = "NOMBRE", length = 50)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "DESCRIPCION")
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Column(name = "LIKES", precision = 22, scale = 0)
	public Integer getLikes() {
		return this.likes;
	}

	public void setLikes(Integer likes) {
		this.likes = likes;
	}
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "album")
	public Set<Multimedia> getMultimedias() {
		return this.multimedias;
	}

	public void setMultimedias(Set<Multimedia> multimedias) {
		this.multimedias = multimedias;
	}
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "album")
	public Set<Like> getLikes_1() {
		return this.likes_1;
	}

	public void setLikes_1(Set<Like> likes_1) {
		this.likes_1 = likes_1;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "album")
	public Set<Comentario> getComentarios() {
		return this.comentarios;
	}

	public void setComentarios(Set<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

}
