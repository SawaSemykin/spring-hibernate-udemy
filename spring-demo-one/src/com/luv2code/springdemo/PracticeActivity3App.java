package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PracticeActivity3App {

	public static void main(String[] args) {
		
		// load the spring configuration file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// retrieve bean from spring container
		Coach theCoach = context.getBean("mySwimmingCoach", Coach.class);
		
		Coach theMainCoach = context.getBean("mySwimmingCoach", Coach.class);
		
		System.out.println("Are they equals: " + (theCoach == theMainCoach));
		
		System.out.println("\nA memory address for theCoah instance: " + theCoach);
		
		System.out.println("\nA memory address for theMainCoah instance: " + theMainCoach + "\n");
		
		// close the context
		context.close();
	}

}
