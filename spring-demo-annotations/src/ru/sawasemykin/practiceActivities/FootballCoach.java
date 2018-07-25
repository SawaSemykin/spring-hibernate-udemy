package ru.sawasemykin.practiceActivities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.luv2code.springdemo.Coach;
import com.luv2code.springdemo.FortuneService;

@Component
public class FootballCoach implements Coach {
	
	@Autowired
	@Qualifier("fileFortuneService")
	private FortuneService fortuneService;
	
	public FootballCoach() {
		System.out.println(">> FootballCoach: inside default constructor");
	}

	@Override
	public String getDailyWorkout() {
		return "Play by your head everyday!";
	}

	@Override
	public String getDailyFortune() {		
		return fortuneService.getFortune();
	}

}
