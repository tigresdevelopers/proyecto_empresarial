package com.network.social.web.form;


import java.util.Date;
/**
 * 
 * @author :Alexander Chavez Simbron
 * @date   :19/10/2015
 * @time   :17:25 P.M
 */
public class GrupoUsuarioForm extends BaseForm {
	private static final long serialVersionUID = 1L;

	private UsuarioForm usuario;
	private GrupoForm grupo;
	private char admin;
	private Date fechaRegistro;

	public GrupoUsuarioForm() {
	}

	public UsuarioForm getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioForm usuario) {
		this.usuario = usuario;
	}

	public GrupoForm getGrupo() {
		return grupo;
	}

	public void setGrupo(GrupoForm grupo) {
		this.grupo = grupo;
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
