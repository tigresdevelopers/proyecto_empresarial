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
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class,property="idsolicitud")
public class SolicitudForm extends BaseForm {
	private static final long serialVersionUID = 1L;

	private Integer idsolicitud;
	private UsuarioForm usuarioByIdusuarioReceiver;
	private UsuarioForm usuarioByIdusuario;
	private Date fechaSolicitud;
	private Integer estado;

	public SolicitudForm() {
	}

	public SolicitudForm(Integer idsolicitud) {
		super();
		this.idsolicitud = idsolicitud;
	}

	public SolicitudForm(Integer idsolicitud,
			UsuarioForm usuarioByIdusuarioReceiver,
			UsuarioForm usuarioByIdusuario, Date fechaSolicitud, Integer estado) {
		super();
		this.idsolicitud = idsolicitud;
		this.usuarioByIdusuarioReceiver = usuarioByIdusuarioReceiver;
		this.usuarioByIdusuario = usuarioByIdusuario;
		this.fechaSolicitud = fechaSolicitud;
		this.estado = estado;
	}

	public Integer getIdsolicitud() {
		return idsolicitud;
	}

	public void setIdsolicitud(Integer idsolicitud) {
		this.idsolicitud = idsolicitud;
	}

	public UsuarioForm getUsuarioByIdusuarioReceiver() {
		return usuarioByIdusuarioReceiver;
	}

	public void setUsuarioByIdusuarioReceiver(UsuarioForm usuarioByIdusuarioReceiver) {
		this.usuarioByIdusuarioReceiver = usuarioByIdusuarioReceiver;
	}

	public UsuarioForm getUsuarioByIdusuario() {
		return usuarioByIdusuario;
	}

	public void setUsuarioByIdusuario(UsuarioForm usuarioByIdusuario) {
		this.usuarioByIdusuario = usuarioByIdusuario;
	}

	public Date getFechaSolicitud() {
		return fechaSolicitud;
	}

	public void setFechaSolicitud(Date fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	
}
