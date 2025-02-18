package com.ege.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ResultsProcessor {

    @Value("${scores.group1}")
    private int group1Scores;

    @Value("${scores.group2}")
    private int group2Scores;

    @Value("${scores.group3}")
    private int group3Scores;

    public int calculateScore(Map<Integer, String> answers, Map<Integer, String> correctAnswers) {
        int totalScore = 0;

        for (int i = 1; i <= 4; i++) {
            if (answers.get(i).equals(correctAnswers.get(i))) {
                totalScore += group1Scores;
            }
        }

        for (int i = 5; i <= 8; i++) {
            if (answers.get(i).equals(correctAnswers.get(i))) {
                totalScore += group2Scores;
            }
        }

        for (int i = 9; i <= 10; i++) {
            if (answers.get(i).equals(correctAnswers.get(i))) {
                totalScore += group3Scores;
            }
        }

        return totalScore;
    }
}
