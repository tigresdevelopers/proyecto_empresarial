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
import com.network.social.web.form.SituacionForm;
import com.network.social.web.jsf.util.Faces;
import com.network.social.web.spring.util.AdminConfigPropiedad.URI;
import com.network.social.web.spring.util.BResult;

/**
 * @author :Alexander Chavez Simbron
 * @date   :27/10/2015
 * @time   :11:55:38
 */
@ManagedBean(name="situacion")
public class SituacionController implements Serializable {
	private static final long serialVersionUID = 1L;

	Logger LOGGER=LoggerFactory.getLogger(SituacionController.class);
	
	@ManagedProperty(value="#{restTemplate}")
	private RestTemplate restTemplate;
	
	@ManagedProperty(value="#{propiedadAdmin}")
	private PropiedadAdmin propiedadAdmin;
	
	private SituacionForm situacion;
	
	private List<SituacionForm> situaciones;

	@PostConstruct
	private void init(){
		this.situacion=new SituacionForm();
	}
	
	public void create(){
		LOGGER.info("## Registra Situacion");
		
		String url=propiedadAdmin.getURIServiceAdmin(URI.SERVICE_SITUACION_CREATE);
	    BResult result=restTemplate.postForObject(url, new HttpEntity<SituacionForm>(this.situacion),BResult.class);
	    
		if (result.getEstado()==ESTADO_OPERACION.EXITO.getCodigo()) {
			LOGGER.info("## Situacion registrada");
			Faces.addMessage("Exito", "Situacion registrada", FacesMessage.SEVERITY_INFO);
		}else{
			LOGGER.info("## error al actualizar");
			Faces.addMessage("Error", "Error al registrar", FacesMessage.SEVERITY_ERROR);
		}
	}
	
	public void update(){
		LOGGER.info("## Actualizar Situacion");
		
		String url=propiedadAdmin.getURIServiceAdmin(URI.SERVICE_SITUACION_UPDATE);
	    BResult result=restTemplate.postForObject(url, new HttpEntity<SituacionForm>(this.situacion),BResult.class);
	    
		if (result.getEstado()==ESTADO_OPERACION.EXITO.getCodigo()) {
			LOGGER.info("## Situacion actualizada");
			Faces.addMessage("Exito", "Situacion actualizada", FacesMessage.SEVERITY_INFO);
		}else{
			LOGGER.info("## error al actualizar");
			Faces.addMessage("Error", "Error al actualizar", FacesMessage.SEVERITY_ERROR);
		}	
	}
	
	public void delete(){
	LOGGER.info("## Eliminar Situacion");
		
		String url=propiedadAdmin.getURIServiceAdmin(URI.SERVICE_SITUACION_DELETE);
	    BResult result=restTemplate.postForObject(url, new HttpEntity<SituacionForm>(this.situacion),BResult.class);
	    
		if (result.getEstado()==ESTADO_OPERACION.EXITO.getCodigo()) {
			LOGGER.info("## Situacion eliminada");
			Faces.addMessage("Exito", "Situacion eliminada", FacesMessage.SEVERITY_INFO);
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

	public SituacionForm getSituacion() {
		return situacion;
	}

	public void setSituacion(SituacionForm situacion) {
		this.situacion = situacion;
	}

	public List<SituacionForm> getSituaciones() {
		return situaciones;
	}

	public void setSituaciones(List<SituacionForm> situaciones) {
		this.situaciones = situaciones;
	}
	
	
}
