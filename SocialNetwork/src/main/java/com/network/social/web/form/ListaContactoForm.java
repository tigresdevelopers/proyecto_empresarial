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
public class ListaContactoForm extends BaseForm {
	private static final long serialVersionUID = 1L;

	private Integer idlistaContactos;
	private UsuarioForm usuario;
	private String nombre;
	private Date fechaCreacion;
	private Set<MultimediaForm> multimedias = new HashSet<MultimediaForm>();
	private Set<ContactoForm> contactos = new HashSet<ContactoForm>();
	private Set<PublicacionForm> publicacions = new HashSet<PublicacionForm>();

	public ListaContactoForm() {
	}

	public ListaContactoForm(Integer idlistaContactos) {
		super();
		this.idlistaContactos = idlistaContactos;
	}

	public ListaContactoForm(Integer idlistaContactos, UsuarioForm usuario,
			String nombre, Date fechaCreacion, Set<MultimediaForm> multimedias,
			Set<ContactoForm> contactos, Set<PublicacionForm> publicacions) {
		super();
		this.idlistaContactos = idlistaContactos;
		this.usuario = usuario;
		this.nombre = nombre;
		this.fechaCreacion = fechaCreacion;
		this.multimedias = multimedias;
		this.contactos = contactos;
		this.publicacions = publicacions;
	}

	public Integer getIdlistaContactos() {
		return idlistaContactos;
	}

	public void setIdlistaContactos(Integer idlistaContactos) {
		this.idlistaContactos = idlistaContactos;
	}

	public UsuarioForm getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioForm usuario) {
		this.usuario = usuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Set<MultimediaForm> getMultimedias() {
		return multimedias;
	}

	public void setMultimedias(Set<MultimediaForm> multimedias) {
		this.multimedias = multimedias;
	}

	public Set<ContactoForm> getContactos() {
		return contactos;
	}

	public void setContactos(Set<ContactoForm> contactos) {
		this.contactos = contactos;
	}

	public Set<PublicacionForm> getPublicacions() {
		return publicacions;
	}

	public void setPublicacions(Set<PublicacionForm> publicacions) {
		this.publicacions = publicacions;
	}

	

}
