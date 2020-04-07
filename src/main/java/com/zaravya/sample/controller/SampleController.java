package com.zaravya.sample.controller;

import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.http.HttpServletRequest;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.ExchangeBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zaravya.sample.common.AppProperties;
import com.zaravya.sample.dto.Greeting;

@RestController
public class SampleController {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());

    private static final String template = "Hello Docker, %s!";
    private final AtomicLong counter = new AtomicLong();
    
    @Autowired
    private ProducerTemplate producer;

    @Autowired
    private CamelContext camelContext;
    
    @Autowired
	AppProperties appProperties;

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
    
    @RequestMapping(value = "/redirect-service")
    @ResponseBody
    public ResponseEntity<?> hello(final HttpServletRequest request,
                                   @RequestBody String requestBody) {
        String contentType = request.getContentType();
        log.info("Request Body {}", requestBody);
        log.info("Content Type {}", request.getContentType());

        final Exchange requestExchange = ExchangeBuilder.anExchange(camelContext).withBody(requestBody).build();
        final Exchange responseExchange = producer.send(appProperties.getRedirectServiceEndpoint(), requestExchange);
        final String responseBody = responseExchange.getMessage().getBody(String.class);

        if (StringUtils.isEmpty(contentType)) {
            log.info("Empty Content type unable to redirect");
        } else if (contentType.contains("xml")) {
            log.info("SOAP Request");
        } else {
            log.info("Other Request");
        }


        final int responseCode = responseExchange.getMessage().getHeader(Exchange.HTTP_RESPONSE_CODE, Integer.class).intValue();
        return ResponseEntity.status(responseCode).body(responseBody);
    }
}
