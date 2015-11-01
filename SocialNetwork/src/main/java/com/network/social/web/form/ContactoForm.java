package com.network.social.web.form;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
/**
 * 
 * @author :Alexander Chavez Simbron
 * @date   :19/10/2015
 * @time   :17:25 P.M
 */
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class,property="idcontacto")
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

	
	public ContactoForm(Integer idcontacto) {
		super();
		this.idcontacto = idcontacto;
	}


	public ContactoForm(Integer idcontacto, ListaContactoForm listaContactos,
			UsuarioForm usuarioByMyid, UsuarioForm usuarioByIdusuario,
			TipoContactoForm tipoContacto, Date fechaInicioAmistad,
			char seguidor, char bloqueado) {
		super();
		this.idcontacto = idcontacto;
		this.listaContactos = listaContactos;
		this.usuarioByMyid = usuarioByMyid;
		this.usuarioByIdusuario = usuarioByIdusuario;
		this.tipoContacto = tipoContacto;
		this.fechaInicioAmistad = fechaInicioAmistad;
		this.seguidor = seguidor;
		this.bloqueado = bloqueado;
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
