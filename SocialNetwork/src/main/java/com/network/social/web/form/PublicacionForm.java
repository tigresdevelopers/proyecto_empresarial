package com.network.social.web.form;

import java.util.HashSet;
import java.util.Set;
/**
 * 
 * @author :Alexander Chavez Simbron
 * @date   :19/10/2015
 * @time   :17:25 P.M
 */
public class PublicacionForm extends BaseForm {
	private static final long serialVersionUID = 1L;

	private Integer idpublicacion;
	private ListaContactoForm listaContactos;
	private UsuarioForm usuarioByIdusuarioReceiver;
	private UsuarioForm usuarioByIdusuario;
	private TipoContactoForm tipoContacto;
	private GrupoForm grupo;
	private String contenido;
	private String nombreArchivo;
	private Integer likes;
	private Set<EtiquetaForm> etiquetas = new HashSet<EtiquetaForm>();
	private Set<AlbumForm> albums = new HashSet<AlbumForm>();
	private Set<ActividadForm> actividads = new HashSet<ActividadForm>();
	private Set<MultimediaForm> multimedias = new HashSet<MultimediaForm>();
	private Set<LikeForm> likes_1 = new HashSet<LikeForm>();
	private Set<ComentarioForm> comentarios = new HashSet<ComentarioForm>();
	private Set<NotificacionForm> notificacioneses = new HashSet<NotificacionForm>();

	public PublicacionForm() {
	}

	
	
	public PublicacionForm(Integer idpublicacion) {
		super();
		this.idpublicacion = idpublicacion;
	}



	public PublicacionForm(Integer idpublicacion,
			ListaContactoForm listaContactos,
			UsuarioForm usuarioByIdusuarioReceiver,
			UsuarioForm usuarioByIdusuario, TipoContactoForm tipoContacto,
			GrupoForm grupo, String contenido, String nombreArchivo,
			Integer likes, Set<EtiquetaForm> etiquetas, Set<AlbumForm> albums,
			Set<ActividadForm> actividads, Set<MultimediaForm> multimedias,
			Set<LikeForm> likes_1, Set<ComentarioForm> comentarios,
			Set<NotificacionForm> notificacioneses) {
		super();
		this.idpublicacion = idpublicacion;
		this.listaContactos = listaContactos;
		this.usuarioByIdusuarioReceiver = usuarioByIdusuarioReceiver;
		this.usuarioByIdusuario = usuarioByIdusuario;
		this.tipoContacto = tipoContacto;
		this.grupo = grupo;
		this.contenido = contenido;
		this.nombreArchivo = nombreArchivo;
		this.likes = likes;
		this.etiquetas = etiquetas;
		this.albums = albums;
		this.actividads = actividads;
		this.multimedias = multimedias;
		this.likes_1 = likes_1;
		this.comentarios = comentarios;
		this.notificacioneses = notificacioneses;
	}



	public Integer getIdpublicacion() {
		return idpublicacion;
	}

	public void setIdpublicacion(Integer idpublicacion) {
		this.idpublicacion = idpublicacion;
	}

	public ListaContactoForm getListaContactos() {
		return listaContactos;
	}

	public void setListaContactos(ListaContactoForm listaContactos) {
		this.listaContactos = listaContactos;
	}

	public UsuarioForm getUsuarioByIdusuarioReceiver() {
		return usuarioByIdusuarioReceiver;
	}

	public void setUsuarioByIdusuarioReceiver(UsuarioForm usuarioByIdusuarioReceiver) {
		this.usuarioByIdusuarioReceiver = usuarioByIdusuarioReceiver;
	}

	public UsuarioForm getUsuarioByIdusuario() {
		return usuarioByIdusuario;
	}

	public void setUsuarioByIdusuario(UsuarioForm usuarioByIdusuario) {
		this.usuarioByIdusuario = usuarioByIdusuario;
	}

	public TipoContactoForm getTipoContacto() {
		return tipoContacto;
	}

	public void setTipoContacto(TipoContactoForm tipoContacto) {
		this.tipoContacto = tipoContacto;
	}

	public GrupoForm getGrupo() {
		return grupo;
	}

	public void setGrupo(GrupoForm grupo) {
		this.grupo = grupo;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public String getNombreArchivo() {
		return nombreArchivo;
	}

	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
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

	public Set<AlbumForm> getAlbums() {
		return albums;
	}

	public void setAlbums(Set<AlbumForm> albums) {
		this.albums = albums;
	}

	public Set<ActividadForm> getActividads() {
		return actividads;
	}

	public void setActividads(Set<ActividadForm> actividads) {
		this.actividads = actividads;
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

	public Set<NotificacionForm> getNotificacioneses() {
		return notificacioneses;
	}

	public void setNotificacioneses(Set<NotificacionForm> notificacioneses) {
		this.notificacioneses = notificacioneses;
	}

	
}
