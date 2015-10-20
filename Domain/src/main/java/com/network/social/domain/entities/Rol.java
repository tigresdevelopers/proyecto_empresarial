package com.network.social.domain.entities;

/**
 * 
 * @author :Alexander Chavez Simbron
 * @date   :19/10/2015
 * @time   :17:25 P.M
 */
public class Rol extends BaseBean {
	
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
