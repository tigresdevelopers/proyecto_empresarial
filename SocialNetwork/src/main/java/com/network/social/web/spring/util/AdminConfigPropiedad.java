package com.network.social.web.spring.util;

public class AdminConfigPropiedad {

	public enum URI {
		
		SERVICE_ACCESO_OBTENER_USUARIO("uri.service.acceso.usuario.get"),
		SERVICE_ACCESO_OBTENER_ROLES("uri.service.acceso.obtenerRoles"),
		SERVICE_AMQ_MAIL_ENVIAR("uri.service.email.enviar"),
		SERVICE_VENTA_VENTABYID("uri.service.venta.ventaById");
		
		private final String uri;

		URI(String valor) {
			this.uri = valor;
		}

		public String getUri() {
			return uri;
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

}