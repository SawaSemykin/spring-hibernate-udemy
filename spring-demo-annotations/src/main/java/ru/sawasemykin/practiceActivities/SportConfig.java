package ru.sawasemykin.practiceActivities;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.luv2code.springdemo.Coach;
import com.luv2code.springdemo.FortuneService;

@Configuration("mySportConfig")
public class SportConfig {
	
	@Bean
	public FortuneService toBeStrongFortuneService(){
		return new ToBeStrongFortuneService();
	}
	
	@Bean
	public Coach streetWorkoutCoach(){
		return new StreetWorkoutCoach(toBeStrongFortuneService());
	}

}
