package com.udemy.springdemo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PracticeCoach implements Coach {

	@Autowired
	@Qualifier("practiceFortuneService")
	private FortuneService fortuneService;

	@Override
	public String getDailyWorkout() {
		return "PracticeCoach: practice";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

	@PostConstruct
	public void practiceStartup() {
		System.out.println("PracticeCoach: inside practiceStartup()");

		String filePath = "C:\\Users\\HP\\eclipse-workspace\\Udemy Spring\\SpringDemoAnnotations\\src\\fortune-data.txt";
		List<String> fortuneList = new ArrayList<String>();
		fortuneList = getFortuneFromFile(fortuneList, filePath);

		for(int i=0; i<fortuneList.size(); i++) {
			System.out.println(fortuneList.get(i));
		}
	}

	public List<String> getFortuneFromFile(List<String> list, String filePath){
		File file = new File(filePath);
		try(BufferedReader br = new BufferedReader(new FileReader(file))){
			String tempLine;

			while((tempLine = br.readLine()) != null) {
				list.add(tempLine);
			}	
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@PreDestroy
	public void practiceCleanup() {
		System.out.println("PracticeCoach: inside practiceCleanup()");
	}
}