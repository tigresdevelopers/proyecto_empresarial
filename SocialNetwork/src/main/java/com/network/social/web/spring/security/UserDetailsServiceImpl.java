package com.network.social.web.spring.security;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.network.social.domain.entities.Usuario;
import com.network.social.domain.util.form.RolForm;
import com.network.social.domain.util.form.UsuarioForm;
import com.network.social.web.config.PropiedadAdmin;
import com.network.social.web.spring.util.AdminConfigPropiedad.URI;
import com.network.social.web.spring.util.SpringUser;


@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

	private static Logger LOGGER = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

	private @Autowired RestTemplate restTemplate;
	
	private @Autowired PropiedadAdmin propiedadAdmin;

	@Override
	public UserDetails loadUserByUsername(@RequestParam String username) throws UsernameNotFoundException {
		LOGGER.info("##userDetailsService.loadUserByUsername:"+username);
		
		try {
			Usuario usuario=null;
			Set<RolForm> roles=null;
			String url=propiedadAdmin.getURIServiceAdmin(URI.SERVICE_ACCESO_OBTENER_USUARIO);

			usuario=new Usuario();
			usuario.setEmail(username);
			UsuarioForm usuarioForm=restTemplate.postForObject(url, new HttpEntity<Usuario>(usuario),UsuarioForm.class);
	
			if(usuarioForm!=null){
				usuario=new Usuario();
				usuario.setEmail(usuarioForm.getEmail());
				usuario.setClave(usuarioForm.getClave());
				roles=usuarioForm.getRoles();
				
				List<GrantedAuthority> authorities=buildUserAuthority(roles);
				
				return buildUserForAuthentication(usuario, authorities);
				
			}else
				throw new BadCredentialsException("Username not found.");

		} catch (Exception e) {
			e.printStackTrace();
			throw new BadCredentialsException("Failed to login as " + username, e);
		}
	}

	
	private User buildUserForAuthentication(Usuario usuario,List<GrantedAuthority> authorities){
		boolean enabled = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;

		return new SpringUser(usuario, usuario.getEmail(), usuario.getClave(), enabled, accountNonExpired, credentialsNonExpired, accountNonLocked,authorities);
	}

	private List<GrantedAuthority> buildUserAuthority(Set<RolForm> roles){
		
		Set<GrantedAuthority> setAuths=new HashSet<GrantedAuthority>(0);
		
		for (RolForm rol : roles) {
			setAuths.add(new SimpleGrantedAuthority("ROLE_"+rol.getDescripcion()));
		}
		
		List<GrantedAuthority> result=new ArrayList<GrantedAuthority>(setAuths);
		
		return result;
	}
	
}
