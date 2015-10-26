package com.network.social.web.spring.util;

public class AdminConfigPropiedad {

	public enum URI {
		
		SERVICE_ACCESO_OBTENER_USUARIO("uri.service.usuario","uri.service.acceso.usuario.get"),
		
		SERVICE_USUARIO_CREATE("uri.service.usuario","uri.service.create"),
		SERVICE_USUARIO_UPDATE("uri.service.usuario","uri.service.update"),
		SERVICE_USUARIO_DELETE("uri.service.usuario","uri.service.delete"),
		SERVICE_USUARIO_FIND("uri.service.usuario","uri.service.find"),
		
		
		SERVICE_ALBUM_BY_USUARIO("album","uri.service.album.usuario"),
		SERVICE_ALBUM_CREATE("album","uri.service.album.create")
		
		;
		
		private final String controller;
		private final String uri;
		
		
		URI(String controller,String valor) {
			this.controller=controller;
			this.uri = valor;
		}
		
		public String getController(){
			return this.controller;
		}
		
		public String getUri() {
			return this.uri;
		}
	}

	public enum URL_BASE {
		SERVICIOS_SOCIAL_NETWORK("config.app.services.web"),
		SERVICIOS_WEB("config.app.servicios.web");

		private final String url;

		URL_BASE(String url) {
			this.url = url;
		}

		public String getUrl() {
			return url;
		}
	}
	
	public static enum LINK {
		ALBUM_LIST("album.list");

		private final String link;

		LINK(String link) {
			this.link = link;
		}

		public String getLink() {
			return link;
		}
	}

}