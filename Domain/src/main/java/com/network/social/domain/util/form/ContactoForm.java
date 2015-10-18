package com.network.social.domain.util.form;

import java.util.Date;



public class ContactoForm extends BaseForm {
	private static final long serialVersionUID = 1L;

	private Integer idcontacto;
	private ListaContactoForm listaContactos;
	private UsuarioForm usuarioByMyid;
	private UsuarioForm usuarioByIdusuario;
	private TipoContactoForm tipoContacto;
	private Date fechaInicioAmistad;
	private char seguidor;
	private char bloqueado;

	public ContactoForm() {
	}

	public Integer getIdcontacto() {
		return idcontacto;
	}

	public void setIdcontacto(Integer idcontacto) {
		this.idcontacto = idcontacto;
	}

	public ListaContactoForm getListaContactos() {
		return listaContactos;
	}

	public void setListaContactos(ListaContactoForm listaContactos) {
		this.listaContactos = listaContactos;
	}

	public UsuarioForm getUsuarioByMyid() {
		return usuarioByMyid;
	}

	public void setUsuarioByMyid(UsuarioForm usuarioByMyid) {
		this.usuarioByMyid = usuarioByMyid;
	}

	public UsuarioForm getUsuarioByIdusuario() {
		return usuarioByIdusuario;
	}

	public void setUsuarioByIdusuario(UsuarioForm usuarioByIdusuario) {
		this.usuarioByIdusuario = usuarioByIdusuario;
	}

	public TipoContactoForm getTipoContacto() {
		return tipoContacto;
	}

	public void setTipoContacto(TipoContactoForm tipoContacto) {
		this.tipoContacto = tipoContacto;
	}

	public Date getFechaInicioAmistad() {
		return fechaInicioAmistad;
	}

	public void setFechaInicioAmistad(Date fechaInicioAmistad) {
		this.fechaInicioAmistad = fechaInicioAmistad;
	}

	public char getSeguidor() {
		return seguidor;
	}

	public void setSeguidor(char seguidor) {
		this.seguidor = seguidor;
	}

	public char getBloqueado() {
		return bloqueado;
	}

	public void setBloqueado(char bloqueado) {
		this.bloqueado = bloqueado;
	}

	
}
