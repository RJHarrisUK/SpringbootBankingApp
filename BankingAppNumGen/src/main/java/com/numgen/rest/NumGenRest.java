package com.numgen.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.numgen.service.NumGenService;

@RestController
public class NumGenRest {

	public NumGenService service;

	@Autowired
	public NumGenRest(NumGenService service) {
		this.service = service;
	}

	public NumGenRest() {
	}

	// READ
	@GetMapping("/getNumgen")
	public ResponseEntity<String> getAccountNumber() {
		return service.getAccountNumber();
	}
}
