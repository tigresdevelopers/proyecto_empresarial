package com.network.social.services.util;

public class UtilEnum {
	
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
	
	public static enum TIPO_BENEFICIO{
		DESCUENTO(1,"DESCUENTO","msg.catalogo.descuentos"),
		CATALAGO(2,"CATALAGO","msg.catalogo.productos"),
		CAMPANIA(3,"CAMPANIA","msg.catalogo.campania"),
		EXPERIENCIA(4,"EXPERIENCIA","msg.catalogo.experiencia");
		
		private final int codigo;
		private final String  texto;
		private final String keyMsg;
		private TIPO_BENEFICIO(int codigo, String texto, String keyMsg){
			this.codigo = codigo;
			this.texto = texto;
			this.keyMsg= keyMsg;
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
	
	public static enum TIPO_WISHLIST{
		CATALOGO(1,"CATALOGO");		
		private final int codigo;
		private final String  texto;
		private TIPO_WISHLIST(int codigo, String texto){
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
	public static enum TIPO_SEGMENTO{
		GENERAL(1,"General"),
		CAMPANIA(2,"Campania");
		private final int codigo;
		private final String  texto;
		private TIPO_SEGMENTO(int codigo, String texto){
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
	
	public static enum CATALAGO_ESTADO_PEDIDO{
		
		//RECIBIDO(1,"_pendingApproval","Pendiente Pedido");
		//CONFIRMACION_STOCK(2,"_pendingFulfillment","Pedido parcialmente aprobado")
		//Guia remision
		//Listo para despacho -en ruta
		//reprogramado
		//Cancelacion pedido  
		//entregado
		
		RECIBIDO(1,"_pendingApproval","Aprobación pendiente"),
		CONFIRMACION_STOCK(2,"_pendingFulfillment","Ejecución del pedido pendiente"),
		GUIA_REMISION(3,"_partiallyFulfilled","Parcialmente completado"),
		LISTO_DESPACHO_EN_RUTA(4,"_pendingBillingPartFulfilled","Facturación pendiente/parcialmente ejecutada"),
		REPROGRAMADO(5,"_pendingBilling","Facturación pendiente"),
		CANCELADO(6,"_cancelled","Cancelado"),
		ENTREGADO(7,"_closed","Cerrado");
		
		private final Integer id;
		private final String codigo;
		private final String texto;
		
		private CATALAGO_ESTADO_PEDIDO(Integer id,String codigo,String texto){
			this.id=id;
			this.codigo=codigo;
			this.texto=texto;
		}
		
		public static Integer getIdByTexto(String texto){
			Integer strCodigoReturn=null;
			UtilEnum.CATALAGO_ESTADO_PEDIDO[] valores = CATALAGO_ESTADO_PEDIDO.values();
			for(int i=0; i<valores.length; i++){
				if(valores[i].getTexto().equals(texto)){
					strCodigoReturn=valores[i].getId();
					break;
				}
			}
			return strCodigoReturn;
		}
		
		public static String getCodigoByTexto(String texto){
			String strCodigoReturn=null;
			UtilEnum.CATALAGO_ESTADO_PEDIDO[] valores = CATALAGO_ESTADO_PEDIDO.values();
			for(int i=0; i<valores.length; i++){
				if(valores[i].getTexto().equals(texto)){
					strCodigoReturn=valores[i].getCodigo();
					break;
				}
			}
			return strCodigoReturn;
		}

		public Integer getId() {
			return id;
		}

		public String getCodigo() {
			return codigo;
		}

		public String getTexto() {
			return texto;
		}
		
	}
	
	public static enum TIPO_OPERACION_PUNTOS {
		CATALOGO(1, "CATALOGO"), DESCUENTO(2, "DESCUENTO");
		private final int codigo;
		private final String texto;

		private TIPO_OPERACION_PUNTOS(int codigo, String texto) {
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
	
	public static enum TIPO_CATEGORIA {
		PRODUCTO(1, "PRODUCTO"),
		MARCA(2, "MARCA"),
		PAQUETE(4, "PAQUETE");
		
		private final Integer codigo;
		private final String texto;
		
		private TIPO_CATEGORIA(Integer codigo, String texto) {
			this.codigo = codigo;
			this.texto = texto;
		}
		
		public Integer getCodigo() {
			return codigo;
		}
		
		public String getTexto() {
			return texto;
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
	
	public static enum TIPO_VENTA{
		CATALOGO_PRODUCTO(1,"CATALOGO PRODUCTO"),
		DESCUENTO(2,"DESCUENTO"),
		VUELO(3,"VUELOS"),
		PAQUETE(4,"PAQUETE");
		
		private final int codigo;
		private final String texto;
		
		private TIPO_VENTA(int codigo, String texto){
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
	
	public static enum TIPO_TRAKING{
		CATALOGO(1,"CATALOGO"),
		DESCUENTO(2,"DESCUENTO"),
		VUELO(3,"VUELOS"),
		PAQUETE(4,"PAQUETE"),
		CATEGORIA(11,"CATEGORIA");
		
		private final int codigo;
		private final String texto;
		
		private TIPO_TRAKING(int codigo, String texto){
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
	
	/*Tipo de descuento*/
	
	public static enum TIPO_DESCUENTO{
		SUBVENCIONADO(1,"SUBVENCIONADO"),
		NOSUBVENCIONADO(2,"NOSUBVENCIONADO");
		
		private final int codigo;
		private final String texto;
		
		private TIPO_DESCUENTO(int codigo, String texto){
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
	
	public static enum ESTADO_VENTA{
		PENDIENTE_PRODUCTO(101,""),
		PENDIENTE_VUELOS(121,""),
		PENDIENTE_PAQUETE(131,""),
		PENDIENTE_DESCUENTO(141,""),
		
		CONFIRMADO_PRODUCTO(301,""),
		CONFIRMADO_VUELOS(321,""),
		CONFIRMADO_PAQUETE(331,""),
		CONFIRMADO_DESCUENTO(341,""),
		
		ANULADO_PRODUCTO(501,""),
		ANULADO_VUELOS(521,""),
		ANULADO_PAQUETE(531,""),
		ANULADO_DESCUENTO(541,"");
		
		private final int codigo;
		private final String texto;
		
		private ESTADO_VENTA(int codigo, String texto){
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
	
	public static enum ORIGEN_REGISTRO_CLIENTE{
		WEB(1,"Web"),
		FACEBOOK(2,"Facebook"),
		YOUTUBE(3,"Youtube"),
		GOOGLE(4,"Google"),
		APPMOVIL_POSVIRTUAL(6,"App Movil Pos Virtual"),
		APPMOVIL_IOS(7,"App Movil IOS"),
		API_MERCHAN(8,"Api Merchan"),
		API_WEB_SERVICE(9,"Api Web Service"),
		APPIPAD_CINEMARK(11,"App Ipad Cinemark"),
		POS_COMERCIO(12,"Pos Comercio");
		
		private final int codigo;
		private final String texto;

		public int getCodigo() {
			return codigo;
		}
		
		public String getTexto() {
			return texto;
		}
		private ORIGEN_REGISTRO_CLIENTE(int codigo, String texto) {
			this.codigo = codigo;
			this.texto =  texto;
		}
	}
	
	public static enum UBIGEO_NIVEL{
		PAIS(1),
		DEPARTAMENTO(2),
		PROVINCIA(3),
		DISTRITO(4);
		
		private final int codigo;
		
		public int getCodigo() {
			return codigo;
		}
		
		private UBIGEO_NIVEL(int codigo) {
			this.codigo = codigo;
		}
		
	}		
	public static enum USUARIO_APLICACION{
		NETSUITE(1,"Usuario NetSuite"),
		CLIENTE_WEB(2,"Cliente Web"),
		ADMIN_WEB(3,"Admin Web");
		
		private Integer codigo;
		private String descripcion;
		
		public Integer getCodigo() {
			return codigo;
		}

		public void setCodigo(Integer codigo) {
			this.codigo = codigo;
		}

		public String getDescripcion() {
			return descripcion;
		}

		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}

		private USUARIO_APLICACION(Integer codigo,String descripcion) {
			this.codigo=codigo;
			this.descripcion=descripcion;
		}
	}
	
	public static enum CATALOGO_PRODUCTO_ORDERBY {
		MENOR_PRECIO("PRECIO_CATALOGO_ASC", "Menor Precio"),
		MAYOR_PRECIO("PRECIO_CATALOGO_DESC", "Mayor Precio"),
		NOMBRE_A_Z ("NOMBRE_CATALOGO_ASC", "Nombre A-Z");
		
		private final String codigo;
		private final String texto;
		
		private CATALOGO_PRODUCTO_ORDERBY(String codigo, String texto) {
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

	public static enum DELIVERY_TIPO_CALLE{
		AVENIDA("Avenida"),
		JIRON("Jiron");
		
		private final String codigo;
		
		private DELIVERY_TIPO_CALLE(String codigo){
			this.codigo = codigo;
		}
		public String getCodigo() {
			return codigo;
		}
	}

	public static enum DELIVERY_HORARIO_ENTREGA{
		MANHANA("Durante la mañana"),
		TARDE("Durante la tarde");
		
		private final String codigo;
		
		private DELIVERY_HORARIO_ENTREGA(String codigo){
			this.codigo = codigo;
		}
		public String getCodigo() {
			return codigo;
		}
	}
	
	public static enum DELIVERY_TIPO_ENTREGA{
		EXPRESS("Express"),
		REGULAR("Regular");
		
		private final String codigo;
		
		private DELIVERY_TIPO_ENTREGA(String codigo){
			this.codigo = codigo;
		}
		public String getCodigo() {
			return codigo;
		}
	}
	
	public static enum TIPO_MONEDA{
		
		PERU("pen","soles"),
		EEUU("usd","dolares");
		
		private final String codigo;
		private final String descripcion;
		
		private TIPO_MONEDA(String codigo,String descripcion){
			this.codigo=codigo;
			this.descripcion=descripcion;
		}

		public String getCodigo() {
			return codigo;
		}

		public String getDescripcion() {
			return descripcion;
		}
		
	}
	
	public static enum TIPO_PERIODO{
		ANUAL(1,"PERIODO ANUAL"),
		CAMPANIA(2,"PERIODO CAMPANIA");
		private final int codigo;
		private final String  texto;
		private TIPO_PERIODO(int codigo, String texto){
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
	
	public static enum ESTADO_RECLAMO{
		ABIERTO(1,"Abierto"),
		CERRADO(2,"Cerrado"),
		DEVUELTO(3,"Devuelto");
		
		private final int codigo;
		private final String  texto;
		private ESTADO_RECLAMO(int codigo, String texto){
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
	public static enum RESPUESTA_SERVICIO{
		EXITO(1,"EXITO"),
		ERROR_PROCESAR(2,"ERROR_PROCESAR"),
		ERROR_LLAMADO(2,"ERROR_LLAMADO"),
		ERROR_URL_NO_ENCONTRADA(2,"ERROR_URL_NO_ENCONTRADA");

		
		private final Integer codigo;
		private final String texto;
		
		private RESPUESTA_SERVICIO(Integer codigo, String texto){
			this.codigo = codigo;
			this.texto = texto;
		}
		
		public Integer getCodigo() {
			return codigo;
		}

		public String getTexto() {
			return texto;
		}
		
	}

	
	public static enum TIPO_VUELO_COSTAMAR{
		VUELO_IDA(0,"VUELO_IDA"),
		
		VUELO_REGRESO(1,"VUELO_REGRESO");
				
		private final Integer codigo;
		private final String texto;
		
		private TIPO_VUELO_COSTAMAR(Integer codigo, String texto){
			this.codigo = codigo;
			this.texto = texto;
		}
		
		public Integer getCodigo() {
			return codigo;
		}

		public String getTexto() {
			return texto;
		}
		
	}
	public static enum TIPO_COMENTARIO{
		RESUMEN(1,"RESUMEN","msg.resumen"),
		PERIODO(2,"PERIODO","msg.periodo"),
		SEGMENTO(3,"SEGMENTO","msg.segmento"),
		CATALOGO_PRODUCTO(4,"CATALOGO PRODUCTO","msg.catalogo.producto"),
		CATALOGO_DESCUENTO(5,"CATALOGO DESCUENTO","msg.catalogo.descuento");
		
		private final int codigo;
		private final String  texto;
		private final String keyMsg;
		private TIPO_COMENTARIO(int codigo, String texto, String keyMsg){
			this.codigo = codigo;
			this.texto = texto;
			this.keyMsg= keyMsg;
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
	
	public static enum TIPO_AGRUPADOR {
		PRODUCTO(1, "PRODUCTO");
		
		private final int codigo;
		private final String texto;
		
		private TIPO_AGRUPADOR(int codigo, String texto) {
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
	
	public static enum TIPO_USUARIO{
		PLAZAPOINTS(1,"PlazaPoints"),
		MOTIVA(2,"Motiva"),
		INTERBANK(3,"Interbank"),
		CLIENTE(5,"Cliente");
		private final int codigo;
		private final String texto;
		
		private TIPO_USUARIO(int codigo, String texto) {
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
	
	public static enum RESPUESTA_RESERVA_COSTAMAR{
		SEGMENTO_CANCELADO(0,"SEGMENTO_CANCELADO"),		
		RESERVADO(1,"RESERVADO"),
		PROBLEMAS_CONEXION_PROVEEDOR(2,"PROBLEMAS_CONEXION_PROVEEDOR"),
		RESERVA_DUPLICADA(3,"RESERVA_DUPLICADA"),
		DATOS_INCORRECTOS(6,"DATOS_INCORRECTOS"),
		ERROR_PROCESO_RESERVA(7,"ERROR_PROCESO_RESERVA");

				
		private final Integer codigo;
		private final String texto;
		
		private RESPUESTA_RESERVA_COSTAMAR(Integer codigo, String texto){
			this.codigo = codigo;
			this.texto = texto;
		}
		
		public Integer getCodigo() {
			return codigo;
		}

		public String getTexto() {
			return texto;
		}
	}
	
	public static enum TIPO_POS{
		VISA(1,"Visa"),
		MASTERCARD(2,"Mastercard");
		private final Integer codigo;
		private final String texto;
		
		private TIPO_POS(int codigo, String texto) {
			this.codigo = codigo;
			this.texto = texto;
		}
		
		public Integer getCodigo() {
			return codigo;
		}
		
		public String getTexto() {
			return texto;
		}
	}
	public static enum TIPO_ENTIDAD{
		USUARIO(1,"USUARIO"),
		CLIENTE(2,"CLIENTE");
		private final int codigo;
		private final String texto;
		
		private TIPO_ENTIDAD(int codigo, String texto) {
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

	public static enum CUENTA_EMAIL{
		INVITACION(1),
		FEEDBACK(2),
		INFO(3),
		EMPRESA(4),
		CONTACTO(5)
		;
		private final int codigo;
		
		public int getCodigo() {
			return codigo;
		}
		private CUENTA_EMAIL(int codigo) {
			this.codigo = codigo;
		}
		
	}
	
	public static enum PLANTILLA_EMAIL{
		CONSTANCIA_CANJE(1,"CONS-mail-canje.ftl","config.ruta.plantilla.email"),
		CONSTANCIA_PAQUETE(1,"CONS-mail-reserva-paquete.ftl","config.ruta.plantilla.email.reserva.paquete"),		
		CONSTANCIA_VIAJE(1,"CONS-mail-viajes.ftl","config.ruta.plantilla.email"),
		CONSTANCIA_OPORTUNIDAD(1,"CONS-mail-oportunidad.ftl","config.ruta.plantilla.email");		
		private final int codigo;
		private final String  nombre;
		private final String  ruta;
		
		private PLANTILLA_EMAIL(int codigo, String nombre, String ruta){
			this.codigo = codigo;
			this.nombre = nombre;
			this.ruta = ruta;
		}
		
		public int getCodigo() {
			return codigo;
		}
		public String getNombre (){
			return nombre;
		}
		public String getRuta(){
			return ruta;
		}
		
	}
	
	
	public static enum ASUNTO_EMAIL{
		CONFIRMACION_PEDIDO(1,"Confirmacion de pedido"),
		CONFIRMACION_RESERVA_PAQUETE(2,"Confirmacion de reserva de paquete");
		
		private final int codigo;
		private final String  texto;
		
		private ASUNTO_EMAIL(int codigo, String texto){
			this.codigo = codigo;
			this.texto = texto;
		}
		
		public int getCodigo() {
			return codigo;
		}
		public String getTexto (){
			return texto;
		}
	}
}
