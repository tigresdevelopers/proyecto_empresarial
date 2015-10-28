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
import com.network.social.web.form.TipoContactoForm;
import com.network.social.web.jsf.util.Faces;
import com.network.social.web.spring.util.AdminConfigPropiedad.URI;
import com.network.social.web.spring.util.BResult;

/**
 * @author :Alexander Chavez Simbron
 * @date   :27/10/2015
 * @time   :14:11:43
 */
@ManagedBean(name="tipocontacto")
public class TipoContactoController implements Serializable {
	private static final long serialVersionUID = 1L;

	Logger LOGGER=LoggerFactory.getLogger(TipoContactoController.class);

	@ManagedProperty(value="#{restTemplate}")
	private RestTemplate restTemplate;
	
	@ManagedProperty(value="#{propiedadAdmin}")
	private PropiedadAdmin propiedadAdmin;
	
	private TipoContactoForm tipo;
	private List<TipoContactoForm> tipos;
	
	@PostConstruct
	private void init(){
		this.tipo=new TipoContactoForm();
	}
	
	public void create(){
		LOGGER.info("## Registrar Tipo");
		
		String url=propiedadAdmin.getURIServiceAdmin(URI.SERVICE_TIPO_CREATE);
	    BResult result=restTemplate.postForObject(url, new HttpEntity<TipoContactoForm>(this.tipo),BResult.class);
	    
		if (result.getEstado()==ESTADO_OPERACION.EXITO.getCodigo()) {
			LOGGER.info("## Tipo registrado");
			Faces.addMessage("Exito", "Tipo registrado", FacesMessage.SEVERITY_INFO);
		}else{
			LOGGER.info("## error al actualizar");
			Faces.addMessage("Error", "Error al registrar", FacesMessage.SEVERITY_ERROR);
		}
	}
	
	public void update(){
		LOGGER.info("## Actualizar Tipo");
		
		String url=propiedadAdmin.getURIServiceAdmin(URI.SERVICE_TIPO_UPDATE);
	    BResult result=restTemplate.postForObject(url, new HttpEntity<TipoContactoForm>(this.tipo),BResult.class);
	    
		if (result.getEstado()==ESTADO_OPERACION.EXITO.getCodigo()) {
			LOGGER.info("## Tipo actualizado");
			Faces.addMessage("Exito", "Tipo actualizado", FacesMessage.SEVERITY_INFO);
		}else{
			LOGGER.info("## error al actualizar");
			Faces.addMessage("Error", "Error al actualizar", FacesMessage.SEVERITY_ERROR);
		}
	}
	
	public void delete(){
	LOGGER.info("## Eliminar Tipo");
		
		String url=propiedadAdmin.getURIServiceAdmin(URI.SERVICE_TIPO_DELETE);
	    BResult result=restTemplate.postForObject(url, new HttpEntity<TipoContactoForm>(this.tipo),BResult.class);
	    
		if (result.getEstado()==ESTADO_OPERACION.EXITO.getCodigo()) {
			LOGGER.info("## Tipo eliminado");
			Faces.addMessage("Exito", "Tipo eliminado", FacesMessage.SEVERITY_INFO);
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
	public TipoContactoForm getTipo() {
		return tipo;
	}
	public void setTipo(TipoContactoForm tipo) {
		this.tipo = tipo;
	}
	public List<TipoContactoForm> getTipos() {
		return tipos;
	}
	public void setTipos(List<TipoContactoForm> tipos) {
		this.tipos = tipos;
	}
	
	
}
