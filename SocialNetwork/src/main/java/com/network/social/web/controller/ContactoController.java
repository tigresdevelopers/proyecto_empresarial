package com.network.social.web.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import com.network.social.web.config.PropiedadAdmin;
import com.network.social.web.config.UtilEnum.ESTADO_OPERACION;
import com.network.social.web.form.ContactoForm;
import com.network.social.web.jsf.util.Faces;
import com.network.social.web.spring.util.AdminConfigPropiedad.URI;
import com.network.social.web.spring.util.BResult;

/**
 * @author :Alexander Chavez Simbron
 * @date   :27/10/2015
 * @time   :10:21:48
 */
@ManagedBean(name="contacto")
public class ContactoController implements Serializable {
	private static final long serialVersionUID = 1L;

	Logger LOGGER=LoggerFactory.getLogger(ContactoController.class);

	@ManagedProperty(value="#{restTemplate}")
	private RestTemplate restTemplate;
	
	@ManagedProperty(value="#{propiedadAdmin}")
	private PropiedadAdmin propiedadAdmin;

	private ContactoForm contacto;
	
	private List<ContactoForm> contactos;
	
	@PostConstruct
	public void init(){
		this.contacto=new ContactoForm();
	}
	
	public void create(){
		LOGGER.info("## Registrar Contacto");
		
		String url=propiedadAdmin.getURIServiceAdmin(URI.SERVICE_CONTACTO_CREATE);
	    BResult result=restTemplate.postForObject(url, new HttpEntity<ContactoForm>(this.contacto),BResult.class);
	    
		if (result.getEstado()==ESTADO_OPERACION.EXITO.getCodigo()) {
			LOGGER.info("## usuario actualizado");
			Faces.addMessage("Exito", "Contacto registrado", FacesMessage.SEVERITY_INFO);
		}else{
			LOGGER.info("## error al actualizar");
			Faces.addMessage("Error", "Error al registrar", FacesMessage.SEVERITY_ERROR);
		}
	}
	
	public void update(){
		LOGGER.info("## Actualizar Contacto");
		
		String url=propiedadAdmin.getURIServiceAdmin(URI.SERVICE_CONTACTO_UPDATE);
	    BResult result=restTemplate.postForObject(url, new HttpEntity<ContactoForm>(this.contacto),BResult.class);
	    
		if (result.getEstado()==ESTADO_OPERACION.EXITO.getCodigo()) {
			LOGGER.info("## Contacto actualizado");
			Faces.addMessage("Exito", "Contacto Actualizado", FacesMessage.SEVERITY_INFO);
		}else{
			LOGGER.info("## error al actualizar");
			Faces.addMessage("Error", "Error al Actualizar", FacesMessage.SEVERITY_ERROR);
		}
	}
	
	public void delete(){
		LOGGER.info("## Eliminar Contacto");
		
		String url=propiedadAdmin.getURIServiceAdmin(URI.SERVICE_CONTACTO_DELETE);
	    BResult result=restTemplate.postForObject(url, new HttpEntity<ContactoForm>(this.contacto),BResult.class);
	    
		if (result.getEstado()==ESTADO_OPERACION.EXITO.getCodigo()) {
			LOGGER.info("## Contacto actualizado");
			Faces.addMessage("Exito", "Contacto Eliminado", FacesMessage.SEVERITY_INFO);
		}else{
			LOGGER.info("## error al actualizar");
			Faces.addMessage("Error", "Error al Eliminar", FacesMessage.SEVERITY_ERROR);
		}
	}
	
	
	public RestTemplate getRestTemplate() {
		return restTemplate;
	}
	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	public PropiedadAdmin getPropiedadAdmin() {
		return propiedadAdmin;
	}
	public void setPropiedadAdmin(PropiedadAdmin propiedadAdmin) {
		this.propiedadAdmin = propiedadAdmin;
	}
	public ContactoForm getContacto() {
		return contacto;
	}
	public void setContacto(ContactoForm contacto) {
		this.contacto = contacto;
	}
	public List<ContactoForm> getContactos() {
		return contactos;
	}
	public void setContactos(List<ContactoForm> contactos) {
		this.contactos = contactos;
	}
	
	
}
