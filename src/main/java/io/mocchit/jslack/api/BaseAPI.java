package io.mocchit.jslack.api;

public interface BaseAPI {
	final static String URL = "https://slack.com/api/";

	Result send(String api, String param);

	String getToken();
}
