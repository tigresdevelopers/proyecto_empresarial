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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "IDIOMA")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class,property="@id")
public class Idioma extends BaseBean {
	private static final long serialVersionUID = 1L;

	private Integer ididioma;
	private String nombre;
	private Set<Usuario> usuarios = new HashSet<Usuario>();

	public Idioma() {
	}

	public Idioma(Integer ididioma) {
		this.ididioma = ididioma;
	}

	public Idioma(Integer ididioma, String nombre, Set<Usuario> usuarios) {
		this.ididioma = ididioma;
		this.nombre = nombre;
		this.usuarios = usuarios;
	}

	@Id
	@GenericGenerator(name="SQ_GENERATOR",strategy="sequence",parameters={@Parameter(name="sequence",value="SQ_IDIOMA")})
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SQ_GENERATOR")
	@Column(name = "IDIDIOMA", unique = true, nullable = false, precision = 22, scale = 0)
	public Integer getIdidioma() {
		return this.ididioma;
	}

	public void setIdidioma(Integer ididioma) {
		this.ididioma = ididioma;
	}

	@Column(name = "NOMBRE", length = 50)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "USUARIO_IDIOMA", joinColumns = {
			@JoinColumn(name = "IDIDIOMA", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "IDUSUARIO", nullable = false, updatable = false) })
	public Set<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}
