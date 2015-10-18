package com.network.social.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "ETIQUETA")
public class Etiqueta extends BaseBean {
	private static final long serialVersionUID = 1L;

	private Integer idetiqueta;
	private Multimedia multimedia;
	private Publicacion publicacion;
	private Comentario comentario;
	private Usuario usuario;

	public Etiqueta() {
	}

	public Etiqueta(Integer idetiqueta, Usuario usuario) {
		this.idetiqueta = idetiqueta;
		this.usuario = usuario;
	}

	public Etiqueta(Integer idetiqueta, Multimedia multimedia, Publicacion publicacion, Comentario comentario,
			Usuario usuario) {
		this.idetiqueta = idetiqueta;
		this.multimedia = multimedia;
		this.publicacion = publicacion;
		this.comentario = comentario;
		this.usuario = usuario;
	}

	@Id

	@Column(name = "IDETIQUETA", unique = true, nullable = false, precision = 22, scale = 0)
	public Integer getIdetiqueta() {
		return this.idetiqueta;
	}

	public void setIdetiqueta(Integer idetiqueta) {
		this.idetiqueta = idetiqueta;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDMULTIMEDIA")
	public Multimedia getMultimedia() {
		return this.multimedia;
	}

	public void setMultimedia(Multimedia multimedia) {
		this.multimedia = multimedia;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDPUBLICACION")
	public Publicacion getPublicacion() {
		return this.publicacion;
	}

	public void setPublicacion(Publicacion publicacion) {
		this.publicacion = publicacion;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDCOMENTARIO")
	public Comentario getComentario() {
		return this.comentario;
	}

	public void setComentario(Comentario comentario) {
		this.comentario = comentario;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDUSUARIO", nullable = false)
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
