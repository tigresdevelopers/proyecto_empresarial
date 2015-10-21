package com.network.social.web.form;

import java.util.HashSet;
import java.util.Set;
/**
 * 
 * @author :Alexander Chavez Simbron
 * @date   :19/10/2015
 * @time   :17:25 P.M
 */
public class AlbumForm extends BaseForm {
	private static final long serialVersionUID = 1L;

	private Integer idalbum;
	private PublicacionForm publicacion;
	private UsuarioForm usuario;
	private GrupoForm grupo;
	private String nombre;
	private String descripcion;
	private Integer likes;
	private Set<MultimediaForm> multimedias = new HashSet<MultimediaForm>();
	private Set<LikeForm> likes_1 = new HashSet<LikeForm>();
	private Set<ComentarioForm> comentarios = new HashSet<ComentarioForm>();

	public AlbumForm() {
	}

	
	public AlbumForm(Integer idalbum) {
		super();
		this.idalbum = idalbum;
	}


	public AlbumForm(Integer idalbum, PublicacionForm publicacion,
			UsuarioForm usuario, GrupoForm grupo, String nombre,
			String descripcion, Integer likes, Set<MultimediaForm> multimedias,
			Set<LikeForm> likes_1, Set<ComentarioForm> comentarios) {
		super();
		this.idalbum = idalbum;
		this.publicacion = publicacion;
		this.usuario = usuario;
		this.grupo = grupo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.likes = likes;
		this.multimedias = multimedias;
		this.likes_1 = likes_1;
		this.comentarios = comentarios;
	}


	public Integer getIdalbum() {
		return idalbum;
	}

	public void setIdalbum(Integer idalbum) {
		this.idalbum = idalbum;
	}

	public PublicacionForm getPublicacion() {
		return publicacion;
	}

	public void setPublicacion(PublicacionForm publicacion) {
		this.publicacion = publicacion;
	}

	public UsuarioForm getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioForm usuario) {
		this.usuario = usuario;
	}

	public GrupoForm getGrupo() {
		return grupo;
	}

	public void setGrupo(GrupoForm grupo) {
		this.grupo = grupo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getLikes() {
		return likes;
	}

	public void setLikes(Integer likes) {
		this.likes = likes;
	}

	public Set<MultimediaForm> getMultimedias() {
		return multimedias;
	}

	public void setMultimedias(Set<MultimediaForm> multimedias) {
		this.multimedias = multimedias;
	}

	public Set<LikeForm> getLikes_1() {
		return likes_1;
	}

	public void setLikes_1(Set<LikeForm> likes_1) {
		this.likes_1 = likes_1;
	}

	public Set<ComentarioForm> getComentarios() {
		return comentarios;
	}

	public void setComentarios(Set<ComentarioForm> comentarios) {
		this.comentarios = comentarios;
	}
}
