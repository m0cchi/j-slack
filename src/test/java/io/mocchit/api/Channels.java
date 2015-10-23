package io.mocchit.api;

import io.mocchit.jslack.SlackClient;

public class Channels {

	public static void main(String[] args) {
		String token = "xoxp-2664788996-2685722346-3032510289-34e43c";
		SlackClient slackClient = new SlackClient(token);
		slackClient.list();
	}

}
