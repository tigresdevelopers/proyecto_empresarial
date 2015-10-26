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
@Table(name = "ACTIVIDAD", uniqueConstraints = { @UniqueConstraint(columnNames = "IDCOMENTARIO"),
		@UniqueConstraint(columnNames = "IDPUBLICACION"), @UniqueConstraint(columnNames = "IDLIKE") })
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idactividad")
public class Actividad extends BaseBean {
	private static final long serialVersionUID = 1L;
	
	private Integer idactividad;
	private Like like;
	private Publicacion publicacion;
	private Comentario comentario;
	private String descripcion;
	private Integer idusuario;
	private Date fechaActividad;

	public Actividad() {
	}
	
	

	public Actividad(Integer idactividad) {
		super();
		this.idactividad = idactividad;
	}

	public Actividad(Integer idactividad, Integer idusuario) {
		this.idactividad = idactividad;
		this.idusuario = idusuario;
	}

	public Actividad(Integer idactividad, Like like, Publicacion publicacion, Comentario comentario,
			String descripcion, Integer idusuario, Date fechaActividad) {
		this.idactividad = idactividad;
		this.like = like;
		this.publicacion = publicacion;
		this.comentario = comentario;
		this.descripcion = descripcion;
		this.idusuario = idusuario;
		this.fechaActividad = fechaActividad;
	}

	@Id
	@GenericGenerator(name="SQ_GENERATOR",strategy="sequence",parameters={@Parameter(name="sequence",value="SQ_ACTIVIDAD")})
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SQ_GENERATOR")
	@Column(name = "IDACTIVIDAD", unique = true,precision = 22, scale = 0)
	public Integer getIdactividad() {
		return this.idactividad;
	}

	public void setIdactividad(Integer idactividad) {
		this.idactividad = idactividad;
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

	@Column(name = "DESCRIPCION", length = 50)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Column(name = "IDUSUARIO",precision = 22, scale = 0)
	public Integer getIdusuario() {
		return this.idusuario;
	}

	public void setIdusuario(Integer idusuario) {
		this.idusuario = idusuario;
	}

	@Column(name = "FECHA_ACTIVIDAD")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getFechaActividad() {
		return this.fechaActividad;
	}

	public void setFechaActividad(Date fechaActividad) {
		this.fechaActividad = fechaActividad;
	}

}
