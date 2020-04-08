package com.zaravya.sample.common;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource(value = "classpath:application.properties")
@Data
public class AppProperties {

    @Autowired
    private Environment env;

    @Value("${server.port}")
    private String port;

    @Value("${redirect.endpoint}")
    private String redirectServiceEndpoint;

    @Value("${redirect.route.id}")
    private String redirectRouteId;

    @Value("redirect.rest.url")
    private String restUrl;

    @Value("redirect.soap.url")
    private String soapUrl;
}
