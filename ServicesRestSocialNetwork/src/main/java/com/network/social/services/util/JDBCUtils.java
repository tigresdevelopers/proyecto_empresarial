package com.network.social.services.util;

import java.sql.ResultSet;

import com.network.social.services.util.JDBCTypes.BOOLEAN_TYPES;
import com.network.social.services.util.JDBCTypes.DATE_TYPES;
import com.network.social.services.util.JDBCTypes.INTEGER_TYPES;
import com.network.social.services.util.JDBCTypes.VARCHAR_TYPES;

public class JDBCUtils {

	public static Object fn_oColumnData(ResultSet oResultSet, String sColumnTypeName, int iColumnIndex) throws Exception {

		for(VARCHAR_TYPES type:VARCHAR_TYPES.values()) {
			if (type.getType().equalsIgnoreCase(sColumnTypeName)) {
				return oResultSet.getString(iColumnIndex);
			}
		}
		
		for (INTEGER_TYPES type:INTEGER_TYPES.values()) {
			if (type.getType().equalsIgnoreCase(sColumnTypeName)) {
				return oResultSet.getBigDecimal(iColumnIndex);
			}
		}
		for (DATE_TYPES type : DATE_TYPES.values()) {
			if (type.getType().equalsIgnoreCase(sColumnTypeName)) {
				return oResultSet.getDate(iColumnIndex);
			}
		}
		for (BOOLEAN_TYPES type : BOOLEAN_TYPES.values()){
			if (type.getType().equalsIgnoreCase(sColumnTypeName)) {
				return oResultSet.getBoolean(iColumnIndex);
			}
		}
		
		return null;
	}
}
