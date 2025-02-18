package com.ege;

import com.ege.service.ResultsProcessor;
import com.ege.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.Map;

@SpringBootApplication
public class EgeApplication implements CommandLineRunner {

	@Autowired
	private ResultsProcessor resultsProcessor;

	public static void main(String[] args) {
		SpringApplication.run(EgeApplication.class, args);
	}

	@Override
	public void run(String... args) throws IOException {
		Map<Integer, String> correctAnswers = FileUtils.readAnswersFromFile("keys.txt");
		Map<Integer, String> studentAnswers = FileUtils.readAnswersFromFile("answers.txt");

		int score = resultsProcessor.calculateScore(studentAnswers, correctAnswers);
		System.out.println("Total score: " + score);
	}
}
