package com.network.social.domain.util.form;

public class EtiquetaForm extends BaseForm {
	private static final long serialVersionUID = 1L;

	private Integer idetiqueta;
	private MultimediaForm multimedia;
	private PublicacionForm publicacion;
	private ComentarioForm comentario;
	private UsuarioForm usuario;

	public EtiquetaForm() {
	}

	public Integer getIdetiqueta() {
		return idetiqueta;
	}

	public void setIdetiqueta(Integer idetiqueta) {
		this.idetiqueta = idetiqueta;
	}

	public MultimediaForm getMultimedia() {
		return multimedia;
	}

	public void setMultimedia(MultimediaForm multimedia) {
		this.multimedia = multimedia;
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

	public UsuarioForm getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioForm usuario) {
		this.usuario = usuario;
	}

	
}
