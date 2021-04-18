package com.springmicroservices.exceptions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
	
	private String BAD_REQUEST = "BAD_REQUEST";

    @ExceptionHandler(MissingHeadersException.class)
    public final ResponseEntity<ErrorDetails> handleMissingHeadersException(MissingHeadersException ex, WebRequest request) {
    	
        List<String> details = new ArrayList<>();
        details.add("Missing Application Id in the headers");
        ErrorDetails error = new ErrorDetails(BAD_REQUEST, details);
        
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }


}
