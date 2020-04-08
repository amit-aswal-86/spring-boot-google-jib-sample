package com.zaravya.sample.controller;

import com.zaravya.sample.common.AppProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class SoapHandler {

    @Autowired
    AppProperties appProperties;

    public ResponseEntity<?> handleRequest(HttpServletRequest request, String requestBody) {
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body("Not Implemented yet");
    }
}
