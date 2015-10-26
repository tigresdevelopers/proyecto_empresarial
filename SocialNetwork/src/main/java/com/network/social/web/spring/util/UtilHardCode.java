package com.network.social.web.spring.util;

import com.network.social.web.form.AlbumForm;
import com.network.social.web.form.UsuarioForm;

/**
* @author : Alexander Chavez Simbron
* @date   : 18 de oct. de 2015
* @time   : 9:49:03 p. m.
*/
public class UtilHardCode{

	public static UsuarioForm usuario;
	public static AlbumForm  album;
	
	
	static{
		
		usuario=new UsuarioForm();
		usuario.setIdusuario(3);
		usuario.setNombre("Alexander");
		usuario.setEmail("leonxandercs");
		usuario.setClave("123456");
		usuario.setApePaterno("Chavez");
		usuario.setApeMaterno("Simbron");
		usuario.setEstado('1');
		

		album=new AlbumForm();
		album.setNombre("album prueba {hora}");
		album.setDescripcion("registro por post");
		album.setLikes(0);
		
	}
	
	
	
}


