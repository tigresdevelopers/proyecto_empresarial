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
/**
 * 
 * @author :Alexander Chavez Simbron
 * @date   :19/10/2015
 * @time   :17:25 P.M
 */
@Entity
@Table(name = "CONTACTO")
public class Contacto extends BaseBean {
	private static final long serialVersionUID = 1L;

	private Integer idcontacto;
	private ListaContacto listaContactos;
	private Usuario usuarioByMyid;
	private Usuario usuarioByIdusuario;
	private TipoContacto tipoContacto;
	private Date fechaInicioAmistad;
	private char seguidor;
	private char bloqueado;

	public Contacto() {
	}

	public Contacto(Integer idcontacto, Usuario usuarioByMyid, Usuario usuarioByIdusuario,
			Date fechaInicioAmistad, char seguidor, char bloqueado) {
		this.idcontacto = idcontacto;
		this.usuarioByMyid = usuarioByMyid;
		this.usuarioByIdusuario = usuarioByIdusuario;
		this.fechaInicioAmistad = fechaInicioAmistad;
		this.seguidor = seguidor;
		this.bloqueado = bloqueado;
	}

	public Contacto(Integer idcontacto, ListaContacto listaContactos, Usuario usuarioByMyid,
			Usuario usuarioByIdusuario, TipoContacto tipoContacto, Date fechaInicioAmistad, char seguidor,
			char bloqueado) {
		this.idcontacto = idcontacto;
		this.listaContactos = listaContactos;
		this.usuarioByMyid = usuarioByMyid;
		this.usuarioByIdusuario = usuarioByIdusuario;
		this.tipoContacto = tipoContacto;
		this.fechaInicioAmistad = fechaInicioAmistad;
		this.seguidor = seguidor;
		this.bloqueado = bloqueado;
	}

	@Id
	@GenericGenerator(name="SQ_GENERATOR",strategy="sequence",parameters={@Parameter(name="sequence",value="SQ_CONTACTO")})
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SQ_GENERATOR")
	@Column(name = "IDCONTACTO", unique = true, nullable = false, precision = 22, scale = 0)
	public Integer getIdcontacto() {
		return this.idcontacto;
	}

	public void setIdcontacto(Integer idcontacto) {
		this.idcontacto = idcontacto;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDLISTA_CONTACTOS")
	public ListaContacto getListaContactos() {
		return this.listaContactos;
	}

	public void setListaContactos(ListaContacto listaContactos) {
		this.listaContactos = listaContactos;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MYID", nullable = false)
	public Usuario getUsuarioByMyid() {
		return this.usuarioByMyid;
	}

	public void setUsuarioByMyid(Usuario usuarioByMyid) {
		this.usuarioByMyid = usuarioByMyid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDUSUARIO", nullable = false)
	public Usuario getUsuarioByIdusuario() {
		return this.usuarioByIdusuario;
	}

	public void setUsuarioByIdusuario(Usuario usuarioByIdusuario) {
		this.usuarioByIdusuario = usuarioByIdusuario;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDTIPO_CONTACTO")
	public TipoContacto getTipoContacto() {
		return this.tipoContacto;
	}

	public void setTipoContacto(TipoContacto tipoContacto) {
		this.tipoContacto = tipoContacto;
	}

	@Column(name = "FECHA_INICIO_AMISTAD", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	public Date getFechaInicioAmistad() {
		return this.fechaInicioAmistad;
	}

	public void setFechaInicioAmistad(Date fechaInicioAmistad) {
		this.fechaInicioAmistad = fechaInicioAmistad;
	}

	@Column(name = "SEGUIDOR", nullable = false, length = 1)
	public char getSeguidor() {
		return this.seguidor;
	}

	public void setSeguidor(char seguidor) {
		this.seguidor = seguidor;
	}

	@Column(name = "BLOQUEADO", nullable = false, length = 1)
	public char getBloqueado() {
		return this.bloqueado;
	}

	public void setBloqueado(char bloqueado) {
		this.bloqueado = bloqueado;
	}

}
