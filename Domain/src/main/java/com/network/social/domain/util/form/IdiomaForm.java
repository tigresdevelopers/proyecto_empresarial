package com.network.social.domain.util.form;

import java.util.HashSet;
import java.util.Set;
/**
 * 
 * @author Pantera
 *
 */

public class IdiomaForm extends BaseForm {
	private static final long serialVersionUID = 1L;

	private Integer ididioma;
	private String nombre;
	private Set<UsuarioForm> usuarios = new HashSet<UsuarioForm>();

	public IdiomaForm() {
	}

	public Integer getIdidioma() {
		return ididioma;
	}

	public void setIdidioma(Integer ididioma) {
		this.ididioma = ididioma;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<UsuarioForm> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Set<UsuarioForm> usuarios) {
		this.usuarios = usuarios;
	}

	

}
