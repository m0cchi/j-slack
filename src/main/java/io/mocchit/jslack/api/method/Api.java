package io.mocchit.jslack.api.method;

import io.mocchit.jslack.api.BaseAPI;
import io.mocchit.jslack.api.Result;

public interface Api extends BaseAPI {
	/**
	 * Checks API calling code.
	 * 
	 * @return
	 */
	default Result testApi() {
		Result result = send("api.test", "");
		return result;
	}
}
