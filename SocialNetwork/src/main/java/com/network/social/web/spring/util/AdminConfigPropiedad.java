package com.network.social.web.spring.util;

public class AdminConfigPropiedad {

	public enum URI {
		
		SERVICE_ACCESO_OBTENER_USUARIO("uri.service.usuario","uri.service.acceso.usuario.get"),
		
		SERVICE_USUARIO_CREATE("uri.service.usuario","uri.service.create"),
		SERVICE_USUARIO_UPDATE("uri.service.usuario","uri.service.update"),
		SERVICE_USUARIO_DELETE("uri.service.usuario","uri.service.delete"),
		SERVICE_USUARIO_FIND("uri.service.usuario","uri.service.find"),
		
		
		SERVICE_ALBUM_BY_USUARIO("album","uri.service.album.usuario"),
		SERVICE_ALBUM_CREATE("uri.service.album","uri.service.create"),
		SERVICE_ALBUM_UPDATE("uri.service.album","uri.service.update"),
		SERVICE_ALBUM_DELETE("uri.service.album","uri.service.delete"),
		SERVICE_ALBUM_FIND("uri.service.album","uri.service.find"),
		
		SERVICE_MULTIMEDIA_CREATE("uri.service.multimedia","uri.service.create"),
		SERVICE_MULTIMEDIA_UPDATE("uri.service.multimedia","uri.service.update"),
		SERVICE_MULTIMEDIA_DELETE("uri.service.multimedia","uri.service.delete"),
		SERVICE_MULTIMEDIA_FIND("uri.service.multimedia","uri.service.find"),
		
		SERVICE_COMENTARIO_CREATE("uri.service.comentario","uri.service.create"),
		SERVICE_COMENTARIO_UPDATE("uri.service.comentario","uri.service.update"),
		SERVICE_COMENTARIO_DELETE("uri.service.comentario","uri.service.delete"),
		SERVICE_COMENTARIO_FIND("uri.service.comentario","uri.service.find"),
		
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