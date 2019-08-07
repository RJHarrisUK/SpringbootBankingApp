package com.prizegen.service;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class PrizeServiceImpl implements PrizeService {

	@Override
	public String getPrize() {

		Random rand = new Random();
		int value = rand.nextInt(10);

		if (value < 5) {
			return "Congratulations you have won £5";
		}
		if (value == 5) {
			return "Congratulations you have won £50";
		} else {
			return "Comiserations you have not won anything";
		}
	}
}
