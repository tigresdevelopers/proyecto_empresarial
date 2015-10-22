package com.network.social.services.util;

public class DAOUtil {

	public static final String SP_LOGIN="usplogin(?,?)";
	
	public static enum SP_ORACLE{
		
		SP_LOGIN("usplogin(?,?)"),
		SP_PUBLICACION_USUARIO_TIPO(""),
		SP_PUBLICACION_USUARIO_LISTA("")
		;
		
		private final String procedure;
		
		private SP_ORACLE(String procedure) {
			this.procedure=procedure;
		}
		
		public String getProcedure(){
			return this.procedure;
		}
	}

	public static enum QUERY_HQL{
		
		USUARIO_BY_EMAIL("usuario.email","email"),
		USUARIO_CONTACTOS("usuario.contactos.usuario","idusuario"),
		ALBUM_USUARIO("album.usuario","idusuario"),
		ALBUM_GRUPO("album.grupo","idgrupo"),
		ACTIVIDAD_USUARIO("actividad.usuario"),
		COMENTARIO_MULTIMEDIA("comentario.multimedia","idmultimedia"),
		COMENTARIO_ALBUM("comentario.album","idalbum"),
		COMENTARIO_PUBLICACION("comentario.publicacion","idpublicacion"),
		COMENTARIO_COMENTARIO("comentario.comentario","idcomentario"),
		CONTACTO_USUARIO("contacto.usuario","idusuario"),
		ETIQUETA_MULTIMEDIA("etiqueta.multimedia","idmultimedia"),
		GRUPO_USUARIO("grupo.usuario","idusuario"),
		IDIOMA_USUARIO("idioma.usuario","idusuario"),
		LIKE_MULTIMEDIA("like.multimedia","idmultimedia"),
		LIKE_ALBUM("like.album","idalbum"),
		LIKE_PUBLICACION("like.publicacion","idpublicacion"),
		LIKE_COMENTARIO("like.comentario","idcomentario"),
		LISTACONTACTO_USUARIO("listacontacto.usuario","idusuario"),
		MULTIMEDIA_USUARIO("multimedia.usuario","idusuario"),
		MULTIMEDIA_ALBUM("multimedia.album","idalbum"),
		MULTIMEDIA_GRUPO("multimedia.grupo","idgrupo"),
		MULTIMEDIA_PUBLICACION("multimedia.publicacion","idpublicacion"),
		NOTIFICACION_USUARIO("notificacion.usuario","idusuario"),
		PUBLICACION_USUARIO("publicacion.usuario","idusuario"),
		PUBLICACION_GRUPO("publicacion.grupo","idgrupo"),
		SOLICITUD_USUARIO("solicitud.usuario","idusuario")
		;
		
		
		private final String query;
		private final String[] parameters;
		
		private QUERY_HQL(String query,String... parameters) {
			this.query=query;
			this.parameters=parameters;
		}
		
		public String getQuery(){
			return this.query;
		}
		public String[] getParameters(){
			return this.parameters;
		}
	}
	
	
}


