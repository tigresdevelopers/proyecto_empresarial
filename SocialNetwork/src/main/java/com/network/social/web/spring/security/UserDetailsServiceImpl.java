package com.network.social.web.spring.security;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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

import com.network.social.domain.bean.Rol;
import com.network.social.domain.entities.Usuario;
import com.network.social.domain.util.ResultObject;
import com.network.social.web.config.PropiedadAdmin;
import com.network.social.web.spring.util.AdminConfigPropiedad.URI;
import com.network.social.web.spring.util.SpringUser;


@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

	private static Logger LOGGER = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

	private @Autowired RestTemplate restTemplate;
	
	private @Autowired PropiedadAdmin propiedadAdmin;

	@SuppressWarnings("unchecked")
	@Override
	public UserDetails loadUserByUsername(@RequestParam String username) throws UsernameNotFoundException {
		LOGGER.info("##userDetailsService.loadUserByUsername:"+username);
		
		try {
			Usuario usuario=null;
			Set<Rol> roles=null;
			List<LinkedHashMap<String, Object>> rolex=new ArrayList<>();
			
			String url=propiedadAdmin.getURIServiceAdmin(URI.SERVICE_ACCESO_OBTENER_USUARIO);

			usuario=new Usuario();
			usuario.setEmail(username);
			ResultObject obj=restTemplate.postForObject(url,new HttpEntity<Usuario>(usuario),ResultObject.class);
			
			if (obj!=null) {
				for (Map<String, Object> map : obj.getData()){ 
					usuario=new Usuario();
					usuario.setEmail(map.get("email").toString());
					usuario.setClave(map.get("clave").toString());
					rolex=(List<LinkedHashMap<String, Object>>) map.get("roles");
				}
				roles=new HashSet<>(0);
				for (LinkedHashMap<String, Object> entity :rolex) {
					roles.add(new Rol(Integer.parseInt(entity.get("id").toString()),entity.get("descripcion").toString()));
					
				}
				
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

	private List<GrantedAuthority> buildUserAuthority(Set<Rol> roles){
		
		Set<GrantedAuthority> setAuths=new HashSet<GrantedAuthority>(0);
		
		for (Rol rol : roles) {
			setAuths.add(new SimpleGrantedAuthority("ROLE_"+rol.getDescripcion()));
		}
		
		List<GrantedAuthority> result=new ArrayList<GrantedAuthority>(setAuths);
		
		return result;
	}
	
}
