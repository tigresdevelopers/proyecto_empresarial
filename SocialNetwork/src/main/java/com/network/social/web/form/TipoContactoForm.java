package com.network.social.web.form;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
/**
 * 
 * @author :Alexander Chavez Simbron
 * @date   :19/10/2015
 * @time   :17:25 P.M
 */
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class,property="idtipoContacto")
public class TipoContactoForm extends BaseForm {
	private static final long serialVersionUID = 1L;

	private Integer idtipoContacto;
	private String nombre;
	private Set<MultimediaForm> multimedias = new HashSet<MultimediaForm>();
	private Set<ContactoForm> contactos = new HashSet<ContactoForm>();
	private Set<PublicacionForm> publicacions = new HashSet<PublicacionForm>();

	public TipoContactoForm() {
	}

	public TipoContactoForm(Integer idtipoContacto) {
		super();
		this.idtipoContacto = idtipoContacto;
	}

	public TipoContactoForm(Integer idtipoContacto, String nombre,
			Set<MultimediaForm> multimedias, Set<ContactoForm> contactos,
			Set<PublicacionForm> publicacions) {
		super();
		this.idtipoContacto = idtipoContacto;
		this.nombre = nombre;
		this.multimedias = multimedias;
		this.contactos = contactos;
		this.publicacions = publicacions;
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
