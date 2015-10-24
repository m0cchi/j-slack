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
}
