package com.network.social.web.form;

import java.io.Serializable;

public class UsuarioForm implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String nombre;
	private String clave;
	
	public UsuarioForm() {
		// TODO Auto-generated constructor stub
	}
	
	public UsuarioForm(String nombre, String clave) {
		super();
		this.nombre = nombre;
		this.clave = clave;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	
	

}
