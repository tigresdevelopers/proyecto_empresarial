package com.network.social.web.form;

/**
 * 
 * @author :Alexander Chavez Simbron
 * @date   :19/10/2015
 * @time   :17:25 P.M
 */
public class RolForm extends BaseForm {
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String descripcion;
	
	public RolForm() {
	}
	
	public RolForm(int id) {
		super();
		this.id = id;
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
