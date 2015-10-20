package com.network.social.web.form;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
/**
 * 
 * @author :Alexander Chavez Simbron
 * @date   :19/10/2015
 * @time   :17:25 P.M
 */

public class GrupoForm extends BaseForm {
	private static final long serialVersionUID = 1L;

	private Integer idgrupo;
	private String nombre;
	private String descripcion;
	private Date fechaCreacion;
	private Set<AlbumForm> albums = new HashSet<AlbumForm>();
	private Set<PublicacionForm> publicacions = new HashSet<PublicacionForm>();
	private Set<GrupoUsuarioForm> grupoUsuarios = new HashSet<GrupoUsuarioForm>();

	public GrupoForm() {
	}

	public Integer getIdgrupo() {
		return idgrupo;
	}

	public void setIdgrupo(Integer idgrupo) {
		this.idgrupo = idgrupo;
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

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Set<AlbumForm> getAlbums() {
		return albums;
	}

	public void setAlbums(Set<AlbumForm> albums) {
		this.albums = albums;
	}

	public Set<PublicacionForm> getPublicacions() {
		return publicacions;
	}

	public void setPublicacions(Set<PublicacionForm> publicacions) {
		this.publicacions = publicacions;
	}

	public Set<GrupoUsuarioForm> getGrupoUsuarios() {
		return grupoUsuarios;
	}

	public void setGrupoUsuarios(Set<GrupoUsuarioForm> grupoUsuarios) {
		this.grupoUsuarios = grupoUsuarios;
	}

	
}
