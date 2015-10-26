package com.network.social.web.controller;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import com.network.social.web.config.PropiedadAdmin;
import com.network.social.web.config.UtilEnum.ESTADO_OPERACION;
import com.network.social.web.form.AlbumForm;
import com.network.social.web.form.UsuarioForm;
import com.network.social.web.jsf.util.Faces;
import static com.network.social.web.jsf.util.Faces.*;
import com.network.social.web.spring.util.AdminConfigPropiedad.URI;
import com.network.social.web.spring.util.BResult;
import com.network.social.web.spring.util.ResultObject;
import com.network.social.web.spring.util.UtilHardCode;

/**
* @author : Alexander Chavez Simbron
* @date   : 18 de oct. de 2015
* @time   : 6:16:23 p. m.
*/

@SessionScoped
@ManagedBean(name="album")
public class AlbumController implements Serializable {
	private static final long serialVersionUID = 1L;
	
	Logger LOGGER=LoggerFactory.getLogger(AlbumController.class);
	
	@ManagedProperty(value="#{restTemplate}")
	private RestTemplate restTemplate;
	
	@ManagedProperty(value="#{propiedadAdmin}")
	private PropiedadAdmin propiedadAdmin;
	
	private List<AlbumForm> albums;
	private AlbumForm album;

	@PostConstruct
	public void init(){
		
		this.albums=new ArrayList<AlbumForm>();
		
		Map<String, Object> urlVariables=new HashMap<>();
		urlVariables.put("idusuario",UtilHardCode.usuario.getIdusuario());
		
		ResultObject res=restTemplate.getForObject(
				propiedadAdmin.getURIServiceAdmin(URI.SERVICE_ALBUM_BY_USUARIO), ResultObject.class,urlVariables);
		
		for (Map<String, Object> entity : res.getData()) {
			AlbumForm album=new AlbumForm();
			album.setIdalbum(Integer.valueOf(entity.get("id").toString()));
			album.setNombre(entity.get("nombre")!=null?entity.get("nombre").toString():"");
			album.setDescripcion(entity.get("descripcion")!=null?entity.get("descripcion").toString():"");
			album.setLikes(entity.get("likes")!=null?Integer.valueOf(entity.get("likes").toString()):0);
			this.albums.add(album);
		}
		
	}	
	
	public void create(){
		
		album=UtilHardCode.album;
		album.setNombre(album.getNombre().replace("{hora}",new SimpleDateFormat("dd/MM/YYYY MM:SS").format(new Date())));
		album.setUsuario((UsuarioForm)Faces.getSessionAttribute(ATTRIBUTE_USER));
		
		BResult bresult=restTemplate.postForObject(propiedadAdmin.getURIServiceAdmin(URI.SERVICE_ALBUM_CREATE),
				new HttpEntity<AlbumForm>(this.album),BResult.class);
		
		System.out.println(bresult.getEstado());
		System.out.println(bresult);
	}
	
	public void  update(){
		LOGGER.info("## Actualizar Album");
		String url=propiedadAdmin.getURIServiceAdmin(URI.SERVICE_ALBUM_UPDATE);
	    BResult result=restTemplate.postForObject(url, new HttpEntity<AlbumForm>(this.album),BResult.class);
	    
		if (result.getEstado()==ESTADO_OPERACION.EXITO.getCodigo()) {
			LOGGER.info("## Album actualizado");
			Faces.addMessage("Exito", "Usuairo actualizado", FacesMessage.SEVERITY_INFO);
		}else{
			LOGGER.info("## error al actualizar");
			Faces.addMessage("Error", "Error al actualizar", FacesMessage.SEVERITY_ERROR);
		}	
	}
	
	public void delete(){
		LOGGER.info("## Eliminar Album");
		
		String url=propiedadAdmin.getURIServiceAdmin(URI.SERVICE_ALBUM_DELETE);
	    
	    BResult result=restTemplate.postForObject(url,new HttpEntity<AlbumForm>(this.album),BResult.class);
	    
		if (result.getEstado()==ESTADO_OPERACION.EXITO.getCodigo()) {
			LOGGER.info("## album eliminado");
			Faces.addMessage("Exito", "Album eliminado", FacesMessage.SEVERITY_INFO);
		}else{
			LOGGER.info("## error al eliminar");
			Faces.addMessage("Error", "Error al eliminar", FacesMessage.SEVERITY_ERROR);
		}
	}
	
	
	
	public List<AlbumForm> getAlbums() {
		return albums;
	}
	public void setAlbums(List<AlbumForm> albums) {
		this.albums = albums;
	}
	public AlbumForm getAlbum() {
		return album;
	}
	public void setAlbum(AlbumForm album) {
		this.album = album;
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

}


