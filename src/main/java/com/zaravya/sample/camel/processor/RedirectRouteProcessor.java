package com.zaravya.sample.camel.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.http.common.HttpMethods;
import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RedirectRouteProcessor implements Processor {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	public void process(Exchange exchange) throws Exception {
		final String body = exchange.getIn().getBody(String.class);
		HttpMethods httpMethods = exchange.getIn().getHeader(Exchange.HTTP_METHOD, HttpMethods.class);
		log.info("HttpMethods {}", httpMethods);

		// TODO: remove extra camel header

		exchange.getMessage().setBody("Hello from camel processed message! Received payload: " + body);
		exchange.getMessage().setHeader(Exchange.HTTP_RESPONSE_CODE, HttpStatus.SC_ACCEPTED);
	}

}
