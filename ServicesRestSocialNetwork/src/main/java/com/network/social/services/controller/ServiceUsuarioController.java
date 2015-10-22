package com.network.social.services.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.network.social.domain.entities.Usuario;
import com.network.social.services.service.UsuarioService;

import static com.network.social.services.util.RestURIConstants.*;
/**
 * @author :Alexander Chavez Simbron
 * @date   :21/10/2015
 * @time   :16:24:21
 */
@RestController
@RequestMapping(value=USUARIO)
public class ServiceUsuarioController {

	@Autowired
    private UsuarioService usuarioService;
	
    @RequestMapping(value=USUARIO_FIND_USERNAME,method=RequestMethod.POST,consumes="application/json") 
    private @ResponseBody Usuario getByUsername(@RequestBody Usuario usuario){
  	 
     Usuario u=usuarioService.findByUsername(usuario.getEmail());
    if (u!=null) {
    	 u.setEmail(u.getEmail());
         u.setClave(u.getClave());
         u.setSituacionSentimental(u.getSituacionSentimental());
         System.out.println(u.getSituacionSentimental().getIdsituacion());
         u.roles=u.roles;
	}
     return u;
     
    }
	
    @RequestMapping(value=GET,method=RequestMethod.GET)
	private @ResponseBody Usuario get(@PathVariable Integer id){
		return usuarioService.findById(id);
	}
    
    @RequestMapping(value=GET_FILTERING,method=RequestMethod.GET)
   	private @ResponseBody List<Usuario> getAllbyUser(@PathVariable Integer filter){
   		return usuarioService.getAllbyUser(filter);
   	}
    
    @RequestMapping(value=GET_FILTERING_GROUP,method=RequestMethod.GET)
   	private @ResponseBody List<Usuario> getAllbyGrupo(@PathVariable Integer filter){
   		return usuarioService.getAllbyGrupo(filter);
   	}
    
    @RequestMapping(value=GET_FILTERING_LISTACONTACTO,method=RequestMethod.GET)
   	private @ResponseBody List<Usuario> getAllbyListaContacto(@PathVariable Integer id,@PathVariable Integer filter){
   		return usuarioService.getAllbyListaContacto(id,filter);
   	}
    
    @RequestMapping(value=GET_FILTERING_TIPOCONTACTO,method=RequestMethod.GET)
   	private @ResponseBody List<Usuario> getAllbyTipoContacto(@PathVariable Integer id,@PathVariable Integer filter){
   		return usuarioService.getAllbyTipoContacto(id,filter);
   	}
	@RequestMapping(value=GET_ALL,method=RequestMethod.GET)
	private @ResponseBody List<Usuario> getUsuarios(){
		return usuarioService.findAll();
	}
	
	
}
