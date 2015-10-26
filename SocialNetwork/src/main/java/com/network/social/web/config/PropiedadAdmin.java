package com.network.social.web.config;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.network.social.web.spring.util.AdminConfigPropiedad.LINK;
import com.network.social.web.spring.util.AdminConfigPropiedad.URI;
import com.network.social.web.spring.util.AdminConfigPropiedad.URL_BASE;

/**
 * @author :Alexander Chavez Simbron
 * @date   :20/10/2015
 * @time   :13:18:13
 */
@Service("propiedadAdmin")
@PropertySources({ @PropertySource(value = "classpath:/configuration/configIP.properties", ignoreResourceNotFound = false),
	@PropertySource(value = "classpath:/configuration/configUri.properties", ignoreResourceNotFound = false),
	@PropertySource(value="classpath:/configuration/links/navigationLinks.properties",ignoreResourceNotFound=false)
})
public class PropiedadAdmin {

	private static Logger LOGGER = LoggerFactory.getLogger(PropiedadAdmin.class);

	@Autowired
	private Environment env;

	@Autowired
	private ServletContext context;

	@Autowired
	private Properties propertiesHome;

	public void init() {
		LOGGER.info("### init");
		Map<String, String> map = new HashMap<String, String>();
		for (final String key : propertiesHome.stringPropertyNames()) {
			LOGGER.info("### " + key + " : " + getProperty(key));
			map.put(key, getProperty(key));
			System.out.println(key+"_"+getProperty(key));
		}
		context.setAttribute("prop", map);
	}

	public String getProperty(String propName) {
		return env.getProperty(propName);
	}

	public String getURIServiceAdmin(URI uri) {
		return getProperty(URL_BASE.SERVICIOS_SOCIAL_NETWORK.getUrl())+getProperty(uri.getController())+getProperty(uri.getUri());
	}

	public String getURIServiceWeb(URI uri) {
		return getProperty(URL_BASE.SERVICIOS_WEB.getUrl()) + getProperty(uri.getUri());
	}
	
	public String getLinkUrl(LINK link){
		return getProperty(link.getLink());
	}
		
}
