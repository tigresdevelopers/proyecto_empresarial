package com.network.social.web.controller;

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
import com.network.social.web.form.UsuarioForm;
import com.network.social.web.jsf.util.Faces;
import com.network.social.web.spring.security.PasswordEncoder;
import com.network.social.web.spring.util.AdminConfigPropiedad.URI;
import com.network.social.web.spring.util.BResult;

/**
* @author : Alexander Chavez Simbron
* @date   : 25 de oct. de 2015
* @time   : 12:02:21 p. m.
*/
@ManagedBean(name="usuario")
public class UsuarioController {
	Logger LOGGER=LoggerFactory.getLogger(UsuarioController.class);

	@ManagedProperty(value="#{restTemplate}")
	private RestTemplate restTemplate;
	
	@ManagedProperty(value="#{propiedadAdmin}")
	private PropiedadAdmin propiedadAdmin;
	
	private UsuarioForm usuario;
	private String apellidos;
	
	private List<UsuarioForm> usuarios;
	
	@PostConstruct
	public void init(){
		usuario=new UsuarioForm();
		System.out.println("iusuairo inciiado");
	}
	
	public void create(){
		
		LOGGER.info("## Create user-->"+usuario.getEmail());
		
		String datos[]=this.apellidos.split("\\s+");
		
		if (datos.length>1) {
			this.usuario.setApePaterno(datos[0]);
			this.usuario.setApeMaterno(datos[1]);
		}else{
			this.usuario.setApePaterno(apellidos);
			this.usuario.setApeMaterno("");
		}
		
		this.usuario.setClave(PasswordEncoder.encodePassword(this.usuario.getClave()));
		this.usuario.setFechaRegistro(new Date());
		
		String url=propiedadAdmin.getURIServiceAdmin(URI.SERVICE_USUARIO_CREATE);
		
		BResult result=restTemplate.postForObject(url, new HttpEntity<UsuarioForm>(this.usuario),BResult.class);
		
		if (result.getEstado()==ESTADO_OPERACION.EXITO.getCodigo()) {
			LOGGER.info("## registro correcto");
			Faces.addMessage("Correcto","usuario registrado",FacesMessage.SEVERITY_INFO);
		}else{
			LOGGER.info("## error al registrar");
			Faces.addMessage("Error","error al registrar",FacesMessage.SEVERITY_ERROR);
		}
		
	}
	
	public void update(){
		LOGGER.info("## Actualizar Usuario");
		
		String url=propiedadAdmin.getURIServiceAdmin(URI.SERVICE_USUARIO_UPDATE);
	    BResult result=restTemplate.postForObject(url, new HttpEntity<UsuarioForm>(this.usuario),BResult.class);
	    
		if (result.getEstado()==ESTADO_OPERACION.EXITO.getCodigo()) {
			LOGGER.info("## usuario actualizado");
			Faces.addMessage("Exito", "Usuairo actualizado", FacesMessage.SEVERITY_INFO);
		}else{
			LOGGER.info("## error al actualizar");
			Faces.addMessage("Error", "Error al actualizar", FacesMessage.SEVERITY_ERROR);
		}
	}

	public void delete(){
		LOGGER.info("## Eliminar Usuario");
		
		String url=propiedadAdmin.getURIServiceAdmin(URI.SERVICE_USUARIO_DELETE);
	    
	    BResult result=restTemplate.postForObject(url,new HttpEntity<UsuarioForm>(usuario),BResult.class);
	    
		if (result.getEstado()==ESTADO_OPERACION.EXITO.getCodigo()) {
			LOGGER.info("## usuario actualizado");
			Faces.addMessage("Exito", "Usuairo actualizado", FacesMessage.SEVERITY_INFO);
		}else{
			LOGGER.info("## error al actualizar");
			Faces.addMessage("Error", "Error al actualizar", FacesMessage.SEVERITY_ERROR);
		}
	}
	
	
	
	
	public UsuarioForm getUsuario() {
		return usuario;
	}
	
	public void setUsuario(UsuarioForm usuario) {
		this.usuario = usuario;
	}

	public List<UsuarioForm> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<UsuarioForm> usuarios) {
		this.usuarios = usuarios;
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

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	
}


