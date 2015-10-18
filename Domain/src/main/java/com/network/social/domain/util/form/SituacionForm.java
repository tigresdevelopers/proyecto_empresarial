package com.network.social.domain.util.form;


import java.util.HashSet;
import java.util.Set;
/**
 * 
 * @author Pantera
 *
 */

public class SituacionForm extends BaseForm {
	private static final long serialVersionUID = 1L;
	
	private Integer idsituacion;
	private String descripcion;
	private Set<UsuarioForm> usuarios = new HashSet<UsuarioForm>(0);

	public SituacionForm() {
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
