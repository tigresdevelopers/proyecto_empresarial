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

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
/**
 * 
 * @author :Alexander Chavez Simbron
 * @date   :19/10/2015
 * @time   :17:25 P.M
 */
@Entity
@Table(name = "SITUACION_SENTIMENTAL")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idsituacion")
public class Situacion extends BaseBean {
	private static final long serialVersionUID = 1L;
	
	private Integer idsituacion;
	private String descripcion;
	private Set<Usuario> usuarios = new HashSet<Usuario>(0);

	public Situacion() {
	}

	public Situacion(Integer idsituacion) {
		this.idsituacion = idsituacion;
	}

	public Situacion(Integer idsituacion, String descripcion, Set<Usuario> usuarios) {
		this.idsituacion = idsituacion;
		this.descripcion = descripcion;
		this.usuarios = usuarios;
	}

	@Id
	@GenericGenerator(name="SQ_GENERATOR",strategy="sequence",parameters={@Parameter(name="sequence",value="SQ_SITUACION_SENTIMENTAL")})
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SQ_GENERATOR")
	@Column(name = "IDSITUACION", unique = true, nullable = false, precision = 22, scale = 0)
	public Integer getIdsituacion() {
		return this.idsituacion;
	}

	public void setIdsituacion(Integer idsituacion) {
		this.idsituacion = idsituacion;
	}

	@Column(name = "DESCRIPCION", length = 50)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "situacionSentimental")
	public Set<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((idsituacion == null) ? 0 : idsituacion.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof Situacion ? ((Situacion)obj).getIdsituacion()==this.idsituacion :false;
	}
	
	
	
	

}
