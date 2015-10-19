package com.network.social.domain.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/**
 * 
 * @author :Alexander Chavez Simbron
 * @date   :19/10/2015
 * @time   :17:25 P.M
 */
@Entity
@Table(name = "NOTIFICACIONES", uniqueConstraints = { @UniqueConstraint(columnNames = "IDCOMENTARIO"),
		@UniqueConstraint(columnNames = "IDPUBLICACION"), @UniqueConstraint(columnNames = "IDLIKE") })
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Notificacion extends BaseBean {
	private static final long serialVersionUID = 1L;

	private Integer idnotificacion;
	private Like like;
	private Publicacion publicacion;
	private Comentario comentario;
	private Character leido;
	private String descripcion;

	public Notificacion() {
	}

	public Notificacion(Integer idnotificacion) {
		this.idnotificacion = idnotificacion;
	}

	public Notificacion(Integer idnotificacion, Like like, Publicacion publicacion, Comentario comentario,
			Character leido, String descripcion) {
		this.idnotificacion = idnotificacion;
		this.like = like;
		this.publicacion = publicacion;
		this.comentario = comentario;
		this.leido = leido;
		this.descripcion = descripcion;
	}

	@Id
	@GenericGenerator(name="SQ_GENERATOR",strategy="sequence",parameters={@Parameter(name="sequence",value="SQ_NOTIFICIONES")})
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SQ_GENERATOR")
	@Column(name = "IDNOTIFICACION", unique = true, nullable = false, precision = 22, scale = 0)
	public Integer getIdnotificacion() {
		return this.idnotificacion;
	}

	public void setIdnotificacion(Integer idnotificacion) {
		this.idnotificacion = idnotificacion;
	}

	@JsonBackReference
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDLIKE", unique = true)
	public Like getLike() {
		return this.like;
	}

	public void setLike(Like like) {
		this.like = like;
	}

	@JsonBackReference
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDPUBLICACION", unique = true)
	public Publicacion getPublicacion() {
		return this.publicacion;
	}

	public void setPublicacion(Publicacion publicacion) {
		this.publicacion = publicacion;
	}

	@JsonBackReference
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDCOMENTARIO", unique = true)
	public Comentario getComentario() {
		return this.comentario;
	}

	public void setComentario(Comentario comentario) {
		this.comentario = comentario;
	}

	@Column(name = "LEIDO", length = 1)
	public Character getLeido() {
		return this.leido;
	}

	public void setLeido(Character leido) {
		this.leido = leido;
	}

	@Column(name = "DESCRIPCION", length = 300)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
