package ru.sawasemykin.practiceActivities;

import com.luv2code.springdemo.Coach;
import com.luv2code.springdemo.FortuneService;

public class StreetWorkoutCoach implements Coach {
	
	private FortuneService fortuneService;
	
	public StreetWorkoutCoach(FortuneService theFortuneService){
		fortuneService = theFortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Make 30 pull-ups daily";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
