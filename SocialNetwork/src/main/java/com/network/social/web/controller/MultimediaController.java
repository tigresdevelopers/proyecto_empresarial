package com.network.social.web.controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.network.social.web.form.MultimediaForm;
import com.network.social.web.jsf.util.Faces;
import com.network.social.web.spring.util.AdminConfigPropiedad.URI;
import com.network.social.web.spring.util.BResult;

/**
 * @author :Alexander Chavez Simbron
 * @date   :26/10/2015
 * @time   :17:39:36
 */
@ManagedBean(name="multimedia")
public class MultimediaController implements Serializable {
	private static final long serialVersionUID = 1L;

	Logger LOGGER=LoggerFactory.getLogger(MultimediaController.class);

	@ManagedProperty(value="#{restTemplate}")
	private RestTemplate restTemplate;
	
	@ManagedProperty(value="#{propiedadAdmin}")
	private PropiedadAdmin propiedadAdmin;

	private MultimediaForm multimedia;
	private List<MultimediaForm> multimedias;

	@PostConstruct
	public void init(){
		this.multimedia=new MultimediaForm();
	}
	
	public MultimediaForm find(){
		LOGGER.info("## Buscar Multimedia");
		
		String url=propiedadAdmin.getURIServiceAdmin(URI.SERVICE_MULTIMEDIA_FIND);
		Map<String, Object> urlVariables=new HashMap<String, Object>();
		urlVariables.put("id", this.multimedia.getIdmultimedia());
		
	    this.multimedia=restTemplate.getForObject(url,MultimediaForm.class,urlVariables);
	   
	    return this.multimedia;
	}
	
	public void create(){
		LOGGER.info("## Registrar Multimedia");
		
		String url=propiedadAdmin.getURIServiceAdmin(URI.SERVICE_MULTIMEDIA_CREATE);
	    BResult result=restTemplate.postForObject(url, new HttpEntity<MultimediaForm>(this.multimedia),BResult.class);
	    
		if (result.getEstado()==ESTADO_OPERACION.EXITO.getCodigo()) {
			LOGGER.info("## Multimedia actualizado");
			Faces.addMessage("Exito", "Multimedia registrado", FacesMessage.SEVERITY_INFO);
		}else{
			LOGGER.info("## error al actualizar");
			Faces.addMessage("Error", "Error al registrar", FacesMessage.SEVERITY_ERROR);
		}
	}
	
	public void update(){
		LOGGER.info("## Actualizar Multimedia");
		
		String url=propiedadAdmin.getURIServiceAdmin(URI.SERVICE_MULTIMEDIA_UPDATE);
	    BResult result=restTemplate.postForObject(url, new HttpEntity<MultimediaForm>(this.multimedia),BResult.class);
	    
		if (result.getEstado()==ESTADO_OPERACION.EXITO.getCodigo()) {
			LOGGER.info("## Multimedia actualizado");
			Faces.addMessage("Exito", "Multimedia actualizado", FacesMessage.SEVERITY_INFO);
		}else{
			LOGGER.info("## error al actualizar");
			Faces.addMessage("Error", "Error al actualizar", FacesMessage.SEVERITY_ERROR);
		}
	}
	
	public void delete(){
		LOGGER.info("## Eliminar Multimedia");
		
		String url=propiedadAdmin.getURIServiceAdmin(URI.SERVICE_MULTIMEDIA_DELETE);
	    BResult result=restTemplate.postForObject(url, new HttpEntity<MultimediaForm>(this.multimedia),BResult.class);
	    
		if (result.getEstado()==ESTADO_OPERACION.EXITO.getCodigo()) {
			LOGGER.info("## Multimedia eliminado");
			Faces.addMessage("Exito", "Multimedia actualizado", FacesMessage.SEVERITY_INFO);
		}else{
			LOGGER.info("## error al eliminar");
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
	public MultimediaForm getMultimedia() {
		return multimedia;
	}
	public void setMultimedia(MultimediaForm multimedia) {
		this.multimedia = multimedia;
	}
	public List<MultimediaForm> getMultimedias() {
		return multimedias;
	}
	public void setMultimedias(List<MultimediaForm> multimedias) {
		this.multimedias = multimedias;
	}
	
	
	
}
