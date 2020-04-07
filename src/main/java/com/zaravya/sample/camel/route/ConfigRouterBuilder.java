package com.zaravya.sample.camel.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zaravya.sample.camel.processor.RedirectRouteProcessor;
import com.zaravya.sample.common.AppProperties;

@Component
public class ConfigRouterBuilder extends RouteBuilder {
	
	@Autowired
	AppProperties appProperties;

	@Override
	public void configure() throws Exception {
		from(appProperties.getRedirectServiceEndpoint())
        .id(appProperties.getRedirectRouteId())
        .log("Processing Camel Route")
        .process(new RedirectRouteProcessor());
	}

}
