package io.mocchit.jslack.api.method;

import io.mocchit.jslack.api.ApiUtil;
import io.mocchit.jslack.api.BaseAPI;
import io.mocchit.jslack.api.Result;

import java.util.Map;

public interface Chat extends BaseAPI {

	/**
	 * Deletes a message.
	 * 
	 * @param channel
	 *            Channel containing the message to be deleted.
	 * @param ts
	 *            Timestamp of the message to be deleted.
	 * @return
	 */
	default Result delete(String channel, String ts) {
		StringBuilder builder = new StringBuilder(getTokenParam());
		builder.append(ApiUtil.concat("ts", ts));
		builder.append(ApiUtil.concat("channel", channel));
		return send("chat.delete", builder.toString());
	}

	/**
	 * Sends a message to a channel.
	 * 
	 * @param channel
	 *            Channel, private group, or IM channel to send message to. Can
	 *            be an encoded ID, or a name. See below for more details.
	 * @param text
	 *            Text of the message to send. See below for an explanation of
	 *            formatting.
	 * @param optionals
	 *            https://api.slack.com/methods/chat.postMessage
	 * @return
	 */
	default Result postMessage(String channel, String text,
			Map<String, String> optionals) {
		StringBuilder builder = new StringBuilder(getTokenParam());
		builder.append(ApiUtil.concat("channel", channel));
		builder.append(ApiUtil.concat("text", text));
		builder.append(ApiUtil.toParam(optionals));
		return send("chat.postMessage", builder.toString());
	}

	/**
	 * Updates a message.
	 * 
	 * @param channel
	 *            Channel containing the message to be updated.
	 * @param ts
	 *            Timestamp of the message to be updated.
	 * @param text
	 *            New text for the message, using the default formatting rules.
	 * @param optionals
	 *            https://api.slack.com/methods/chat.update
	 * @return
	 */
	default Result update(String channel, String ts, String text,
			Map<String, String> optionals) {
		StringBuilder builder = new StringBuilder(getTokenParam());
		builder.append(ApiUtil.concat("channel", channel));
		builder.append(ApiUtil.concat("ts", ts));
		builder.append(ApiUtil.toParam(optionals));
		return send("chat.update", builder.toString());
	}

}
