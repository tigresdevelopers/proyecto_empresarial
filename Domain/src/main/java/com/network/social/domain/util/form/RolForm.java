package com.network.social.domain.util.form;

import java.io.Serializable;
/**
 * 
 * @author Pantera
 *
 */
public class RolForm implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String descripcion;
	
	public RolForm() {
	}
	
	public RolForm(int id, String descripcion) {
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
