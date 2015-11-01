package com.network.social.web.form;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
/**
 * 
 * @author :Alexander Chavez Simbron
 * @date   :19/10/2015
 * @time   :17:25 P.M
 */
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class,property="ididioma")
@JsonIgnoreProperties({"usuarios"})
public class IdiomaForm extends BaseForm {
	private static final long serialVersionUID = 1L;

	private Integer ididioma;
	private String nombre;
	private Set<UsuarioForm> usuarios = new HashSet<UsuarioForm>();

	public IdiomaForm() {
	}

	public IdiomaForm(Integer ididioma) {
		super();
		this.ididioma = ididioma;
	}

	public IdiomaForm(Integer ididioma, String nombre, Set<UsuarioForm> usuarios) {
		super();
		this.ididioma = ididioma;
		this.nombre = nombre;
		this.usuarios = usuarios;
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
