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
import com.network.social.web.form.NotificacionForm;
import com.network.social.web.jsf.util.Faces;
import com.network.social.web.spring.util.AdminConfigPropiedad.URI;
import com.network.social.web.spring.util.BResult;

/**
 * @author :Alexander Chavez Simbron
 * @date   :27/10/2015
 * @time   :11:36:49
 */
@ManagedBean(name="notificacion")
public class NotificacionController implements Serializable {
	private static final long serialVersionUID = 1L;

	Logger LOGGER=LoggerFactory.getLogger(NotificacionController.class);
	
	@ManagedProperty(value="#{restTemplate}")
	private RestTemplate restTemplate;
	
	@ManagedProperty(value="#{propiedadAdmin}")
	private PropiedadAdmin propiedadAdmin;
	
	private NotificacionForm notificacion;
	
	private List<NotificacionForm> notificaciones;
	
	@PostConstruct
	private void init(){
		this.notificacion=new NotificacionForm();
	}
	
	public void create(){
		LOGGER.info("## Registrar notificacion");
		
		String url=propiedadAdmin.getURIServiceAdmin(URI.SERVICE_NOTIFICACION_CREATE);
	    BResult result=restTemplate.postForObject(url,new HttpEntity<NotificacionForm>(this.notificacion),BResult.class);
	    
		if (result.getEstado()==ESTADO_OPERACION.EXITO.getCodigo()) {
			LOGGER.info("## notificacion registrada");
			Faces.addMessage("Exito", "notificacion registrada", FacesMessage.SEVERITY_INFO);
		}else{
			LOGGER.info("## error al actualizar");
			Faces.addMessage("Error", "Error al registrar", FacesMessage.SEVERITY_ERROR);
		}
	}
	
	public void update(){
		LOGGER.info("## Actualizar notificacion");
		
		String url=propiedadAdmin.getURIServiceAdmin(URI.SERVICE_NOTIFICACION_UPDATE);
	    BResult result=restTemplate.postForObject(url,new HttpEntity<NotificacionForm>(this.notificacion),BResult.class);
	    
		if (result.getEstado()==ESTADO_OPERACION.EXITO.getCodigo()) {
			LOGGER.info("## notificacion actualizada");
			Faces.addMessage("Exito", "notificacion actualizada", FacesMessage.SEVERITY_INFO);
		}else{
			LOGGER.info("## error al actualizar");
			Faces.addMessage("Error", "Error al actualizar", FacesMessage.SEVERITY_ERROR);
		}
	}

	public void delete(){
	LOGGER.info("## Eliminar notificacion");
		
		String url=propiedadAdmin.getURIServiceAdmin(URI.SERVICE_NOTIFICACION_DELETE);
	    BResult result=restTemplate.postForObject(url,new HttpEntity<NotificacionForm>(this.notificacion),BResult.class);
	    
		if (result.getEstado()==ESTADO_OPERACION.EXITO.getCodigo()) {
			LOGGER.info("## notificacion eliminada");
			Faces.addMessage("Exito", "notificacion eliminada", FacesMessage.SEVERITY_INFO);
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

	public NotificacionForm getNotificacion() {
		return notificacion;
	}

	public void setNotificacion(NotificacionForm notificacion) {
		this.notificacion = notificacion;
	}

	public List<NotificacionForm> getNotificaciones() {
		return notificaciones;
	}

	public void setNotificaciones(List<NotificacionForm> notificaciones) {
		this.notificaciones = notificaciones;
	}
	
	
	
}
