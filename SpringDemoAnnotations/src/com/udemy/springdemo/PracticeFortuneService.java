package com.udemy.springdemo;

import java.util.List;
import java.util.Random;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class PracticeFortuneService implements FortuneService {

	List<String> fortunes;
	
	public PracticeFortuneService() throws IOException {
		String filePath = "C:\\Users\\HP\\eclipse-workspace\\Udemy Spring\\SpringDemoAnnotations\\src\\fortune-data.txt";
		
		try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
			fortunes = lines.collect(Collectors.toList());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public String getFortune() {
		
		Random myRandom = new Random();
		int index = myRandom.nextInt(fortunes.size());
		String randomFortune = fortunes.get(index);
	
		return randomFortune;
	}

}
