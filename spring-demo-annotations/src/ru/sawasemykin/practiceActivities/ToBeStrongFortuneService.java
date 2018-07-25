package ru.sawasemykin.practiceActivities;

import com.luv2code.springdemo.FortuneService;

public class ToBeStrongFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		
		return "Make sure you work hard every day";
	}

}
