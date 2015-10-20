package com.network.social.web.controller;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import com.network.social.domain.entities.Album;
import com.network.social.domain.util.BResult;
import com.network.social.domain.util.ResultObject;
import com.network.social.web.config.PropiedadAdmin;
import com.network.social.web.spring.util.AdminConfigPropiedad.URI;
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
	
	@ManagedProperty(value="#{restTemplate}")
	private RestTemplate restTemplate;
	
	@ManagedProperty(value="#{propiedadAdmin}")
	private PropiedadAdmin propiedadAdmin;
	
	private List<Album> albums;
	private Album album;

	@PostConstruct
	public void init(){
		
		this.albums=new ArrayList<Album>();
		
		Map<String, Object> urlVariables=new HashMap<>();
		urlVariables.put("idusuario",UtilHardCode.usuario.getIdusuario());
		
		ResultObject res=restTemplate.getForObject(
				propiedadAdmin.getURIServiceAdmin(URI.SERVICE_ALBUM_BY_USUARIO), ResultObject.class,urlVariables);
		
		for (Map<String, Object> entity : res.getData()) {
			Album album=new Album();
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
		
		album.setUsuario(UtilHardCode.usuario);
		
		BResult bresult=restTemplate.postForObject(propiedadAdmin.getURIServiceAdmin(URI.SERVICE_ALBUM_CREATE),
				new HttpEntity<Album>(this.album),BResult.class);
		
		System.out.println(bresult.getEstado());
		System.out.println(bresult);
	}
	
	public void delete(){
		
	}
	
	
	
	public List<Album> getAlbums() {
		return albums;
	}
	public void setAlbums(List<Album> albums) {
		this.albums = albums;
	}
	public Album getAlbum() {
		return album;
	}
	public void setAlbum(Album album) {
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


