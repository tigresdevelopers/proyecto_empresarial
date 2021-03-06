package com.network.social.web.controller;

import java.io.Serializable;
import java.util.Date;
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
import com.network.social.web.form.GrupoForm;
import com.network.social.web.form.GrupoUsuarioForm;
import com.network.social.web.form.UsuarioForm;
import com.network.social.web.jsf.util.Faces;
import com.network.social.web.spring.util.AdminConfigPropiedad.URI;
import com.network.social.web.spring.util.BResult;

/**
 * @author :Alexander Chavez Simbron
 * @date   :27/10/2015
 * @time   :11:04:00
 */
@ManagedBean(name="grupo")
public class GrupoController implements Serializable {
	private static final long serialVersionUID = 1L;

	Logger LOGGER=LoggerFactory.getLogger(GrupoController.class);
	
	@ManagedProperty(value="#{restTemplate}")
	private RestTemplate restTemplate;
	
	@ManagedProperty(value="#{propiedadAdmin}")
	private PropiedadAdmin propiedadAdmin;
	

	private GrupoForm grupo;
	
	private UsuarioForm member;
	
	private List<GrupoForm> grupos;

	@PostConstruct
	private void init(){
		this.grupo=new GrupoForm();
	}
	
	public void addMember(){
		LOGGER.info("## Agregar miembro");
		
		GrupoUsuarioForm gu=new GrupoUsuarioForm();
		gu.setFechaRegistro(new Date());
		gu.setGrupo(this.grupo);
		gu.setAdmin('0');
		gu.setUsuario(this.member);
		
		String url=propiedadAdmin.getURIServiceAdmin(URI.SERVICE_GRUPOUSUARIO_CREATE);
	    BResult result=restTemplate.postForObject(url, new HttpEntity<GrupoUsuarioForm>(gu),BResult.class);
	    
		if (result.getEstado()==ESTADO_OPERACION.EXITO.getCodigo()) {
			LOGGER.info("## Miembro registrado");
			Faces.addMessage("Exito", "Miembro registrado", FacesMessage.SEVERITY_INFO);
		}else{
			LOGGER.info("## error al registrar");
			Faces.addMessage("Error", "Error al registrar Miembro", FacesMessage.SEVERITY_ERROR);
		}
		
	}
	
	public void deleteMember(){
		LOGGER.info("## Eliminar miembro");
		
		GrupoUsuarioForm gu=new GrupoUsuarioForm();
		gu.setFechaRegistro(new Date());
		gu.setGrupo(this.grupo);
		gu.setAdmin('0');
		gu.setUsuario(this.member);
		
		String url=propiedadAdmin.getURIServiceAdmin(URI.SERVICE_GRUPOUSUARIO_DELETE);
	    BResult result=restTemplate.postForObject(url, new HttpEntity<GrupoUsuarioForm>(gu),BResult.class);
	    
		if (result.getEstado()==ESTADO_OPERACION.EXITO.getCodigo()) {
			LOGGER.info("## Miembro eliminado");
			Faces.addMessage("Exito", "Miembro eliminado", FacesMessage.SEVERITY_INFO);
		}else{
			LOGGER.info("## error al registrar");
			Faces.addMessage("Error", "Error al registrar eliminar", FacesMessage.SEVERITY_ERROR);
		}
		
	}
	
	public void create(){
		LOGGER.info("## Registrar Grupo");
		
		GrupoUsuarioForm gu=new GrupoUsuarioForm();
		gu.setAdmin('1');
		gu.setFechaRegistro(new Date());
		gu.setUsuario((UsuarioForm)Faces.getSessionAttribute(Faces.ATTRIBUTE_USER));
		
		this.grupo.getGrupoUsuarios().add(gu);
		
		String url=propiedadAdmin.getURIServiceAdmin(URI.SERVICE_GRUPO_CREATE);
	    BResult result=restTemplate.postForObject(url, new HttpEntity<GrupoForm>(this.grupo),BResult.class);
	    
		if (result.getEstado()==ESTADO_OPERACION.EXITO.getCodigo()) {
			LOGGER.info("## grupo registrado");
			Faces.addMessage("Exito", "grupo registrado", FacesMessage.SEVERITY_INFO);
		}else{
			LOGGER.info("## error al registrar");
			Faces.addMessage("Error", "Error al registrar", FacesMessage.SEVERITY_ERROR);
		}
	}
	
	public void update(){
		LOGGER.info("## Actualizar Grupo");
		
		String url=propiedadAdmin.getURIServiceAdmin(URI.SERVICE_GRUPO_UPDATE);
	    BResult result=restTemplate.postForObject(url, new HttpEntity<GrupoForm>(this.grupo),BResult.class);
	    
		if (result.getEstado()==ESTADO_OPERACION.EXITO.getCodigo()) {
			LOGGER.info("## Grupo actualizado");
			Faces.addMessage("Exito", "Grupo actualizado", FacesMessage.SEVERITY_INFO);
		}else{
			LOGGER.info("## error al actualizar");
			Faces.addMessage("Error", "Error al actualizar", FacesMessage.SEVERITY_ERROR);
		}
	}
	
	public void delete(){
		LOGGER.info("## Eliminar Grupo");
		
		String url=propiedadAdmin.getURIServiceAdmin(URI.SERVICE_GRUPO_DELETE);
	    BResult result=restTemplate.postForObject(url, new HttpEntity<GrupoForm>(this.grupo),BResult.class);
	    
		if (result.getEstado()==ESTADO_OPERACION.EXITO.getCodigo()) {
			LOGGER.info("## Grupo actualizado");
			Faces.addMessage("Exito", "Grupo eliminado", FacesMessage.SEVERITY_INFO);
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

	public GrupoForm getGrupo() {
		return grupo;
	}

	public void setGrupo(GrupoForm grupo) {
		this.grupo = grupo;
	}

	public List<GrupoForm> getGrupos() {
		return grupos;
	}

	public void setGrupos(List<GrupoForm> grupos) {
		this.grupos = grupos;
	}

	public UsuarioForm getMember() {
		return member;
	}

	public void setMember(UsuarioForm member) {
		this.member = member;
	}
	
	
	
}
