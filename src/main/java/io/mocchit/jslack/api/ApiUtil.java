package io.mocchit.jslack.api;

import java.util.Map;
import java.util.Map.Entry;

public class ApiUtil {
	/**
	 * 
	 * @param paramMap
	 * @return
	 */
	public static String toParam(Map<String, String> paramMap) {
		StringBuilder builder = new StringBuilder();
		if (paramMap != null) {
			for (Entry<String, String> entry : paramMap.entrySet()) {
				builder.append("&");
				builder.append(entry.getKey());
				builder.append("=");
				builder.append(entry.getValue());
			}
		}
		return builder.toString();
	}
	
	public static String concat(String prefix,String key,String value){
		StringBuilder builder = new StringBuilder(prefix);
		builder.append(key);
		builder.append("=");
		builder.append(value);
		return builder.toString();
	}
	
	public static String concat(String key,String value){
		return concat("&", key, value);
	}
}
