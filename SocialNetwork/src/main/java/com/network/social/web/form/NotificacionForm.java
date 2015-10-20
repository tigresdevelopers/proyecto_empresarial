package com.network.social.web.form;
/**
 * 
 * @author :Alexander Chavez Simbron
 * @date   :19/10/2015
 * @time   :17:25 P.M
 */
public class NotificacionForm extends BaseForm {
	private static final long serialVersionUID = 1L;

	private Integer idnotificacion;
	private LikeForm like;
	private PublicacionForm publicacion;
	private ComentarioForm comentario;
	private Character leido;
	private String descripcion;

	public NotificacionForm() {
	}

	public Integer getIdnotificacion() {
		return idnotificacion;
	}

	public void setIdnotificacion(Integer idnotificacion) {
		this.idnotificacion = idnotificacion;
	}

	public LikeForm getLike() {
		return like;
	}

	public void setLike(LikeForm like) {
		this.like = like;
	}

	public PublicacionForm getPublicacion() {
		return publicacion;
	}

	public void setPublicacion(PublicacionForm publicacion) {
		this.publicacion = publicacion;
	}

	public ComentarioForm getComentario() {
		return comentario;
	}

	public void setComentario(ComentarioForm comentario) {
		this.comentario = comentario;
	}

	public Character getLeido() {
		return leido;
	}

	public void setLeido(Character leido) {
		this.leido = leido;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	
}
