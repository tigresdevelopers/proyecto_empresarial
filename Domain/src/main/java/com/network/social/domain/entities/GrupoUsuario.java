package com.network.social.domain.entities;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
/**
 * 
 * @author :Alexander Chavez Simbron
 * @date   :19/10/2015
 * @time   :17:25 P.M
 */
@Entity
@Table(name = "GRUPO_USUARIO")
public class GrupoUsuario extends BaseBean {
	private static final long serialVersionUID = 1L;

	private GrupoUsuarioId id;
	private Usuario usuario;
	private Grupo grupo;
	private char admin;
	private Date fechaRegistro;

	public GrupoUsuario() {
	}

	public GrupoUsuario(GrupoUsuarioId id, Usuario usuario, Grupo grupo, char admin) {
		this.id = id;
		this.usuario = usuario;
		this.grupo = grupo;
		this.admin = admin;
	}

	public GrupoUsuario(GrupoUsuarioId id, Usuario usuario, Grupo grupo, char admin, Date fechaRegistro) {
		this.id = id;
		this.usuario = usuario;
		this.grupo = grupo;
		this.admin = admin;
		this.fechaRegistro = fechaRegistro;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "idgrupo", column = @Column(name = "IDGRUPO", nullable = false, precision = 22, scale = 0) ),
			@AttributeOverride(name = "idusuario", column = @Column(name = "IDUSUARIO", nullable = false, precision = 22, scale = 0) ) })
	public GrupoUsuarioId getId() {
		return this.id;
	}

	public void setId(GrupoUsuarioId id) {
		this.id = id;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDUSUARIO", nullable = false, insertable = false, updatable = false)
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDGRUPO", nullable = false, insertable = false, updatable = false)
	public Grupo getGrupo() {
		return this.grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	@Column(name = "ADMIN", nullable = false, length = 1)
	public char getAdmin() {
		return this.admin;
	}

	public void setAdmin(char admin) {
		this.admin = admin;
	}

	@Column(name = "FECHA_REGISTRO")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

}
