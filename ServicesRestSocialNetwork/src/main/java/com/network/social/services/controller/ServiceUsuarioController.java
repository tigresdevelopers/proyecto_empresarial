package com.network.social.services.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.network.social.domain.entities.Usuario;
import com.network.social.domain.util.UsuarioForm;
import com.network.social.services.service.UsuarioService;
import com.network.social.services.util.RestURIConstants;

@RestController
@RequestMapping(value="usuario")
public class ServiceUsuarioController {

	@Autowired
    private UsuarioService usuarioService;
	
    @RequestMapping(value=RestURIConstants.USUARIO_FIND_USERNAME,method=RequestMethod.POST)
    public @ResponseBody Usuario getByUsername(@RequestBody Usuario usuario){
  	 
     Usuario u=usuarioService.findByUsername(usuario.getEmail());
//     UsuarioForm usuarioForm=new UsuarioForm();
//     usuarioForm.setEmail(u.getEmail());
//     usuarioForm.setClave(u.getClave());
//     usuarioForm.setRoles(usuarioForm.getRoles());
   
     return u;
     
    }
	
}
