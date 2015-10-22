package com.network.social.web.controller;

import java.io.Serializable;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import org.springframework.web.client.RestTemplate;

import com.network.social.domain.util.ResultObject;
import com.network.social.web.config.PropiedadAdmin;
import com.network.social.web.form.UsuarioForm;
import com.network.social.web.spring.util.AdminConfigPropiedad.URI;
/**
 * @author :Alexander Chavez Simbron
 * @date   :20/10/2015
 * @time   :13:18:13
 */
@ManagedBean(name="testclient")
public class TestRestClient implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value="#{restTemplate}")
	private RestTemplate restTemplate;
	
	@ManagedProperty(value="#{propiedadAdmin}")
	private PropiedadAdmin propiedadAdmin;
	
	private UsuarioForm usuarioForm;
	private String nombre;

	@PostConstruct
	public void init(){
		
		String url="http://localhost:8080/ServicesRestSocialNetwork/json";
		ResultObject obj=restTemplate.getForObject(url, ResultObject.class);
		
		for (Map<String, Object> map : obj.getData()) {
			this.usuarioForm=new UsuarioForm(
					map.get("usuario").toString(),
					map.get("clave").toString()
					);
			System.out.println(map.get("usuario"));
		}
		
		this.nombre="Alexander Chavez Simbron";
		System.out.println( propiedadAdmin.getURIServiceAdmin(URI.SERVICE_ACCESO_OBTENER_USUARIO) );
		
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


	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public UsuarioForm getUsuarioForm() {
		return usuarioForm;
	}
	public void setUsuarioForm(UsuarioForm usuarioForm) {
		this.usuarioForm = usuarioForm;
	}
	
	
	
	
}
