package com.network.social.domain.entities;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SITUACION_SENTIMENTAL")
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "situacionSentimental")
	public Set<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}
