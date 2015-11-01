package com.network.social.domain.entities;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/**
 * 
 * @author :Alexander Chavez Simbron
 * @date   :19/10/2015
 * @time   :17:25 P.M
 */
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class BaseBean  implements Serializable {
	private static final long serialVersionUID = 1L;

	
	
}
