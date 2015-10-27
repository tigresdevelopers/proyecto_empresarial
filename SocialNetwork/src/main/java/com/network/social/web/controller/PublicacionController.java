package com.network.social.web.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import com.network.social.web.config.PropiedadAdmin;
import com.network.social.web.config.UtilEnum.ESTADO_OPERACION;
import com.network.social.web.form.PublicacionForm;
import com.network.social.web.jsf.util.Faces;
import com.network.social.web.spring.util.AdminConfigPropiedad.URI;
import com.network.social.web.spring.util.BResult;

/**
 * @author :Alexander Chavez Simbron
 * @date   :27/10/2015
 * @time   :11:42:03
 */
public class PublicacionController implements Serializable {
	private static final long serialVersionUID = 1L;

	Logger LOGGER=LoggerFactory.getLogger(PublicacionController.class);
	
	@ManagedProperty(value="#{restTemplate}")
	private RestTemplate restTemplate;
	
	@ManagedProperty(value="#{propiedadAdmin}")
	private PropiedadAdmin propiedadAdmin;
	
	private PublicacionForm publicacion;
	
	private List<PublicacionForm> publicaciones;

	@PostConstruct
	private void init(){
		this.publicacion=new PublicacionForm();
	}
	
	public void create(){
		LOGGER.info("## Registrar publicacion");
		
		String url=propiedadAdmin.getURIServiceAdmin(URI.SERVICE_PUBLICACION_CREATE);
	    BResult result=restTemplate.postForObject(url, new HttpEntity<PublicacionForm>(this.publicacion),BResult.class);
	    
		if (result.getEstado()==ESTADO_OPERACION.EXITO.getCodigo()) {
			LOGGER.info("## publicacion registrada");
			Faces.addMessage("Exito", "publicacion registrada", FacesMessage.SEVERITY_INFO);
		}else{
			LOGGER.info("## error al actualizar");
			Faces.addMessage("Error", "Error al registrar", FacesMessage.SEVERITY_ERROR);
		}
	}
	
	public void update(){
		LOGGER.info("## Actualizar publicacion");
		
		String url=propiedadAdmin.getURIServiceAdmin(URI.SERVICE_PUBLICACION_UPDATE);
	    BResult result=restTemplate.postForObject(url, new HttpEntity<PublicacionForm>(this.publicacion),BResult.class);
	    
		if (result.getEstado()==ESTADO_OPERACION.EXITO.getCodigo()) {
			LOGGER.info("## publicacion actualizada");
			Faces.addMessage("Exito", "publicacion actualizada", FacesMessage.SEVERITY_INFO);
		}else{
			LOGGER.info("## error al actualizar");
			Faces.addMessage("Error", "Error al actualizar", FacesMessage.SEVERITY_ERROR);
		}
	}

	public void delete(){
		LOGGER.info("## Eliminar publicacion");
		
		String url=propiedadAdmin.getURIServiceAdmin(URI.SERVICE_PUBLICACION_DELETE);
	    BResult result=restTemplate.postForObject(url, new HttpEntity<PublicacionForm>(this.publicacion),BResult.class);
	    
		if (result.getEstado()==ESTADO_OPERACION.EXITO.getCodigo()) {
			LOGGER.info("## publicacion eliminada");
			Faces.addMessage("Exito", "publicacion eliminada", FacesMessage.SEVERITY_INFO);
		}else{
			LOGGER.info("## error al actualizar");
			Faces.addMessage("Error", "Error al eliminar", FacesMessage.SEVERITY_ERROR);
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

	public PublicacionForm getPublicacion() {
		return publicacion;
	}

	public void setPublicacion(PublicacionForm publicacion) {
		this.publicacion = publicacion;
	}

	public List<PublicacionForm> getPublicaciones() {
		return publicaciones;
	}

	public void setPublicaciones(List<PublicacionForm> publicaciones) {
		this.publicaciones = publicaciones;
	}
	
	
}
