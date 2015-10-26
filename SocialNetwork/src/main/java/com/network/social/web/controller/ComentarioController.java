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
import com.network.social.web.form.ComentarioForm;
import com.network.social.web.jsf.util.Faces;
import com.network.social.web.spring.util.AdminConfigPropiedad.URI;
import com.network.social.web.spring.util.BResult;

/**
 * @author :Alexander Chavez Simbron
 * @date   :26/10/2015
 * @time   :17:52:55
 */
@ManagedBean(name="comentario")
public class ComentarioController implements Serializable{
	private static final long serialVersionUID = 1L;

	Logger LOGGER=LoggerFactory.getLogger(ComentarioController.class);

	@ManagedProperty(value="#{restTemplate}")
	private RestTemplate restTemplate;
	
	@ManagedProperty(value="#{propiedadAdmin}")
	private PropiedadAdmin propiedadAdmin;
	
	private ComentarioForm comentario;
	
	private List<ComentarioForm> comentarios;

	@PostConstruct
	public void init(){
		this.comentario=new ComentarioForm();
	}
	
	public void create(){
		LOGGER.info("## Registrar Comentario");
		
		String url=propiedadAdmin.getURIServiceAdmin(URI.SERVICE_COMENTARIO_CREATE);
	    BResult result=restTemplate.postForObject(url, new HttpEntity<ComentarioForm>(this.comentario),BResult.class);
	    
		if (result.getEstado()==ESTADO_OPERACION.EXITO.getCodigo()) {
			LOGGER.info("## comentario registrado");
			Faces.addMessage("Exito", "comentario registrado", FacesMessage.SEVERITY_INFO);
		}else{
			LOGGER.info("## error al actualizar");
			Faces.addMessage("Error", "Error al registrar", FacesMessage.SEVERITY_ERROR);
		}
	}
	
	public void update(){
		LOGGER.info("## Actualizar Comentario");
		
		String url=propiedadAdmin.getURIServiceAdmin(URI.SERVICE_COMENTARIO_UPDATE);
	    BResult result=restTemplate.postForObject(url, new HttpEntity<ComentarioForm>(this.comentario),BResult.class);
	    
		if (result.getEstado()==ESTADO_OPERACION.EXITO.getCodigo()) {
			LOGGER.info("## comentario actualizado");
			Faces.addMessage("Exito", "comentario actualizado", FacesMessage.SEVERITY_INFO);
		}else{
			LOGGER.info("## error al actualizar");
			Faces.addMessage("Error", "Error al actualizar", FacesMessage.SEVERITY_ERROR);
		}
	}
	
	public void delete(){
		LOGGER.info("## Eliminar Comentario");
		
		String url=propiedadAdmin.getURIServiceAdmin(URI.SERVICE_COMENTARIO_DELETE);
	    BResult result=restTemplate.postForObject(url, new HttpEntity<ComentarioForm>(this.comentario),BResult.class);
	    
		if (result.getEstado()==ESTADO_OPERACION.EXITO.getCodigo()) {
			LOGGER.info("## comentario eliminado");
			Faces.addMessage("Exito", "comentario eliminado", FacesMessage.SEVERITY_INFO);
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

	public ComentarioForm getComentario() {
		return comentario;
	}

	public void setComentario(ComentarioForm comentario) {
		this.comentario = comentario;
	}

	public List<ComentarioForm> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<ComentarioForm> comentarios) {
		this.comentarios = comentarios;
	}
	
	
	
	
}
