package ru.sawasemykin.practiceActivities;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.springdemo.Coach;

public class JavaConfigDemoApp {

	public static void main(String[] args) {
		
		// read config class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		
		// retrieve the bean
		Coach theCoach = context.getBean("streetWorkoutCoach", StreetWorkoutCoach.class);
		
		// call the bean's methods
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());		
		
		// close the context
		context.close();
		
		
	}

}
