package com.network.social.services.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.network.social.domain.entities.Usuario;
import com.network.social.services.service.UsuarioService;
import static com.network.social.services.util.RestURIConstants.*;


@RestController
@RequestMapping(value=USUARIO)
public class ServiceUsuarioController {

	@Autowired
    private UsuarioService usuarioService;
	
    @RequestMapping(value=USUARIO_FIND_USERNAME,method=RequestMethod.POST,consumes="application/json") 
    private @ResponseBody Usuario getByUsername(@RequestBody Usuario usuario){
  	 
     Usuario u=usuarioService.findByUsername(usuario.getEmail());
     u.setEmail(u.getEmail());
     u.setClave(u.getClave());
     u.setSituacionSentimental(u.getSituacionSentimental());
     System.out.println(u.getSituacionSentimental().getIdsituacion());
     u.roles=u.roles;
   
     return u;
     
    }
	
    
	
	@RequestMapping(value=GET_ALL,method=RequestMethod.GET)
	private @ResponseBody List<Usuario> getUsuarios(){
		return usuarioService.findAll();
	}
	
	
}
