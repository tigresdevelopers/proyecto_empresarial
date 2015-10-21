package com.network.social.services.util;


public class RestURIConstants {
	
	public static final String GET_ALL="/list";
	public static final String GET_FILTERING="/list/filtering/{filter}";
	public static final String GET="/get{id}";
	public static final String POST="/create";
	public static final String PUT="/update";
	public static final String DELETE="/delete";
	
	public static final String ACTIVIDAD="actividad";
	public static final String ALBUM="album";
	public static final String COMENTARIO="comentario";
	public static final String CONTACTO="contacto";
	public static final String ETIQUETA="etiqueta";
	public static final String GRUPO="grupo";
	public static final String GRUPO_USUARIO="grupousuario";
	public static final String IDIOMA="idioma";
	public static final String LIKE="like";
	public static final String LISTA_CONTACTO="listacontacto";
	public static final String MULTIMEDIA="multimedia";
	public static final String NOTIFICACION="notificacion";
	public static final String PUBLICACION="publicacion";
	public static final String SITUACION="situacion";
	public static final String SOLICITUD="solicitud";
	public static final String TIPO_CONTACTO="tipocontacto";
	public static final String USUARIO="usuario";
	
	
	public static final String ALBUM_LIST_BY_USER="/list/{idusuario}";
	public static final String ALBUM_FIND="/find/{idalbum}";
	
	public static final String USUARIO_FIND_USERNAME="/find";
	
	public static final String MULTIMEDIA_BULKINSERT="/find";
	

}
