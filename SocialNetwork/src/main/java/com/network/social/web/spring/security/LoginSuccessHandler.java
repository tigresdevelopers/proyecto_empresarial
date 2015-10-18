package com.network.social.web.spring.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.network.social.web.spring.util.SpringUser;

 /**
  * Proyecto: AdminSaas
  * @date	: 9/6/2015
  * @time	: 18:11:38
  * @author	: Alexander Chavez.
 */
@Component("LoginSuccessHandler")
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
	private static Logger LOGGER = LoggerFactory.getLogger(LoginSuccessHandler.class);
	
	
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws ServletException, IOException {
		LOGGER.info("INVOKE SUCCESS HANDLER"); 
		
		SpringUser user= (SpringUser) authentication.getPrincipal();
		LOGGER.info("## USER LOGIN:"+user.getUsername());
//		UtilWeb.setUsuarioLogin(request,user.getUsuario());
		
		LOGGER.info("## LOAD PERIODO ACTUAL");
		//UtilWeb.setPeriodoActual(request,procesosComun.obtenerActualPeriodo());
		
		LOGGER.info("## SETER ANIO");
		//UtilWeb.setAnioInicioPeriodo(request,procesosComun.obtenerAnioInicioPeriodo());
		
		LOGGER.info("## LOAD DATA MENUS");
		//UtilWeb.cargarMenuOperaciones(request, procesosComun, user.getUsuario());
		//AKI CARGA MENUS
		LOGGER.info("FIN INVOKE SUCCESS HANDLER");
		super.onAuthenticationSuccess(request, response, authentication);
	}

}
