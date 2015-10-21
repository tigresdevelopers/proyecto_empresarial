package com.network.social.web.config;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;

/**
 * @author :Alexander Chavez Simbron
 * @date   :20/10/2015
 * @time   :13:18:13
 */
public class HibernateAwareObjectMapper extends ObjectMapper {
	private static final long serialVersionUID = 1L;

	   public HibernateAwareObjectMapper() {
	        configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
	        configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
	        
	        registerModule(getHibernate4Module());
	    }

	    private Module getHibernate4Module() {
	        Hibernate4Module hibernateModule = new Hibernate4Module();
	        hibernateModule.enable(Hibernate4Module.Feature.FORCE_LAZY_LOADING);
	        return hibernateModule;
	    }
}
