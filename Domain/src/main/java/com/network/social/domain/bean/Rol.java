package com.network.social.domain.bean;

import java.io.Serializable;

public class Rol implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String descripcion;
	
	public Rol() {
	}
	
	public Rol(int id, String descripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
