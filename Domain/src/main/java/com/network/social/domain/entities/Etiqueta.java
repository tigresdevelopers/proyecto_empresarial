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

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
/**
 * 
 * @author :Alexander Chavez Simbron
 * @date   :19/10/2015
 * @time   :17:25 P.M
 */
@Entity
@Table(name = "ETIQUETA")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idetiqueta")
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
	@GenericGenerator(name="SQ_GENERATOR",strategy="sequence",parameters={@Parameter(name="sequence",value="SQ_ETIQUETA")})
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SQ_GENERATOR")
	@Column(name = "IDETIQUETA", unique = true, nullable = false, precision = 22, scale = 0)
	public Integer getIdetiqueta() {
		return this.idetiqueta;
	}

	public void setIdetiqueta(Integer idetiqueta) {
		this.idetiqueta = idetiqueta;
	}

	@JsonIdentityReference(alwaysAsId=true)
	@JsonBackReference(value="multimedia-etiqueta")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDMULTIMEDIA")
	public Multimedia getMultimedia() {
		return this.multimedia;
	}

	public void setMultimedia(Multimedia multimedia) {
		this.multimedia = multimedia;
	}

	@JsonSetter
	public void setMultimedia(Integer id) {
		this.multimedia = new Multimedia();
		this.multimedia.setIdmultimedia(id);
	}
	
	@JsonIdentityReference(alwaysAsId=true)
	@JsonBackReference(value="publicacion-etiqueta")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDPUBLICACION")
	public Publicacion getPublicacion() {
		return this.publicacion;
	}

	public void setPublicacion(Publicacion publicacion) {
		this.publicacion = publicacion;
	}

	@JsonSetter
	public void setPublicacion(Integer id) {
		this.publicacion =new Publicacion();
		this.publicacion.setIdpublicacion(id);
	}
	
	@JsonIdentityReference(alwaysAsId=true)
	@JsonBackReference(value="comentario-etiqueta")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDCOMENTARIO")
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
	
//	@JsonIdentityReference(alwaysAsId=true)
	@JsonManagedReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDUSUARIO", nullable = false)
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
//	@JsonSetter
//	public void setUsuario(Integer id) {
//		this.usuario =new Usuario();
//		this.usuario.setIdusuario(id);
//	}
}
