package com.udemy.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {
		
		// load config file
		ClassPathXmlApplicationContext context =  new ClassPathXmlApplicationContext("applicationContext.xml");
				
		// retrive bean
		Coach alphaCoach = context.getBean("tennisCoach", Coach.class);
		
		Coach betaCoach = context.getBean("tennisCoach", Coach.class);
		
		boolean result = (alphaCoach==betaCoach);
		
		System.out.println("Pointing to same object: " + result);

		System.out.println("Memory location for alphaCoach: " + alphaCoach);
		System.out.println("Memory location for betaCoach : " + betaCoach);

		context.close();

	}
}
