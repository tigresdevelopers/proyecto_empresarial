package com.network.social.services.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.network.social.domain.entities.Usuario;
import com.network.social.domain.util.ResultObject;
import com.network.social.domain.util.UtilUser;
import com.network.social.services.service.UsuarioService;
import com.network.social.services.util.RestURIConstants;

@RestController
@RequestMapping(value="usuario")
public class ServiceUsuarioController {

	@Autowired
    private UsuarioService usuarioService;
	
	 @RequestMapping(value=RestURIConstants.USUARIO_FIND_USERNAME,method=RequestMethod.POST)
	 public @ResponseBody ResultObject getByUsername(@RequestBody Usuario
	 usuario){
	
	 ResultObject res=new ResultObject();
	 List<Map<String, Object>> data=new ArrayList<>();
	
	 Usuario u=usuarioService.findByUsername(usuario.getEmail());
	
	 if (u!=null) {
		 Map<String, Object> map=new LinkedHashMap<>();
		 map.put("email", u.getEmail());
		 map.put("clave", u.getClave());
		 map.put("roles",UtilUser.ROLES);
		 data.add(map);
		 res.setData(data);
	 }
	
	 return res;
	 }
	
}
