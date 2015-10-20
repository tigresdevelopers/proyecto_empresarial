package com.network.social.web.spring.util;

import com.network.social.domain.entities.Album;
import com.network.social.domain.entities.Usuario;

/**
* @author : Alexander Chavez Simbron
* @date   : 18 de oct. de 2015
* @time   : 9:49:03 p. m.
*/
public class UtilHardCode{

	public static Usuario usuario;
	public static Album album;
	
	
	static{
		
		usuario=new Usuario();
		usuario.setIdusuario(3);
		usuario.setNombre("Alexander");
		usuario.setEmail("leonxandercs");
		usuario.setClave("123456");
		usuario.setApePaterno("Chavez");
		usuario.setApeMaterno("Simbron");
		usuario.setEstado('1');
		

		album=new Album();
		album.setNombre("album prueba {hora}");
		album.setDescripcion("registro por post");
		album.setLikes(0);
		
	}
	
	
	
}


