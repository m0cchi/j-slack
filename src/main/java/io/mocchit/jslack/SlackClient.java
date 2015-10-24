package io.mocchit.jslack;

import io.mocchit.jslack.api.Result;
import io.mocchit.jslack.api.method.Api;
import io.mocchit.jslack.api.method.Auth;
import io.mocchit.jslack.api.method.Channels;
import io.mocchit.jslack.api.method.Chat;
import io.mocchit.jslack.api.method.Emoji;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class SlackClient implements Api, Auth, Channels, Chat ,Emoji {
	private static String FAIL_CODE = "{\"ok\":false}";
	private String token;
	private String charset;

	public SlackClient(String token) {
		this.token = token;
		this.charset = "UTF-8";
	}

	private String getResult(InputStream is, int resultCode) throws IOException {
		BufferedInputStream bis = new BufferedInputStream(is);
		InputStreamReader isr = new InputStreamReader(bis, this.charset);
		BufferedReader br = new BufferedReader(isr);
		StringBuilder builder = new StringBuilder();
		if (resultCode == HttpURLConnection.HTTP_OK) {
			String line;
			while ((line = br.readLine()) != null) {
				builder.append(line);
			}
		} else {
			builder.append(FAIL_CODE);
		}

		return builder.toString();
	}

	@Override
	public Result send(String api, String param) {
		String result = FAIL_CODE;
		try {
			URL url = new java.net.URL(URL + api + "?" + param);
			HttpsURLConnection connection = (HttpsURLConnection) url
					.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Connection", "Keep-Alive");
			connection.setRequestProperty("Content-Type", "charset="
					+ this.charset);
			connection.setDoInput(true);
			connection.setDoOutput(true);
			connection.setUseCaches(false);
			connection.setChunkedStreamingMode(0);

			BufferedOutputStream bos = new BufferedOutputStream(
					connection.getOutputStream());
			bos.write(param.getBytes());
			bos.flush();

			result = getResult(connection.getInputStream(),
					connection.getResponseCode());

		} catch (IOException e) {
		}

		return new Result(result);
	}

	@Override
	public String getToken() {
		return this.token;
	}

}
