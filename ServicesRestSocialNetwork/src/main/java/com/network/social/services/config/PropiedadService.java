package com.network.social.services.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.network.social.services.util.DAOUtil;

@Service(value="propiedadService")
@PropertySources(@PropertySource(value="classpath:/configuration/queries.properties",ignoreResourceNotFound=true))
public class PropiedadService {

  @Autowired
  private Environment env;
  
  public String getProperty(String propName) {
		return env.getProperty(propName);
  }
  
  public String getQuery(DAOUtil.QUERY_HQL hql){
	  return this.getProperty(hql.getQuery());
  }
	
}
