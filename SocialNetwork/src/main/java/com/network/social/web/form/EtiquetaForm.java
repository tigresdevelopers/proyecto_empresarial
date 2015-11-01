package com.network.social.web.form;

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
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class,property="idetiqueta")
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
			this.multimedia = new MultimediaForm(id);
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
			this.publicacion =new PublicacionForm(id);
		}
	}

	@JsonIdentityReference(alwaysAsId=true)
	public ComentarioForm getComentario() {
		return comentario;
	}

	public void setComentario(ComentarioForm comentario) {
		this.comentario = comentario;
	}
	
	@JsonSetter
	public void setComentario(Integer id) {
		if (id!=null) {
			this.comentario = new ComentarioForm(id);
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
			this.usuario = new UsuarioForm(id);
		}
	}
}
