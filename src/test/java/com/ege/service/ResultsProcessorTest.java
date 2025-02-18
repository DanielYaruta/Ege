package com.ege.service;

import com.ege.utils.FileUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ResultsProcessorTest {

    @Autowired
    private ResultsProcessor resultsProcessor;

    private Map<Integer, String> correctAnswers;
    private Map<Integer, String> studentAnswers;

    @BeforeEach
    void setUp() throws IOException {
        correctAnswers = FileUtils.readAnswersFromFile("keys.txt");
        studentAnswers = FileUtils.readAnswersFromFile("answers.txt");
    }

    @Test
    void testCalculateScore() {
        int score = resultsProcessor.calculateScore(studentAnswers, correctAnswers);
        assertEquals(12, score);
    }
}
