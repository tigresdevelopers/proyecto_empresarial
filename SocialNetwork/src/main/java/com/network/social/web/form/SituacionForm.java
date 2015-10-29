package com.network.social.web.form;


import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
/**
 * 
 * @author :Alexander Chavez Simbron
 * @date   :19/10/2015
 * @time   :17:25 P.M
 */
//@JsonSerialize
public class SituacionForm extends BaseForm {
	private static final long serialVersionUID = 1L;
	
	private Integer idsituacion;
	private String descripcion;
	private Set<UsuarioForm> usuarios = new HashSet<UsuarioForm>(0);

	
	public SituacionForm() {
	}
	
	
	
	public SituacionForm(Integer idsituacion) {
		super();
		this.idsituacion = idsituacion;
	}
	
	public SituacionForm(Integer idsituacion, String descripcion) {
		super();
		this.idsituacion = idsituacion;
		this.descripcion = descripcion;
	}

	public SituacionForm(Integer idsituacion, String descripcion,
			Set<UsuarioForm> usuarios) {
		super();
		this.idsituacion = idsituacion;
		this.descripcion = descripcion;
		this.usuarios = usuarios;
	}


	public Integer getIdsituacion() {
		return idsituacion;
	}

	public void setIdsituacion(Integer idsituacion) {
		this.idsituacion = idsituacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Set<UsuarioForm> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Set<UsuarioForm> usuarios) {
		this.usuarios = usuarios;
	}

	
}
