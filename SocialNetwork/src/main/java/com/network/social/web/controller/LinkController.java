package com.network.social.web.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.network.social.web.config.PropiedadAdmin;
import com.network.social.web.jsf.util.Faces;
import com.network.social.web.spring.util.AdminConfigPropiedad.LINK;
/**
 * @author :Alexander Chavez Simbron
 * @date   :20/10/2015
 * @time   :13:18:13
 */
@SessionScoped
@ManagedBean(name="link")
public class LinkController implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value="#{propiedadAdmin}")
	private PropiedadAdmin  propiedadAdmin;
	
	
	public void redirect(LINK url) throws Exception {
		System.out.println(Faces.getContextPath());
		System.out.println(url);
		System.out.println(propiedadAdmin.getLinkUrl(url));
		Faces.redirect(propiedadAdmin.getLinkUrl(url));
	}


	public PropiedadAdmin getPropiedadAdmin() {
		return propiedadAdmin;
	}
	public void setPropiedadAdmin(PropiedadAdmin propiedadAdmin) {
		this.propiedadAdmin = propiedadAdmin;
	}
	
	
}
