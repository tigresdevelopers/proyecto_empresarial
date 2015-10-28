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
import com.network.social.web.form.LikeForm;
import com.network.social.web.jsf.util.Faces;
import com.network.social.web.spring.util.AdminConfigPropiedad.URI;
import com.network.social.web.spring.util.BResult;

/**
 * @author :Alexander Chavez Simbron
 * @date   :27/10/2015
 * @time   :11:24:56
 */
@ManagedBean(name="like")
public class LikeController implements Serializable {
	private static final long serialVersionUID = 1L;

	Logger LOGGER=LoggerFactory.getLogger(LikeController.class);
	
	@ManagedProperty(value="#{restTemplate}")
	private RestTemplate restTemplate;
	
	@ManagedProperty(value="#{propiedadAdmin}")
	private PropiedadAdmin propiedadAdmin;
	
	private LikeForm like;
	
	private List<LikeForm> likes;

	@PostConstruct
	private void init(){
		this.like=new LikeForm();
	}
	
	public void create(){
		LOGGER.info("## Registrar Like");
		
		String url=propiedadAdmin.getURIServiceAdmin(URI.SERVICE_LIKE_CREATE);
	    BResult result=restTemplate.postForObject(url, new HttpEntity<LikeForm>(this.like),BResult.class);
	    
		if (result.getEstado()==ESTADO_OPERACION.EXITO.getCodigo()) {
			LOGGER.info("## Like registrar");
			Faces.addMessage("Exito", "Like registrado", FacesMessage.SEVERITY_INFO);
		}else{
			LOGGER.info("## error al actualizar");
			Faces.addMessage("Error", "Error al registrar", FacesMessage.SEVERITY_ERROR);
		}
	}
	
	public void update(){
		LOGGER.info("## Actualizar Like");
		
		String url=propiedadAdmin.getURIServiceAdmin(URI.SERVICE_LIKE_UPDATE);
	    BResult result=restTemplate.postForObject(url, new HttpEntity<LikeForm>(this.like),BResult.class);
	    
		if (result.getEstado()==ESTADO_OPERACION.EXITO.getCodigo()) {
			LOGGER.info("## Like actualizado");
			Faces.addMessage("Exito", "Like actualizado", FacesMessage.SEVERITY_INFO);
		}else{
			LOGGER.info("## error al actualizar");
			Faces.addMessage("Error", "Error al actualizar", FacesMessage.SEVERITY_ERROR);
		}
	}

	public void delete(){
		LOGGER.info("## Eliminar Like");
		
		String url=propiedadAdmin.getURIServiceAdmin(URI.SERVICE_LIKE_UPDATE);
	    BResult result=restTemplate.postForObject(url, new HttpEntity<LikeForm>(this.like),BResult.class);
	    
		if (result.getEstado()==ESTADO_OPERACION.EXITO.getCodigo()) {
			LOGGER.info("## Like eliminado");
			Faces.addMessage("Exito", "Like eliminado", FacesMessage.SEVERITY_INFO);
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

	public LikeForm getLike() {
		return like;
	}

	public void setLike(LikeForm like) {
		this.like = like;
	}

	public List<LikeForm> getLikes() {
		return likes;
	}

	public void setLikes(List<LikeForm> likes) {
		this.likes = likes;
	}
	
	
	
}
