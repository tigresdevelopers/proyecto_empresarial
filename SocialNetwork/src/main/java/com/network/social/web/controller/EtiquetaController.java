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
import com.network.social.web.form.EtiquetaForm;
import com.network.social.web.form.UsuarioForm;
import com.network.social.web.jsf.util.Faces;
import com.network.social.web.spring.util.AdminConfigPropiedad.URI;
import com.network.social.web.spring.util.BResult;

/**
 * @author :Alexander Chavez Simbron
 * @date   :27/10/2015
 * @time   :10:46:46
 */
@ManagedBean(name="etiqueta")
public class EtiquetaController implements Serializable {
	private static final long serialVersionUID = 1L;

	Logger LOGGER=LoggerFactory.getLogger(EtiquetaController.class);

	@ManagedProperty(value="#{restTemplate}")
	private RestTemplate restTemplate;
	
	@ManagedProperty(value="#{propiedadAdmin}")
	private PropiedadAdmin propiedadAdmin;
	
	private EtiquetaForm etiqueta;
	
	private List<EtiquetaForm> etiquetas;

	@PostConstruct
	public void init(){
		this.etiqueta=new EtiquetaForm();
		
	}
	
	public void create(){
		LOGGER.info("## Registrar Etiqueta");
		this.etiqueta.setUsuario((UsuarioForm)Faces.getSessionAttribute(Faces.ATTRIBUTE_USER));
		
		String url=propiedadAdmin.getURIServiceAdmin(URI.SERVICE_ETIQUETA_CREATE);
	    BResult result=restTemplate.postForObject(url, new HttpEntity<EtiquetaForm>(this.etiqueta),BResult.class);
	    
		if (result.getEstado()==ESTADO_OPERACION.EXITO.getCodigo()) {
			LOGGER.info("## Etiqueta registrada");
			Faces.addMessage("Exito", "Etiqueta registrada", FacesMessage.SEVERITY_INFO);
		}else{
			LOGGER.info("## error al actualizar");
			Faces.addMessage("Error", "Error al registrar", FacesMessage.SEVERITY_ERROR);
		}
	}
	
	public void update(){
	LOGGER.info("## Actualizar Etiqueta");
		
		String url=propiedadAdmin.getURIServiceAdmin(URI.SERVICE_ETIQUETA_UPDATE);
	    BResult result=restTemplate.postForObject(url, new HttpEntity<EtiquetaForm>(this.etiqueta),BResult.class);
	    
		if (result.getEstado()==ESTADO_OPERACION.EXITO.getCodigo()) {
			LOGGER.info("## Etiqueta actualizada");
			Faces.addMessage("Exito", "Etiqueta actualizada", FacesMessage.SEVERITY_INFO);
		}else{
			LOGGER.info("## error al actualizar");
			Faces.addMessage("Error", "Error al actualizar", FacesMessage.SEVERITY_ERROR);
		}
	}

	public void delete(){
	LOGGER.info("## Eliminar Etiqueta");
		
		String url=propiedadAdmin.getURIServiceAdmin(URI.SERVICE_ETIQUETA_DELETE);
	    BResult result=restTemplate.postForObject(url, new HttpEntity<EtiquetaForm>(this.etiqueta),BResult.class);
	    
		if (result.getEstado()==ESTADO_OPERACION.EXITO.getCodigo()) {
			LOGGER.info("## Etiqueta actualizada");
			Faces.addMessage("Exito", "Etiqueta eliminada", FacesMessage.SEVERITY_INFO);
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

	public EtiquetaForm getEtiqueta() {
		return etiqueta;
	}

	public void setEtiqueta(EtiquetaForm etiqueta) {
		this.etiqueta = etiqueta;
	}

	public List<EtiquetaForm> getEtiquetas() {
		return etiquetas;
	}

	public void setEtiquetas(List<EtiquetaForm> etiquetas) {
		this.etiquetas = etiquetas;
	}
	
	
	
}
