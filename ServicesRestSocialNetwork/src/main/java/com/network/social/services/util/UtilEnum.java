package com.network.social.services.util;

public class UtilEnum {
	
	
	public static enum MESSAGES{
		PUBLICACION_GENERADA_FOTO_UPDATE("label.publicacion.generada.foto.update"),
		PUBLICACION_GENERADA_FOTO("label.publicacion.generada.foto"),
		PUBLICACION_GENERADA_FOTOS("label.publicacion.generada.fotos")
		;
		
		private String message;
		
		private MESSAGES(String message){
			this.message=message;
		}
		
		public String getMessage(){
			return this.message;
		}
	}
	
	public static enum ESTADO_OPERACION{
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
	
	public static enum ESTADO_REGISTRO_BASE{
		//transicion eliminado 
		ELIMINADO(0,"Eliminado",""),
		
		DESACTIVADO(1,"DESACTIVADO",""),
		
		//transicion rechazado o anulado
		RECHAZADO(2,"RECHAZADO","msg.estado.rechazado"),
		
		//transicion pendiente en confirmacion 
		PENDIENTE(51,"PENDIENTE",""),
		PENDIENTE_ABIERTO(52,"ABIERTO",""),
		
		//transicion confirmado cerrado
		CONFIRMADO(101,"CONFIRMADO",""),
		CONFIRMADO_CERRADO(102,"CERRADO","msg.estado.cerrado"),
		
		//transicion activo GO!!!!! 
		ACTIVO(201,"ACTIVO",""),
		ACTIVO_APROBADO(202,"","msg.estado.aprobado"),
		ACTIVO_DEVUELTO(203,"","");
		
		private final int codigo;
		private final String  texto;
		private final String keyMsg;
		
		private ESTADO_REGISTRO_BASE(int estado, String texto, String keyMsg){
			this.codigo = estado;
			this.texto=texto;
			this.keyMsg = keyMsg;
		}
		public int getCodigo() {
			return codigo;
		}
		public String getTexto() {
			return texto;
		}
		public String getKeyMsg() {
			return keyMsg;
		}
	}
	
	public static enum ACCION_MANTENIMIENTO{
		REGISTRAR(1),
		ACTUALIZAR(2),
		DESACTIVAR(3),
		ELIMINAR(0),
		ACTUALIZAR_ESTADO(4);
		private final int codigo;
		
		private ACCION_MANTENIMIENTO(int estado){
			this.codigo = estado;
		}
		public int getCodigo() {
			return codigo;
		}
	}
	
	public static enum EXCEPTION_DB{
		NO_PROCESADO(-1),
		PRIMARY_KEY_VIOLATION(-2),
		FOREING_KEY_VIOLATION(-3),
		UNIQUE_KEY_VIOLATION(-4),
		ERROR(-10);
		
		private final int codigo;
		
		public int getCodigo() {
			return codigo;
		}
		
		private EXCEPTION_DB(int codigo) {
			this.codigo = codigo;
		}
	}

	public static enum TIPO_DOCUMENTO {
		DNI(1, "DNI","ID"),PASAPORTE (2, "Pasaporte",""), CARNET_EXTRAJERIA(3,"CEX","");
		private final Integer codigo;
		private final String texto;
		private final String costamar;
		
		private TIPO_DOCUMENTO(Integer codigo, String texto,String costamar) {
			this.codigo = codigo;
			this.texto = texto;
			this.costamar=costamar;
		}
		
		public Integer getCodigo() {
			return codigo;
		}
		
		public String getTexto() {
			return texto;
		}

		public String getCostamar() {
			return costamar;
		}
	}
	
	public static enum GENERO {
		MASCULINO("M", "Masculino"),FEMENINO ("F", "Femenino ");
		private final String codigo;
		private final String texto;
		
		private GENERO(String codigo, String texto) {
			this.codigo = codigo;
			this.texto = texto;
		}
		
		public String getCodigo() {
			return codigo;
		}
		
		public String getTexto() {
			return texto;
		}
	}

	
	
	
}
