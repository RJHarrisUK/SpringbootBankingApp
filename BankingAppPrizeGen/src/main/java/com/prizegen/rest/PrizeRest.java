package com.prizegen.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prizegen.service.PrizeService;

@RestController
public class PrizeRest {

	public PrizeService service;

	@Autowired
	public PrizeRest(PrizeService service) {
		this.service = service;
	}

	public PrizeRest() {
	}

	// READ
	@GetMapping("/getPrizegen")
	public String getPrize() {
		return service.getPrize();
	}
}
