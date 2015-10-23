package io.mocchit.api;

import io.mocchit.jslack.SlackClient;

public class Channels {

	public static void main(String[] args) {
		String token = "xoxp-xxxxxxxxxxxxxxxxxxxxxxxx";
		SlackClient slackClient = new SlackClient(token);
		slackClient.list();
	}

}
