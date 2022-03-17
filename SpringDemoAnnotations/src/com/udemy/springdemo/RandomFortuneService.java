package com.udemy.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	// create an array of strings	
	private String[] data = {
		"Random fortune 1",
		"Random fortune 2",
		"Random fortune 3",
	};
	
	// random number generator
	
	private Random myRandom = new Random();
	
	@Override
	public String getFortune() {
		// pick a random fortune from array
		int index = myRandom.nextInt(data.length);
		
		String theFortune = data[index];
		
		return theFortune;
	}

}
