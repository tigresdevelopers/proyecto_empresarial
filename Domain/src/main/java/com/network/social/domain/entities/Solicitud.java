package com.network.social.domain.entities;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
/**
 * 
 * @author :Alexander Chavez Simbron
 * @date   :19/10/2015
 * @time   :17:25 P.M
 */
@Entity
@Table(name = "SOLICITUD")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class,property="@id")
public class Solicitud extends BaseBean {
	private static final long serialVersionUID = 1L;

	private Integer idsolicitud;
	private Usuario usuarioByIdusuarioReceiver;
	private Usuario usuarioByIdusuario;
	private Date fechaSolicitud;
	private Integer estado;

	public Solicitud() {
	}

	public Solicitud(Integer idsolicitud, Usuario usuarioByIdusuarioReceiver, Usuario usuarioByIdusuario,
			Integer estado) {
		this.idsolicitud = idsolicitud;
		this.usuarioByIdusuarioReceiver = usuarioByIdusuarioReceiver;
		this.usuarioByIdusuario = usuarioByIdusuario;
		this.estado = estado;
	}

	public Solicitud(Integer idsolicitud, Usuario usuarioByIdusuarioReceiver, Usuario usuarioByIdusuario,
			Date fechaSolicitud, Integer estado) {
		this.idsolicitud = idsolicitud;
		this.usuarioByIdusuarioReceiver = usuarioByIdusuarioReceiver;
		this.usuarioByIdusuario = usuarioByIdusuario;
		this.fechaSolicitud = fechaSolicitud;
		this.estado = estado;
	}

	@Id
	@GenericGenerator(name="SQ_GENERATOR",strategy="sequence",parameters={@Parameter(name="sequence",value="SQ_SOLICITUD")})
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SQ_GENERATOR")
	@Column(name = "IDSOLICITUD", unique = true, nullable = false, precision = 22, scale = 0)
	public Integer getIdsolicitud() {
		return this.idsolicitud;
	}

	public void setIdsolicitud(Integer idsolicitud) {
		this.idsolicitud = idsolicitud;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDUSUARIO_RECEIVER", nullable = false)
	public Usuario getUsuarioByIdusuarioReceiver() {
		return this.usuarioByIdusuarioReceiver;
	}

	public void setUsuarioByIdusuarioReceiver(Usuario usuarioByIdusuarioReceiver) {
		this.usuarioByIdusuarioReceiver = usuarioByIdusuarioReceiver;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDUSUARIO", nullable = false)
	public Usuario getUsuarioByIdusuario() {
		return this.usuarioByIdusuario;
	}

	public void setUsuarioByIdusuario(Usuario usuarioByIdusuario) {
		this.usuarioByIdusuario = usuarioByIdusuario;
	}

	@Column(name = "FECHA_SOLICITUD")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getFechaSolicitud() {
		return this.fechaSolicitud;
	}

	public void setFechaSolicitud(Date fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	@Column(name = "ESTADO", nullable = false, precision = 22, scale = 0)
	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

}
