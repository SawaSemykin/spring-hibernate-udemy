package com.luv2code.springdemo;

import java.util.Random;

public class MyFortuneService implements FortuneService {

	private String[] fortunesBank = {
			"Don't stop. Keep going.",
			"You are the champion",
			"Just do it!"
	};
	
	@Override
	public String getFortune() {
		Random randomator = new Random();
		int index = randomator.nextInt(fortunesBank.length);		
		return fortunesBank[index];
	}

}
