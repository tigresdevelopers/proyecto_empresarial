package com.network.social.web.spring.util;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.network.social.domain.entities.Usuario;

 /**
  * Project: Social Network
  * @author	: Alexander Chavez.
 */
public class SpringUser extends User {

	private static final long serialVersionUID = -3412180338469178220L;
	
	private Usuario usuario;

	public SpringUser(Usuario usuario, String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
		this.usuario = usuario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}	

}
