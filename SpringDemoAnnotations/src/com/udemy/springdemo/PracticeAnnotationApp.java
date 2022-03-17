package com.udemy.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PracticeAnnotationApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Coach theCoach = context.getBean("guitarCoach", Coach.class);
		//System.out.println(theCoach.getDailyWorkout());
		
		theCoach = context.getBean("practiceCoach", Coach.class);
		System.out.println(theCoach.getDailyFortune());
		
		context.close();
		
	}
	
}
