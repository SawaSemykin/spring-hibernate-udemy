package ru.sawasemykin.practiceActivities;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.luv2code.springdemo.Coach;

public class PracticeActivity5App {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Coach myCoach = context.getBean("footballCoach", Coach.class);
		
		System.out.println(myCoach.getDailyFortune());
		
		context.close();

	}

}
