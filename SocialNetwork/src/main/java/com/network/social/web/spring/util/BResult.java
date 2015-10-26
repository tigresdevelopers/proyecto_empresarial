package com.network.social.web.spring.util;

import com.network.social.web.form.BaseForm;

/**
* @author : Alexander Chavez Simbron
* @date   : 25 de oct. de 2015
* @time   : 12:32:06 p. m.
*/
public class BResult extends BaseForm{
	private static final long serialVersionUID = 1L;

	/*
	 * Objeto generico para clasificar estados
	 * Setea los datos genericos comunes para el cliente
	 * El bresult va a tyraer un resultado de alguna operacion realizada
	 */
	/*
	 * El estado operacion de UtilEnum.ESTADO_OPERACION
	 * */
	private Integer estado;
	
	private String mensaje;
	
	/*El id del objeto
	 * */
	private Integer codigo;
	
	private Object result;
	
	
	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public BResult(){
		
	}
	public BResult(Integer estado, Integer  codigo){
		this.estado = estado;
		this.codigo = codigo;
	}
	
	public BResult(Integer estado, Integer codigo,  String  mensaje){
		this.estado = estado;
		this.mensaje = mensaje;
		this.codigo =codigo;
	}
	
	public BResult(Integer estado, String  mensaje, Integer codigo, Object result  ){
		this.estado = estado;
		this.mensaje = mensaje;
		this.codigo =codigo;
		this.result = result;
	}
	
	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}
	
}


