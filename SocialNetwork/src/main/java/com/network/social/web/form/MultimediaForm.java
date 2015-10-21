package com.network.social.web.form;

import java.util.HashSet;
import java.util.Set;
/**
 * 
 * @author :Alexander Chavez Simbron
 * @date   :19/10/2015
 * @time   :17:25 P.M
 */
public class MultimediaForm extends BaseForm {
	private static final long serialVersionUID = 1L;

	private Integer idmultimedia;
	private PublicacionForm publicacion;
	private AlbumForm album;
	private ListaContactoForm listaContactos;
	private TipoContactoForm tipoContacto;
	private String nombreArchivo;
	private String descripcion;
	private Integer tipo;
	private Integer likes;
	private Set<ComentarioForm> comentarios = new HashSet<ComentarioForm>();
	private Set<LikeForm> likes_1 = new HashSet<LikeForm>();
	private Set<EtiquetaForm> etiquetas = new HashSet<EtiquetaForm>();

	public MultimediaForm() {
	}
	
	

	public MultimediaForm(Integer idmultimedia) {
		super();
		this.idmultimedia = idmultimedia;
	}

	public MultimediaForm(Integer idmultimedia, PublicacionForm publicacion,
			AlbumForm album, ListaContactoForm listaContactos,
			TipoContactoForm tipoContacto, String nombreArchivo,
			String descripcion, Integer tipo, Integer likes,
			Set<ComentarioForm> comentarios, Set<LikeForm> likes_1,
			Set<EtiquetaForm> etiquetas) {
		super();
		this.idmultimedia = idmultimedia;
		this.publicacion = publicacion;
		this.album = album;
		this.listaContactos = listaContactos;
		this.tipoContacto = tipoContacto;
		this.nombreArchivo = nombreArchivo;
		this.descripcion = descripcion;
		this.tipo = tipo;
		this.likes = likes;
		this.comentarios = comentarios;
		this.likes_1 = likes_1;
		this.etiquetas = etiquetas;
	}



	public Integer getIdmultimedia() {
		return idmultimedia;
	}

	public void setIdmultimedia(Integer idmultimedia) {
		this.idmultimedia = idmultimedia;
	}

	public PublicacionForm getPublicacion() {
		return publicacion;
	}

	public void setPublicacion(PublicacionForm publicacion) {
		this.publicacion = publicacion;
	}

	public AlbumForm getAlbum() {
		return album;
	}

	public void setAlbum(AlbumForm album) {
		this.album = album;
	}

	public ListaContactoForm getListaContactos() {
		return listaContactos;
	}

	public void setListaContactos(ListaContactoForm listaContactos) {
		this.listaContactos = listaContactos;
	}

	public TipoContactoForm getTipoContacto() {
		return tipoContacto;
	}

	public void setTipoContacto(TipoContactoForm tipoContacto) {
		this.tipoContacto = tipoContacto;
	}

	public String getNombreArchivo() {
		return nombreArchivo;
	}

	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public Integer getLikes() {
		return likes;
	}

	public void setLikes(Integer likes) {
		this.likes = likes;
	}

	public Set<ComentarioForm> getComentarios() {
		return comentarios;
	}

	public void setComentarios(Set<ComentarioForm> comentarios) {
		this.comentarios = comentarios;
	}

	public Set<LikeForm> getLikes_1() {
		return likes_1;
	}

	public void setLikes_1(Set<LikeForm> likes_1) {
		this.likes_1 = likes_1;
	}

	public Set<EtiquetaForm> getEtiquetas() {
		return etiquetas;
	}

	public void setEtiquetas(Set<EtiquetaForm> etiquetas) {
		this.etiquetas = etiquetas;
	}

	
}
