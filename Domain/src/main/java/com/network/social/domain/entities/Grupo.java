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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
/**
 * 
 * @author :Alexander Chavez Simbron
 * @date   :19/10/2015
 * @time   :17:25 P.M
 */
@Entity
@Table(name = "GRUPO")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Grupo extends BaseBean {
	private static final long serialVersionUID = 1L;

	private Integer idgrupo;
	private String nombre;
	private String descripcion;
	private Date fechaCreacion;
	private Set<Album> albums = new HashSet<Album>();
	private Set<Publicacion> publicacions = new HashSet<Publicacion>();
	private Set<GrupoUsuario> grupoUsuarios = new HashSet<GrupoUsuario>();

	public Grupo() {
	}

	public Grupo(Integer idgrupo) {
		this.idgrupo = idgrupo;
	}

	public Grupo(Integer idgrupo, String nombre, String descripcion, Date fechaCreacion, Set<Album> albums,
			Set<Publicacion> publicacions, Set<GrupoUsuario> grupoUsuarios) {
		this.idgrupo = idgrupo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaCreacion = fechaCreacion;
		this.albums = albums;
		this.publicacions = publicacions;
		this.grupoUsuarios = grupoUsuarios;
	}

	@Id
	@GenericGenerator(name="SQ_GENERATOR",strategy="sequence",parameters={@Parameter(name="sequence",value="SQ_GRUPO")})
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SQ_GENERATOR")
	@Column(name = "IDGRUPO", unique = true, nullable = false, precision = 22, scale = 0)
	public Integer getIdgrupo() {
		return this.idgrupo;
	}

	public void setIdgrupo(Integer idgrupo) {
		this.idgrupo = idgrupo;
	}

	@Column(name = "NOMBRE", length = 100)
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

	@Column(name = "FECHA_CREACION")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	@JsonManagedReference
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "grupo")
	public Set<Album> getAlbums() {
		return this.albums;
	}

	public void setAlbums(Set<Album> albums) {
		this.albums = albums;
	}

	@JsonManagedReference
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "grupo")
	public Set<Publicacion> getPublicacions() {
		return this.publicacions;
	}

	public void setPublicacions(Set<Publicacion> publicacions) {
		this.publicacions = publicacions;
	}

	@JsonManagedReference
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "grupo")
	public Set<GrupoUsuario> getGrupoUsuarios() {
		return this.grupoUsuarios;
	}

	public void setGrupoUsuarios(Set<GrupoUsuario> grupoUsuarios) {
		this.grupoUsuarios = grupoUsuarios;
	}

}
