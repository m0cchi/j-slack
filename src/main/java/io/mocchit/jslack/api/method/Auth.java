package io.mocchit.jslack.api.method;

import io.mocchit.jslack.api.BaseAPI;
import io.mocchit.jslack.api.Result;

public interface Auth extends BaseAPI {
	
	default Result testAuth() {
		return send("auth.test", getTokenParam());
	}

}
