package com.network.social.web.controller;

import java.io.Serializable;
import java.util.Arrays;
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
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.network.social.web.config.PropiedadAdmin;
import com.network.social.web.config.UtilEnum.ESTADO_OPERACION;
import com.network.social.web.form.ListaContactoForm;
import com.network.social.web.form.UsuarioForm;
import com.network.social.web.jsf.util.Faces;
import com.network.social.web.spring.util.AdminConfigPropiedad.URI;
import com.network.social.web.spring.util.BResult;

/**
 * @author :Alexander Chavez Simbron
 * @date   :27/10/2015
 * @time   :11:30:49
 */
@ManagedBean(name="lista")
public class ListaContactoController implements Serializable {
	private static final long serialVersionUID = 1L;

	Logger LOGGER=LoggerFactory.getLogger(ListaContactoController.class);
	
	@ManagedProperty(value="#{restTemplate}")
	private RestTemplate restTemplate;
	
	@ManagedProperty(value="#{propiedadAdmin}")
	private PropiedadAdmin propiedadAdmin;
	
	private ListaContactoForm listaContacto;
	
	private List<ListaContactoForm> listaContactos;

	@PostConstruct
	private void init(){
		this.listaContacto=new ListaContactoForm();
	}
	
	public void create(){
		LOGGER.info("## Registrar Lista");
		
		String url=propiedadAdmin.getURIServiceAdmin(URI.SERVICE_LISTA_CREATE);
	    BResult result=restTemplate.postForObject(url, new HttpEntity<ListaContactoForm>(this.listaContacto),BResult.class);
	    
		if (result.getEstado()==ESTADO_OPERACION.EXITO.getCodigo()) {
			LOGGER.info("## Lista registrado");
			Faces.addMessage("Exito", "Lista registrado", FacesMessage.SEVERITY_INFO);
		}else{
			LOGGER.info("## error al actualizar");
			Faces.addMessage("Error", "Error al registrar", FacesMessage.SEVERITY_ERROR);
		}
	}
	
	public void update(){
		LOGGER.info("## Actualizar Lista");
		
		String url=propiedadAdmin.getURIServiceAdmin(URI.SERVICE_LISTA_UPDATE);
	    BResult result=restTemplate.postForObject(url, new HttpEntity<ListaContactoForm>(this.listaContacto),BResult.class);
	    
		if (result.getEstado()==ESTADO_OPERACION.EXITO.getCodigo()) {
			LOGGER.info("## Lista actualizado");
			Faces.addMessage("Exito", "Lista actualizado", FacesMessage.SEVERITY_INFO);
		}else{
			LOGGER.info("## error al actualizar");
			Faces.addMessage("Error", "Error al actualizar", FacesMessage.SEVERITY_ERROR);
		}
	}

	public void delete(){
		LOGGER.info("## ELiminar Lista");
		
		String url=propiedadAdmin.getURIServiceAdmin(URI.SERVICE_LISTA_DELETE);
	    BResult result=restTemplate.postForObject(url, new HttpEntity<ListaContactoForm>(this.listaContacto),BResult.class);
	    
		if (result.getEstado()==ESTADO_OPERACION.EXITO.getCodigo()) {
			LOGGER.info("## Lista eliminada");
			Faces.addMessage("Exito", "Lista eliminada", FacesMessage.SEVERITY_INFO);
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

	public ListaContactoForm getListaContacto() {
		return listaContacto;
	}

	public void setListaContacto(ListaContactoForm listaContacto) {
		this.listaContacto = listaContacto;
	}

	public List<ListaContactoForm> getListaContactos() {
		
		if (Faces.getSessionAttribute(Faces.ATTRIBUTE_USER)!=null) {
			UsuarioForm logged=((UsuarioForm)Faces.getSessionAttribute(Faces.ATTRIBUTE_USER));
			
			if (logged.getRoles().iterator().next().getDescripcion().equalsIgnoreCase("Admin")) {
				String url=propiedadAdmin.getURIServiceAdmin(URI.SERVICE_LISTA_GETALL);
				ResponseEntity<ListaContactoForm[]> data=restTemplate.getForEntity(url, ListaContactoForm[].class);
				return Arrays.asList(data.getBody());
			} else {
				String url=propiedadAdmin.getURIServiceAdmin(URI.SERVICE_LISTA_GET_BY_USER);
				Map<String,Integer> urlVariables=new HashMap<String,Integer>();
				urlVariables.put("filter",logged.getIdusuario());
				ResponseEntity<ListaContactoForm[]> data=restTemplate.getForEntity(url, ListaContactoForm[].class, urlVariables);
				return Arrays.asList(data.getBody());
			}
		
		}
		return listaContactos;
	}

	public void setListaContactos(List<ListaContactoForm> listaContactos) {
		this.listaContactos = listaContactos;
	}
	
	
	
}
