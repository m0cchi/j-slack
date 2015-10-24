package io.mocchit.jslack.api.method;

import io.mocchit.jslack.api.BaseAPI;
import io.mocchit.jslack.api.Result;

public interface Emoji extends BaseAPI {

	/**
	 * Lists custom emoji for a team.
	 * 
	 * @return
	 */
	default Result listEmoji() {
		return send("emoji.list", getTokenParam());
	}

}
