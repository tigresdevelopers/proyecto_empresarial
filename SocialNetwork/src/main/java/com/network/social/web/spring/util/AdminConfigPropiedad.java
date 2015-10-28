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
		
		SERVICE_CONTACTO_CREATE("uri.service.contacto","uri.service.create"),
		SERVICE_CONTACTO_UPDATE("uri.service.contacto","uri.service.update"),
		SERVICE_CONTACTO_DELETE("uri.service.contacto","uri.service.delete"),
		SERVICE_CONTACTO_FIND("uri.service.contacto","uri.service.find"),
		
		SERVICE_ETIQUETA_CREATE("uri.service.etiqueta","uri.service.create"),
		SERVICE_ETIQUETA_UPDATE("uri.service.etiqueta","uri.service.update"),
		SERVICE_ETIQUETA_DELETE("uri.service.etiqueta","uri.service.delete"),
		SERVICE_ETIQUETA_FIND("uri.service.etiqueta","uri.service.find"),
		
		SERVICE_GRUPO_CREATE("uri.service.grupo","uri.service.create"),
		SERVICE_GRUPO_UPDATE("uri.service.grupo","uri.service.update"),
		SERVICE_GRUPO_DELETE("uri.service.grupo","uri.service.delete"),
		SERVICE_GRUPO_FIND("uri.service.grupo","uri.service.find"),
		
		SERVICE_IDIOMA_CREATE("uri.service.idioma","uri.service.create"),
		SERVICE_IDIOMA_UPDATE("uri.service.idioma","uri.service.update"),
		SERVICE_IDIOMA_DELETE("uri.service.idioma","uri.service.delete"),
		SERVICE_IDIOMA_FIND("uri.service.idioma","uri.service.find"),
		
		SERVICE_LIKE_CREATE("uri.service.like","uri.service.create"),
		SERVICE_LIKE_UPDATE("uri.service.like","uri.service.update"),
		SERVICE_LIKE_DELETE("uri.service.like","uri.service.delete"),
		SERVICE_LIKE_FIND("uri.service.like","uri.service.find"),

		SERVICE_LISTA_CREATE("uri.service.listacontacto","uri.service.create"),
		SERVICE_LISTA_UPDATE("uri.service.listacontacto","uri.service.update"),
		SERVICE_LISTA_DELETE("uri.service.listacontacto","uri.service.delete"),
		SERVICE_LISTA_FIND("uri.service.listacontacto","uri.service.find"),
		
		
		SERVICE_NOTIFICACION_CREATE("uri.service.notificacion","uri.service.create"),
		SERVICE_NOTIFICACION_UPDATE("uri.service.notificacion","uri.service.update"),
		SERVICE_NOTIFICACION_DELETE("uri.service.notificacion","uri.service.delete"),
		SERVICE_NOTIFICACION_FIND("uri.service.notificacion","uri.service.find"),
		
		SERVICE_PUBLICACION_CREATE("uri.service.publicacion","uri.service.create"),
		SERVICE_PUBLICACION_UPDATE("uri.service.publicacion","uri.service.update"),
		SERVICE_PUBLICACION_DELETE("uri.service.publicacion","uri.service.delete"),
		SERVICE_PUBLICACION_FIND("uri.service.publicacion","uri.service.find"),
		
		SERVICE_SITUACION_CREATE("uri.service.situacion","uri.service.create"),
		SERVICE_SITUACION_UPDATE("uri.service.situacion","uri.service.update"),
		SERVICE_SITUACION_DELETE("uri.service.situacion","uri.service.delete"),
		SERVICE_SITUACION_FIND("uri.service.situacion","uri.service.find"),
		
		SERVICE_TIPO_CREATE("uri.service.tipocontacto","uri.service.create"),
		SERVICE_TIPO_UPDATE("uri.service.tipocontacto","uri.service.update"),
		SERVICE_TIPO_DELETE("uri.service.tipocontacto","uri.service.delete"),
		SERVICE_TIPO_FIND("uri.service.tipocontacto","uri.service.find"),
		
		SERVICE_GRUPOUSUARIO_CREATE("uri.service.grupousuario","uri.service.create"),
		SERVICE_GRUPOUSUARIO_UPDATE("uri.service.grupousuario","uri.service.update"),
		SERVICE_GRUPOUSUARIO_DELETE("uri.service.grupousuario","uri.service.delete"),
		
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