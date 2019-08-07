package com.numgen.service;

import java.util.Random;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class NumGenServiceImpl implements NumGenService {

	@Override
	public ResponseEntity<String> getAccountNumber() {

		Random random = new Random();

		char c = (char) (random.nextInt(3) + 'A');

		String numberPart = String.format("%06d", random.nextInt(999999));

		return new ResponseEntity<String>(c + numberPart, HttpStatus.OK);

	}
}
