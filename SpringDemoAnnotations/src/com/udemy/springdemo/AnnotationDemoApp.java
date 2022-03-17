package com.udemy.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Coach theCoach = context.getBean("guitarCoach", Coach.class);

		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		
		GuitarCoach guitarCoach = context.getBean("guitarCoach", GuitarCoach.class);
		System.out.println(guitarCoach.getEmail());
		System.out.println(guitarCoach.getTeam());
		
		context.close();
	}
}
