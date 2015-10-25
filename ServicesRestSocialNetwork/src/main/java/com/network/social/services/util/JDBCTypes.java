package com.network.social.services.util;
/**
 * @author : Alexander Chavez Simbron
 * @date   :16/10/2015
 * @time   :16:02 pm
 * 
 */
public class JDBCTypes {

	public static enum VARCHAR_TYPES{
		
		VARCHAR2("VARCHAR2"),
		VARCHAR("VARCHAR"),
		CHAR("CHAR"),
		TEXT("TEXT"),
		CHARACTER_VARYING("CHARACTER VARYING"),
		LONGVARCHAR("LONGVARCHAR");
		
		private final String type;
		
		private VARCHAR_TYPES(String type){
			this.type=type;
		};
		
		public String getType(){
			return this.type;
		}
		
	}
	
	public static enum INTEGER_TYPES{
		
		NUMBER("NUMBER"),
		NUMERIC("NUMERIC"),
		DECIMAL("DECIMAL"),
		BIT("BIT"),
		TINYINT("TINYINT"),
		SMALLINT("SMALLINT"),
		INT("INT"),
		INTEGER("INTEGER"),
		BIGINT("BIGINT"),
		REAL("REAL"),
		FLOAT("FLOAT"),
		DOUBLE("DOUBLE"),
		SERIAL("SERIAL"),
		INT4("INT4");
		
		private final String type;
		
		private INTEGER_TYPES(String type) {
			this.type=type;
		}
		
		public String getType(){
			return this.type;
		}
	}
	
	public static enum DATE_TYPES{
		
		DATE("DATE"),
		DATETIME("DATETIME"),
		TIME("TIME"),
		TIMESTAMP("TIMESTAMP");
		
		private final String type;
		
		private DATE_TYPES(String type) {
			this.type=type;
		}
		
		public String getType(){
			return this.type;
		}
	}
		
	public static enum BOOLEAN_TYPES{
		
		BOOLEAN("BOOLEAN"),
		BOOL("BOOL");
		
		private final String type;
		
		private BOOLEAN_TYPES(String type) {
			this.type=type;
		}
		
		public String getType(){
			return this.type;
		}
	}
	

}
