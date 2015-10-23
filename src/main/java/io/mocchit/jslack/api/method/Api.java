package io.mocchit.jslack.api.method;

import io.mocchit.jslack.api.BaseAPI;
import io.mocchit.jslack.api.Result;

public interface Api extends BaseAPI {
	default Result test() {
		Result result = send("api.test", "");
		return result;
	}
}
