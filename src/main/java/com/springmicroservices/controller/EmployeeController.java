package com.springmicroservices.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.springmicroservices.exceptions.MissingHeadersException;

@RestController
public class EmployeeController {
	
	@PostMapping("/employees")
	public ResponseEntity<String> saveEmployee(@RequestHeader(value = "applicationName", required = false) String applicationName) {
		
		if(applicationName =="" || applicationName == null) {
			throw new MissingHeadersException("Application ID is missing");
		}
		
		return new ResponseEntity<String>("Employee Saved Successfully", HttpStatus.OK);
	}

}
