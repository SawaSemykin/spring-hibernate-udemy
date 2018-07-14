package com.luv2code.springdemo;

public class SwimmingCoach implements Coach {

	private FortuneService fortuneService;
	
	public SwimmingCoach(FortuneService fortuneService) {
		
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		
		return "Swim twice a week";
	}

	@Override
	public String getDaillyFortune() {
		
		return fortuneService.getFortune();
	}

}
