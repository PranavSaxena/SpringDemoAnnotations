package com.udemy.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class GuitarCoach implements Coach {

	@Value("${foo.email}")
	String email;
	
	@Value("${foo.team}")
	String team;
	
	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;

	public GuitarCoach() {
		System.out.println("GuitarCoach: inside default constructor");
	}
	
	@Override
	public String getDailyWorkout() {
		return "GuitarCoach: fingerplucking exercise for 30min";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

	public String getEmail() {
		return email;
	}

	public String getTeam() {
		return team;
	}
	
	@PostConstruct
	public void practiceStartup() {
		System.out.println("GuitarCoach: inside startup()");
	}
	
	@PreDestroy
	public void practiceCleanup() {
		System.out.println("GuitarCoach: inside cleanUp()");
	}
}