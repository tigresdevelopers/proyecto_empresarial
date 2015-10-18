package com.network.social.services.util;

public class DAOUtil {

	public static final String SP_LOGIN="usplogin(?,?)";
	
	public static enum SP_ORACLE{
		
		SP_LOGIN("usplogin(?,?)");
		
		private final String procedure;
		
		private SP_ORACLE(String procedure) {
			this.procedure=procedure;
		}
		
		public String getProcedure(){
			return this.procedure;
		}
	}

	public static enum QUERY_HQL{
		
		USUARIO_BY_EMAIL("usuario.email","email"),
		ALBUM_USUARIO("album.usuario","idusuario");
		
		private final String query;
		private final String[] parameters;
		
		private QUERY_HQL(String query,String... parameters) {
			this.query=query;
			this.parameters=parameters;
		}
		
		public String getQuery(){
			return this.query;
		}
		public String[] getParameters(){
			return this.parameters;
		}
	}
	
	
}


