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
import com.network.social.web.form.IdiomaForm;
import com.network.social.web.jsf.util.Faces;
import com.network.social.web.spring.util.AdminConfigPropiedad.URI;
import com.network.social.web.spring.util.BResult;

/**
 * @author :Alexander Chavez Simbron
 * @date   :27/10/2015
 * @time   :11:10:40
 */

public class IdiomaController implements Serializable{
	private static final long serialVersionUID = 1L;

	Logger LOGGER=LoggerFactory.getLogger(IdiomaController.class);
	
	@ManagedProperty(value="#{restTemplate}")
	private RestTemplate restTemplate;
	
	@ManagedProperty(value="#{propiedadAdmin}")
	private PropiedadAdmin propiedadAdmin;
	
	private IdiomaForm idioma;
	
	private List<IdiomaForm> idiomas;
	
	@PostConstruct
	private void init(){
		this.idioma=new IdiomaForm();
	}
	
	public void create(){
		LOGGER.info("## Registrar Idioma");
		
		String url=propiedadAdmin.getURIServiceAdmin(URI.SERVICE_IDIOMA_CREATE);
	    BResult result=restTemplate.postForObject(url, new HttpEntity<IdiomaForm>(this.idioma),BResult.class);
	    
		if (result.getEstado()==ESTADO_OPERACION.EXITO.getCodigo()) {
			LOGGER.info("## Idioma registrado");
			Faces.addMessage("Exito", "Idioma registrado", FacesMessage.SEVERITY_INFO);
		}else{
			LOGGER.info("## error al actualizar");
			Faces.addMessage("Error", "Error al registrar", FacesMessage.SEVERITY_ERROR);
		}
	}
	

	public void update(){
		LOGGER.info("## Actualizar Idioma");
		
		String url=propiedadAdmin.getURIServiceAdmin(URI.SERVICE_IDIOMA_UPDATE);
	    BResult result=restTemplate.postForObject(url, new HttpEntity<IdiomaForm>(this.idioma),BResult.class);
	    
		if (result.getEstado()==ESTADO_OPERACION.EXITO.getCodigo()) {
			LOGGER.info("## Idioma actualizado");
			Faces.addMessage("Exito", "Idioma actualizado", FacesMessage.SEVERITY_INFO);
		}else{
			LOGGER.info("## error al actualizar");
			Faces.addMessage("Error", "Error al actualizar", FacesMessage.SEVERITY_ERROR);
		}
	}

	public void delete(){
		LOGGER.info("## Eliminar Idioma");
		
		String url=propiedadAdmin.getURIServiceAdmin(URI.SERVICE_IDIOMA_DELETE);
	    BResult result=restTemplate.postForObject(url, new HttpEntity<IdiomaForm>(this.idioma),BResult.class);
	    
		if (result.getEstado()==ESTADO_OPERACION.EXITO.getCodigo()) {
			LOGGER.info("## Idioma eliminado");
			Faces.addMessage("Exito", "Idioma eliminado", FacesMessage.SEVERITY_INFO);
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

	public IdiomaForm getIdioma() {
		return idioma;
	}

	public void setIdioma(IdiomaForm idioma) {
		this.idioma = idioma;
	}

	public List<IdiomaForm> getIdiomas() {
		return idiomas;
	}

	public void setIdiomas(List<IdiomaForm> idiomas) {
		this.idiomas = idiomas;
	}
	
	
	
	
}
