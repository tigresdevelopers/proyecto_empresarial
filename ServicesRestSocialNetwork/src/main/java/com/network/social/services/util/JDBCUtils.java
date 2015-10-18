package com.network.social.services.util;

import java.sql.ResultSet;



public class JDBCUtils {

	public static Object fn_oColumnData(ResultSet oResultSet, String sColumnTypeName, int iColumnIndex) throws Exception {
		Object oColumnData = null;

		if (sColumnTypeName.equalsIgnoreCase("VARCHAR2") ||
			sColumnTypeName.equalsIgnoreCase("VARCHAR") ||
			sColumnTypeName.equalsIgnoreCase("CHAR") ||
			sColumnTypeName.equalsIgnoreCase("TEXT") ||
			sColumnTypeName.equalsIgnoreCase("CHARACTER VARYING") ||
			sColumnTypeName.equalsIgnoreCase("LONGVARCHAR")) {
			oColumnData = oResultSet.getString(iColumnIndex);
		}
		else if (sColumnTypeName.equalsIgnoreCase("NUMBER") ||
				 sColumnTypeName.equalsIgnoreCase("NUMERIC") ||
				 sColumnTypeName.equalsIgnoreCase("DECIMAL") ||
				 sColumnTypeName.equalsIgnoreCase("BIT") ||
				 sColumnTypeName.equalsIgnoreCase("TINYINT") ||
				 sColumnTypeName.equalsIgnoreCase("SMALLINT") ||
				 sColumnTypeName.equalsIgnoreCase("INT") ||
				 sColumnTypeName.equalsIgnoreCase("INTEGER") ||
				 sColumnTypeName.equalsIgnoreCase("BIGINT") ||
				 sColumnTypeName.equalsIgnoreCase("REAL") ||
				 sColumnTypeName.equalsIgnoreCase("FLOAT") ||
				 sColumnTypeName.equalsIgnoreCase("DOUBLE") ||
				 sColumnTypeName.equalsIgnoreCase("SERIAL") ||
				 sColumnTypeName.equalsIgnoreCase("INT4") ){
			oColumnData = oResultSet.getBigDecimal(iColumnIndex);
		}
		else if (sColumnTypeName.equalsIgnoreCase("DATE") ||
				 sColumnTypeName.equalsIgnoreCase("DATETIME") ||
				 sColumnTypeName.equalsIgnoreCase("TIME") ||
				 sColumnTypeName.equalsIgnoreCase("TIMESTAMP")) {
			oColumnData = oResultSet.getTimestamp(iColumnIndex);
		}else if(sColumnTypeName.equalsIgnoreCase("BOOLEAN") ||
				 sColumnTypeName.equalsIgnoreCase("BOOL") ){
			oColumnData=oResultSet.getBoolean(iColumnIndex);
		}

		return oColumnData;
	}
}
