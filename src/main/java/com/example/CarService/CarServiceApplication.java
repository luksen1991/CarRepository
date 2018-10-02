package com.example.CarService;

import com.example.CarService.Domain.Issue;
import com.example.CarService.Repository.IssueRepositoryImpl;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.Logger;

@SpringBootApplication
public class CarServiceApplication implements CommandLineRunner {

//	@Autowired
//	IssueRepositoryImpl issueRepository;

	public static void main(String[] args) {
		SpringApplication.run(CarServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		Issue issue = new Issue();
//		issue.setTitle("Awaria swiatel");
//		issue.setCarModel("Audi A6");
//		issue.setRegisterNumber("DKL123");
//		issue.setClientName("Adam Wysko");
//		issue.setIssueDescription("Nie zaplaja sie swiatla");
//		issueRepository.addIssue(issue);
	}
}
