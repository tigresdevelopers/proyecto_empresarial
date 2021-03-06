package com.network.social.web.form;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
/**
 * 
 * @author :Alexander Chavez Simbron
 * @date   :19/10/2015
 * @time   :17:25 P.M
 */
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class,property="idcomentario")
@JsonIgnoreProperties({ "etiquetas","notificacioneses","likes_1","actividads","comentarios" })
public class ComentarioForm extends BaseForm {
	private static final long serialVersionUID = 1L;

	private Integer idcomentario;
	private MultimediaForm multimedia;
	private PublicacionForm publicacion;
	private AlbumForm album;
	private UsuarioForm usuario;
	private ComentarioForm comentarioParent;
	private String contenido;
	private Date fechaComentario;
	private Integer likes;
	private Set<EtiquetaForm> etiquetas = new HashSet<EtiquetaForm>();
	private Set<NotificacionForm> notificacioneses = new HashSet<NotificacionForm>();
	private Set<LikeForm> likes_1 = new HashSet<LikeForm>();
	private Set<ActividadForm> actividads = new HashSet<ActividadForm>();
	private List<ComentarioForm> comentarios;
	
	
	public ComentarioForm() {
	}

	public ComentarioForm(Integer idcomentario) {
		super();
		this.idcomentario = idcomentario;
	}
	
	public ComentarioForm(Integer idcomentario, UsuarioForm usuario) {
		this.idcomentario = idcomentario;
		this.usuario = usuario;
	}

	public ComentarioForm(Integer idcomentario, MultimediaForm multimedia, PublicacionForm publicacion, AlbumForm album,
			UsuarioForm usuario, String contenido, Date fechaComentario, Integer likes, Set<EtiquetaForm> etiquetas,
			Set<NotificacionForm> notificacioneses, Set<LikeForm> likes_1, Set<ActividadForm> actividads) {
		this.idcomentario = idcomentario;
		this.multimedia = multimedia;
		this.publicacion = publicacion;
		this.album = album;
		this.usuario = usuario;
		this.contenido = contenido;
		this.fechaComentario = fechaComentario;
		this.likes = likes;
		this.etiquetas = etiquetas;
		this.notificacioneses = notificacioneses;
		this.likes_1 = likes_1;
		this.actividads = actividads;
	}

	public Integer getIdcomentario() {
		return idcomentario;
	}

	public void setIdcomentario(Integer idcomentario) {
		this.idcomentario = idcomentario;
	}

	@JsonIdentityReference(alwaysAsId=true)
	public MultimediaForm getMultimedia() {
		return multimedia;
	}

	public void setMultimedia(MultimediaForm multimedia) {
		this.multimedia = multimedia;
	}
	
	@JsonSetter
	public void setMultimedia(Integer id) {
		if (id!=null) {
			this.multimedia =new MultimediaForm(id);
		}
	}
	
	@JsonIdentityReference(alwaysAsId=true)
	public PublicacionForm getPublicacion() {
		return publicacion;
	}

	public void setPublicacion(PublicacionForm publicacion) {
		this.publicacion = publicacion;
	}
	
	@JsonSetter
	public void setPublicacion(Integer id) {
		if (id!=null) {
			this.publicacion = new PublicacionForm(id);
		}
	}

	@JsonIdentityReference(alwaysAsId=true)
	public AlbumForm getAlbum() {
		return album;
	}

	public void setAlbum(AlbumForm album) {
		this.album = album;
	}

	@JsonSetter
	public void setAlbum(Integer id) {
		if (id!=null) {
			this.album =new AlbumForm(id);
		}
	}
	
	@JsonIdentityReference(alwaysAsId=true)
	public UsuarioForm getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioForm usuario) {
		this.usuario = usuario;
	}

	@JsonSetter
	public void setUsuario(Integer id) {
		if (id!=null) {
			this.usuario=new UsuarioForm(id);
		}
	}
	
	@JsonIdentityReference(alwaysAsId=true)
	public ComentarioForm getComentarioParent() {
		return comentarioParent;
	}

	public void setComentarioParent(ComentarioForm comentarioParent) {
		this.comentarioParent = comentarioParent;
	}
	
	@JsonSetter
	public void setComentarioParent(Integer id) {
		if (id!=null) {
			this.comentarioParent = new ComentarioForm(id);
		}
	}
	
	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public Date getFechaComentario() {
		return fechaComentario;
	}

	public void setFechaComentario(Date fechaComentario) {
		this.fechaComentario = fechaComentario;
	}

	public Integer getLikes() {
		return likes;
	}

	public void setLikes(Integer likes) {
		this.likes = likes;
	}

	public Set<EtiquetaForm> getEtiquetas() {
		return etiquetas;
	}

	public void setEtiquetas(Set<EtiquetaForm> etiquetas) {
		this.etiquetas = etiquetas;
	}

	public Set<NotificacionForm> getNotificacioneses() {
		return notificacioneses;
	}

	public void setNotificacioneses(Set<NotificacionForm> notificacioneses) {
		this.notificacioneses = notificacioneses;
	}

	public Set<LikeForm> getLikes_1() {
		return likes_1;
	}

	public void setLikes_1(Set<LikeForm> likes_1) {
		this.likes_1 = likes_1;
	}

	public Set<ActividadForm> getActividads() {
		return actividads;
	}

	public void setActividads(Set<ActividadForm> actividads) {
		this.actividads = actividads;
	}

	public List<ComentarioForm> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<ComentarioForm> comentarios) {
		this.comentarios = comentarios;
	}
	
	

}
