package com.network.social.domain.util.form;


import java.sql.Clob;
import java.util.HashSet;
import java.util.Set;

public class AlbumForm extends BaseForm {
	private static final long serialVersionUID = 1L;

	private Integer idalbum;
	private PublicacionForm publicacion;
	private UsuarioForm usuario;
	private GrupoForm grupo;
	private String nombre;
	private Clob descripcion;
	private Integer likes;
	private Set<MultimediaForm> multimedias = new HashSet<MultimediaForm>();
	private Set<LikeForm> likes_1 = new HashSet<LikeForm>();
	private Set<ComentarioForm> comentarios = new HashSet<ComentarioForm>();

	public AlbumForm() {
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

	public Clob getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(Clob descripcion) {
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
