package com.network.social.services.util;

public class UtilEnum {
	
	
	public static enum MESSAGES{
		
		PUBLICACION_GENERADA_ALBUM("label.publicacion.generada.album"),
		
		PUBLICACION_GENERADA_FOTO_UPDATE("label.publicacion.generada.foto.update"),
		PUBLICACION_GENERADA_FOTO("label.publicacion.generada.foto"),
		PUBLICACION_GENERADA_FOTOS("label.publicacion.generada.fotos"),
		
		PUBLICACION_SITUACION_UPDATE_USUARIO("publicacion.situacion.usuario"),
		PUBLICACION_CELULAR_UPDATE_USUARIO("publicacion.celular.usuario"),
		
		ACTIVIDAD_SITUACION_UPDATE_USUARIO("actividad.situacion.usuario"),
		ACTIVIDAD_CELULAR_UPDATE_USUARIO("actividad.situacion.usuario"),
		
		
		ACTIVIDAD_CREATE_ALBUM("actividad.album.create"),
		ACTIVIDAD_UPDATE_ALBUM("actividad.album.update"),
		ACTIVIDAD_DELETE_ALBUM("actividad.album.delete"),
		
		ACTIVIDAD_CREATE_COMENTARIO("actividad.comentario.create"),
		ACTIVIDAD_UPDATE_COMENTARIO("actividad.comentario.update"),
		ACTIVIDAD_DELETE_COMENTARIO("actividad.comentario.delete"),
		
		ACTIVIDAD_CREATE_CONTACTO("actividad.contacto.create"),
		ACTIVIDAD_UPDATE_CONTACTO("actividad.contacto.update"),
		ACTIVIDAD_DELETE_CONTACTO("actividad.contacto.delete"),
		
		ACTIVIDAD_CREATE_ETIQUETA("actividad.etiqueta.create"),
		ACTIVIDAD_UPDATE_ETIQUETA("actividad.etiqueta.update"),
		ACTIVIDAD_DELETE_ETIQUETA("actividad.etiqueta.delete"),
		
		ACTIVIDAD_CREATE_GRUPO("actividad.grupo.create"),
		ACTIVIDAD_UPDATE_GRUPO("actividad.grupo.update"),
		ACTIVIDAD_DELETE_GRUPO("actividad.grupo.delete"),
		
		ACTIVIDAD_CREATE_GRUPOUSU("actividad.grupousu.create"),
		ACTIVIDAD_UPDATE_GRUPOUSU("actividad.grupousu.update"),
		ACTIVIDAD_DELETE_GRUPOUSU("actividad.grupousu.delete"),
		
		ACTIVIDAD_CREATE_LIKE("actividad.like.create"),
		ACTIVIDAD_UPDATE_LIKE("actividad.like.update"),
		ACTIVIDAD_DELETE_LIKE("actividad.like.delete"),
		
		ACTIVIDAD_CREATE_LISTA("actividad.lista.create"),
		ACTIVIDAD_UPDATE_LISTA("actividad.lista.update"),
		ACTIVIDAD_DELETE_LISTA("actividad.lista.delete"),
		
		ACTIVIDAD_CREATE_MULTIMEDIA("actividad.multimedia.create"),
		ACTIVIDAD_UPDATE_MULTIMEDIA("actividad.multimedia.update"),
		ACTIVIDAD_DELETE_MULTIMEDIA("actividad.multimedia.delete"),
		
		ACTIVIDAD_CREATE_PUBLICACION("actividad.publicacion.create"),
		ACTIVIDAD_UPDATE_PUBLICACION("actividad.publicacion.update"),
		ACTIVIDAD_DELETE_PUBLICACION("actividad.publicacion.delete"),
		
		ACTIVIDAD_CREATE_SITUACION("actividad.situacion.create"),
		ACTIVIDAD_UPDATE_SITUACION("actividad.situacion.update"),
		ACTIVIDAD_DELETE_SITUACION("actividad.situacion.delete"),
		
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
	
	public static enum ESTADO_SOLICITUD{
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
		
		private ESTADO_SOLICITUD(int estado, String texto, String keyMsg){
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
		MASCULINO(0, "Masculino"),FEMENINO (1, "Femenino ");
		private final int codigo;
		private final String texto;
		
		private GENERO(int codigo, String texto) {
			this.codigo = codigo;
			this.texto = texto;
		}
		
		public int getCodigo() {
			return codigo;
		}
		
		public String getTexto() {
			return texto;
		}
	}

	
	
	
}
