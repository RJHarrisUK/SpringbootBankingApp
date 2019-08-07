package com.numgen.service;

import org.springframework.http.ResponseEntity;

public interface NumGenService {

	ResponseEntity<String> getAccountNumber();

}
