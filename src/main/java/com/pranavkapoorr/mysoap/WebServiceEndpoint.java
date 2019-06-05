package com.pranavkapoorr.mysoap;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.pranavkapoorr.InputSOATest;
import com.pranavkapoorr.ObjectFactory;
import com.pranavkapoorr.OutputSOATest;

@Endpoint
public class WebServiceEndpoint {

	private static final String NAMESPACE_URI = "http://pranavkapoorr.com";

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "inputSOATest")
	@ResponsePayload
	public OutputSOATest hello(@RequestPayload InputSOATest request) {

		String outputString = "Hello " + request.getTest() + "!";

		ObjectFactory factory = new ObjectFactory();
		OutputSOATest response = factory.createOutputSOATest();
		response.setResult(outputString);

		return response;
	}
}