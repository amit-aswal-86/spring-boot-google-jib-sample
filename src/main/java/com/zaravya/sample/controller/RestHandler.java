package com.zaravya.sample.controller;

import com.zaravya.sample.common.AppProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;


@Component
public class RestHandler {

    @Autowired
    AppProperties appProperties;

    public ResponseEntity<?> handleRequest(HttpServletRequest request, String requestBody) {
        // TODO: transform request
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create("https://google.com"));
        return new ResponseEntity<>(requestBody, headers, HttpStatus.MOVED_PERMANENTLY);
    }
}
