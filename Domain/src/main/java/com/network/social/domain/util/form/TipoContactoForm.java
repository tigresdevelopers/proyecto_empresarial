package com.network.social.domain.util.form;

import java.util.HashSet;
import java.util.Set;
/**
 * 
 * @author Pantera
 *
 */

public class TipoContactoForm extends BaseForm {
	private static final long serialVersionUID = 1L;

	private Integer idtipoContacto;
	private String nombre;
	private Set<MultimediaForm> multimedias = new HashSet<MultimediaForm>();
	private Set<ContactoForm> contactos = new HashSet<ContactoForm>();
	private Set<PublicacionForm> publicacions = new HashSet<PublicacionForm>();

	public TipoContactoForm() {
	}

	public Integer getIdtipoContacto() {
		return idtipoContacto;
	}

	public void setIdtipoContacto(Integer idtipoContacto) {
		this.idtipoContacto = idtipoContacto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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
