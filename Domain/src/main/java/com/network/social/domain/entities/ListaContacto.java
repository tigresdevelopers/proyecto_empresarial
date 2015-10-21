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
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
/**
 * 
 * @author :Alexander Chavez Simbron
 * @date   :19/10/2015
 * @time   :17:25 P.M
 */
@Entity
@Table(name = "LISTA_CONTACTOS")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idlistaContactos")
public class ListaContacto extends BaseBean {
	private static final long serialVersionUID = 1L;

	private Integer idlistaContactos;
	private Usuario usuario;
	private String nombre;
	private Date fechaCreacion;
	private Set<Multimedia> multimedias = new HashSet<Multimedia>();
	private Set<Contacto> contactos = new HashSet<Contacto>();
	private Set<Publicacion> publicacions = new HashSet<Publicacion>();

	public ListaContacto() {
	}

	public ListaContacto(Integer idlistaContactos, Usuario usuario) {
		this.idlistaContactos = idlistaContactos;
		this.usuario = usuario;
	}

	public ListaContacto(Integer idlistaContactos, Usuario usuario, String nombre, Date fechaCreacion,
			Set<Multimedia> multimedias, Set<Contacto> contactos, Set<Publicacion> publicacions) {
		this.idlistaContactos = idlistaContactos;
		this.usuario = usuario;
		this.nombre = nombre;
		this.fechaCreacion = fechaCreacion;
		this.multimedias = multimedias;
		this.contactos = contactos;
		this.publicacions = publicacions;
	}

	@Id
	@GenericGenerator(name="SQ_GENERATOR",strategy="sequence",parameters={@Parameter(name="sequence",value="SQ_LISTA_CONTACTOS")})
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SQ_GENERATOR")
	@Column(name = "IDLISTA_CONTACTOS", unique = true, nullable = false, precision = 22, scale = 0)
	public Integer getIdlistaContactos() {
		return this.idlistaContactos;
	}

	public void setIdlistaContactos(Integer idlistaContactos) {
		this.idlistaContactos = idlistaContactos;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDUSUARIO", nullable = false)
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Column(name = "NOMBRE", length = 100)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "FECHA_CREACION")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "listaContactos")
	public Set<Multimedia> getMultimedias() {
		return this.multimedias;
	}

	public void setMultimedias(Set<Multimedia> multimedias) {
		this.multimedias = multimedias;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "listaContactos")
	public Set<Contacto> getContactos() {
		return this.contactos;
	}

	public void setContactos(Set<Contacto> contactos) {
		this.contactos = contactos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "listaContactos")
	public Set<Publicacion> getPublicacions() {
		return this.publicacions;
	}

	public void setPublicacions(Set<Publicacion> publicacions) {
		this.publicacions = publicacions;
	}

}
