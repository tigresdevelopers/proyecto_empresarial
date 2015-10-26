package com.network.social.web.config;
/**
* @author : Alexander Chavez Simbron
* @date   : 18 de oct. de 2015
* @time   : 11:12:46 p. m.
*/
public class UtilEnum {

	
	public static enum ESTADO_OPERACION{
		CORRECTO(100),
		EXITO(0),
		ERROR(1),
		EXCEPTION(10),
		TRANSACCION_SIN_REGISTROS(20),
		TRANSACCION_NO_PROCESADO(50),
		TRANSACCION_YA_EXISTE(51),
		TRANSACCION_NO_AUTORIZADO(55),
		CODIGO_OPERACION_NO_ACTUALIZADO(60),
		RESERVA_VUELO_NO_REALIZADA(70),
		RESERVA_PAQUETE_NO_REALIZADA(90),//paquete_no_realizada
		REGISTRO_VENTA_NO_REALIZADO(80),
		DESCUENTO_NO_APLICA(91),
		COMERCIO_NO_ASIGNADO_A_POS(101), 
		SEGMENTO_NO_ASIGNADO(121),
		PERIODO_ANUAL_YA_EXISTE(131),
		USUARIO_NO_AUTORIZADO(201),
		ERROR_DATOS_FORMULARIO(499),
		ERROR_REGISTRO_CON_HIJO(500);
		
		private final int codigo;
		
		private ESTADO_OPERACION(int estado){
			this.codigo = estado;
		}
		public int getCodigo() {
			return codigo;
		}
	}
	
}


