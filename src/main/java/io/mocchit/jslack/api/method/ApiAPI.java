package io.mocchit.jslack.api.method;

import io.mocchit.jslack.BaseAPI;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

public interface ApiAPI extends BaseAPI{
	default Result test(){
		String result = send("api.test", "");
		return null;
	}
}
