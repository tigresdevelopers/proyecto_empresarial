package com.network.social.web.form;


import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
/**
 * 
 * @author :Alexander Chavez Simbron
 * @date   :19/10/2015
 * @time   :17:25 P.M
 */
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class,property="id")
public class GrupoUsuarioForm extends BaseForm {
	private static final long serialVersionUID = 1L;

	private GrupoUsuarioIdForm id;
	private UsuarioForm usuario;
	private GrupoForm grupo;
	private char admin;
	private Date fechaRegistro;

	public GrupoUsuarioForm() {
	}

	public GrupoUsuarioForm(UsuarioForm usuario) {
		super();
		this.usuario = usuario;
	}

	public GrupoUsuarioForm(UsuarioForm usuario, GrupoForm grupo, char admin,
			Date fechaRegistro) {
		super();
		this.usuario = usuario;
		this.grupo = grupo;
		this.admin = admin;
		this.fechaRegistro = fechaRegistro;
	}

	
	public GrupoUsuarioIdForm getId() {
		return id;
	}

	public void setId(GrupoUsuarioIdForm id) {
		this.id = id;
	}

	@JsonIdentityReference(alwaysAsId=true)
	public UsuarioForm getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioForm usuario) {
		this.usuario = usuario;
	}
	
	@JsonSetter
	public void setUsuario(Integer id) {
		if (id!=null) {
			this.usuario = new UsuarioForm(id);
		}
	}

	@JsonIdentityReference(alwaysAsId=true)
	public GrupoForm getGrupo() {
		return grupo;
	}

	public void setGrupo(GrupoForm grupo) {
		this.grupo = grupo;
	}
	
	@JsonSetter
	public void setGrupo(Integer id) {
		if (id!=null) {
			this.grupo=new GrupoForm(id);
		}
	}

	public char getAdmin() {
		return admin;
	}

	public void setAdmin(char admin) {
		this.admin = admin;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	
}
