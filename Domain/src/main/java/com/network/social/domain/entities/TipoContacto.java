package com.network.social.domain.entities;

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

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

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
@Table(name = "TIPO_CONTACTO")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class TipoContacto extends BaseBean {
	private static final long serialVersionUID = 1L;

	private Integer idtipoContacto;
	private String nombre;
	private Set<Multimedia> multimedias = new HashSet<Multimedia>();
	private Set<Contacto> contactos = new HashSet<Contacto>();
	private Set<Publicacion> publicacions = new HashSet<Publicacion>();

	public TipoContacto() {
	}

	public TipoContacto(Integer idtipoContacto) {
		this.idtipoContacto = idtipoContacto;
	}

	public TipoContacto(Integer idtipoContacto, String nombre, Set<Multimedia> multimedias, Set<Contacto> contactos,
			Set<Publicacion> publicacions) {
		this.idtipoContacto = idtipoContacto;
		this.nombre = nombre;
		this.multimedias = multimedias;
		this.contactos = contactos;
		this.publicacions = publicacions;
	}

	@Id
	@GenericGenerator(name="SQ_GENERATOR",strategy="sequence",parameters={@Parameter(name="sequence",value="SQ_TIPO_CONTACTO")})
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SQ_GENERATOR")
	@Column(name = "IDTIPO_CONTACTO", unique = true, nullable = false, precision = 22, scale = 0)
	public Integer getIdtipoContacto() {
		return this.idtipoContacto;
	}

	public void setIdtipoContacto(Integer idtipoContacto) {
		this.idtipoContacto = idtipoContacto;
	}

	@Column(name = "NOMBRE", length = 50)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@JsonManagedReference
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tipoContacto")
	public Set<Multimedia> getMultimedias() {
		return this.multimedias;
	}

	public void setMultimedias(Set<Multimedia> multimedias) {
		this.multimedias = multimedias;
	}

	@JsonManagedReference
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tipoContacto")
	public Set<Contacto> getContactos() {
		return this.contactos;
	}

	public void setContactos(Set<Contacto> contactos) {
		this.contactos = contactos;
	}

	@JsonManagedReference
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tipoContacto")
	public Set<Publicacion> getPublicacions() {
		return this.publicacions;
	}

	public void setPublicacions(Set<Publicacion> publicacions) {
		this.publicacions = publicacions;
	}

}
