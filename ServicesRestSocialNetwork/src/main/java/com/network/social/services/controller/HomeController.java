package com.network.social.services.controller;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.network.social.domain.bean.Rol;
import com.network.social.domain.util.ResultObject;
import com.network.social.domain.util.UtilUser;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
		
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value="/security/authenticate/rol/{username}",method=RequestMethod.GET)
	public @ResponseBody List<Rol> getRoles(@PathVariable String username){

		List<Rol> roles=new ArrayList<Rol>();
		Rol x=new Rol(1, "Usuario");
		Rol y=new Rol(1, "Admin");
		roles.add(x);
		roles.add(y);
		
		if (username.equals(UtilUser.USERNAME)) {
			return roles;
		}
		
		return null;
	}
	
	@RequestMapping(value="/security/authenticate/user/{username}",method=RequestMethod.GET)
	public @ResponseBody ResultObject getUser(@PathVariable String username){
		
		ResultObject obj=new ResultObject();
		
		if (username.equals(UtilUser.USERNAME)) {
			List<Map<String, Object>> data=new ArrayList<>();
			Map<String, Object> map=new LinkedHashMap<>();
			map.put("email",UtilUser.USERNAME);
			map.put("clave",UtilUser.PASSWORD);
			map.put("roles", UtilUser.ROLES);
			data.add(map);
			
			obj.setData(data);
		}else{
			obj=null;
		}
		return obj;
	}
	
	
	@RequestMapping(value="/json",method=RequestMethod.GET)
	public @ResponseBody ResultObject getobject(){
		ResultObject obj=new ResultObject();
		
		List<Map<String, Object>> data=new ArrayList<>();
		Map<String, Object> map=new LinkedHashMap<>();
		map.put("usuario", "Alexander Chavez Simbron");
		map.put("clave", "123");
		data.add(map);
		map=new LinkedHashMap<>();
		map.put("usuario", "Diego Santos Celestino");
		map.put("clave", "123");
		data.add(map);
		map=new LinkedHashMap<>();
		map.put("usuario", "Domenika Chavez Chavez");
		map.put("clave", "123");
		data.add(map);
		
		obj.setData(data);
		
		return obj;
	}
	
	
}
