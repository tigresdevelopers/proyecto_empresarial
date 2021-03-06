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
@Entity
@Table(name = "NOTIFICACIONES", uniqueConstraints = { @UniqueConstraint(columnNames = "IDCOMENTARIO"),
		@UniqueConstraint(columnNames = "IDPUBLICACION"), @UniqueConstraint(columnNames = "IDLIKE") })
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idnotificacion")
public class Notificacion extends BaseBean {
	private static final long serialVersionUID = 1L;

	private Integer idnotificacion;
	private Like like;
	private Publicacion publicacion;
	private Comentario comentario;
	private String leido;
	private String descripcion;

	public Notificacion() {
	}

	public Notificacion(Integer idnotificacion) {
		this.idnotificacion = idnotificacion;
	}

	public Notificacion(Integer idnotificacion, Like like, Publicacion publicacion, Comentario comentario,
			String leido, String descripcion) {
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

	@JsonIdentityReference(alwaysAsId=true)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDLIKE", unique = true)
	public Like getLike() {
		return this.like;
	}

	public void setLike(Like like) {
		this.like = like;
	}

	@JsonSetter
	public void setLike(Integer id) {
		this.like =new Like();
		this.like.setIdlike(id);
	}
	
	@JsonIdentityReference(alwaysAsId=true)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDPUBLICACION", unique = true)
	public Publicacion getPublicacion() {
		return this.publicacion;
	}

	public void setPublicacion(Publicacion publicacion) {
		this.publicacion = publicacion;
	}

	@JsonSetter
	public void setPublicacion(Integer id) {
		this.publicacion = new Publicacion();
		this.publicacion.setIdpublicacion(id);
	}
	
	@JsonIdentityReference(alwaysAsId=true)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDCOMENTARIO", unique = true)
	public Comentario getComentario() {
		return this.comentario;
	}
	
	public void setComentario(Comentario comentario) {
		this.comentario = comentario;
	}

	@JsonSetter
	public void setComentario(Integer id) {
		this.comentario = new Comentario();
		this.comentario.setIdcomentario(id);
	}
	
	@Column(name = "LEIDO", length = 1)
	public String getLeido() {
		return this.leido;
	}

	public void setLeido(String leido) {
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
