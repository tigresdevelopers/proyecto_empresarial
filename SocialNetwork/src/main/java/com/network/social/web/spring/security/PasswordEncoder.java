package com.network.social.web.spring.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
/**
 * @author :Alexander Chavez Simbron
 * @date   :20/10/2015
 * @time   :13:18:13
 */
public class PasswordEncoder {


	/**
	 * 
	 * @param  password -> password ah encriptar
	 * @return password encode in BCrypt de Spring provider
	 */
	public static String encodePassword(String password){
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		return  passwordEncoder.encode(password);
	}
	
	/**
	 * 
	 * @param rawpassword     -> password a evaluar
	 * @param encodedPassword -> password encriptada
	 * @return true|false 
	 */
	public static boolean evalPassword(String rawpassword,String encodedPassword){
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		return passwordEncoder.matches(rawpassword,encodedPassword);
	}
	
	
	public static void main(String[] args) {
		int i = 0;
		//$2a$10$iLRdgu/NIm/1UOZZvPeBn.XOdH.kcKOS1.C2kFiWkEdVbPsfEADZu
		while (i < 10) {
			String password = "123456";
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String hashedPassword = passwordEncoder.encode(password);
	
			System.out.println(hashedPassword);
			System.out.println(PasswordEncoder.evalPassword(password,hashedPassword));
			
			i++;
		}
		
		
	}
}
