package com.network.social.domain.util;

import com.network.social.domain.entities.Rol;

/**
 * 
 * @author :Alexander Chavez Simbron
 * @date   :11/10/2015
 * @time   :08:32pm
 *
 */
public class UtilUser {

	public static final String USERNAME="leonxandercs";
	public static final String PASSWORD="$2a$10$iLRdgu/NIm/1UOZZvPeBn.XOdH.kcKOS1.C2kFiWkEdVbPsfEADZu";
	public static final Rol[] ROLES=new Rol[]{new Rol(1, "Usuario"),new Rol(2,"Admin")};
	public static final Rol[] ROLES_USER=new Rol[]{new Rol(1, "Usuario")};
	public static final Rol[] ROL_ADMIN=new Rol[]{new Rol(2, "Admin")};	
	
}
