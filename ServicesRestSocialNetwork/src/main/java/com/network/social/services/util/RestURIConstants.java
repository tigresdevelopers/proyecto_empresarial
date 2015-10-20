package com.network.social.services.util;


public class RestURIConstants {
	
	public static final String ALBUM="album";
	public static final String ALBUM_LIST_BY_USER="/list/{idusuario}";
	public static final String ALBUM_FIND="/find/{idalbum}";
	public static final String ALBUM_CREATE="/create";
	public static final String ALBUM_UPDATE="/update";
	public static final String ALBUM_DELETE="/delete";
	
	
	public static final String USUARIO="usuario";
	public static final String USUARIO_FIND_ID="/find/{idusuario}";
	public static final String USUARIO_FIND_USERNAME="/find";
	public static final String USUARIO_CREATE="/create";
	public static final String USUARIO_UPDATE="/update";
	public static final String USUARIO_DELETE="/delete";
	
	public static final String MULTIMEDIA="multimedia";
	public static final String MULTIMEDIA_FIND="/find/{idmultimedia}";
	public static final String MULTIMEDIA_BULKINSERT="/find";
	public static final String MULTIMEDIA_CREATE="/create";
	public static final String MULTIMEDIA_UPDATE="/update";
	public static final String MULTIMEDIA_DELETE="/delete";
	
	
	public static final String LOGIN = "/cliente/login/{dni}";
	public static final String REGISTRO = "/cliente/registro/{dni}/{email}/{telefono}";
	public static final String CATEGORIA = "/consulta/categoria/{dni}";
	public static final String CIUDAD = "/consulta/ciudad/{idpais}";
	public static final String DESTACADOS = "/consulta/destacado/{tipo}/{dni}/{idciudad}";
	public static final String LISTACUPONCATEGORIA = "/consulta/cupon/{tipo}/{dni}/{idcategoria}";
	
	public static final String DEMO = "/cliente/arreglo/{dni}";

}
