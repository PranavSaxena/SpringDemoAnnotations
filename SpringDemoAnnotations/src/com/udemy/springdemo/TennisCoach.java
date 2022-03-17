package com.udemy.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;

	public TennisCoach() {
		System.out.println("TennisCoach: inside default constructor");
	}

/*	
	@Autowired
	public TennisCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
*/


/*
	@Autowired
	public TennisCoach(@Qualifier("randomFortuneService") FortuneService theFortuneService) {
		System.out.println("@autowired @qualifier: constructor injection");
		fortuneService = theFortuneService;
	}
*/


/*
	@Autowired
	public void checkMethodInjection(FortuneService theFortuneService) {
		System.out.println("TennisCoach: inside checkMethodInjection()");
		fortuneService = theFortuneService;
	}
*/	


/*	
	@Autowired
	public void setFortuneService(@Qualifier("randomFortuneService") FortuneService theFortuneService) {
		System.out.println("@autowired @qualifier: setter injection");
		fortuneService = theFortuneService;
	}
*/	


	// define init method
	@PostConstruct
	public void callAtStartup() {
		System.out.println("TennisCoach: inside startup()");
	}
	
	// define destroy method
	@PreDestroy
	public void callAtCleanup() {
		System.out.println("TennisCoach: inside cleanup()");
	}
	
	@Override
	public String getDailyWorkout() {
		return "TennisCoach: practice backhand";
	}

	@Override
	public String getDailyFortune() {
		return "TennisCoach: " + fortuneService.getFortune();
	}

}
