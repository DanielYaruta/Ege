package com.ege.utils;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class FileUtils {

    public static Map<Integer, String> readAnswersFromFile(String fileName) throws IOException {
        Map<Integer, String> answers = new HashMap<>();
        File file = new File(fileName);

        if (!file.exists()) {
            throw new FileNotFoundException("File not found: " + fileName);
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int questionNumber = 1;
            while ((line = br.readLine()) != null) {
                answers.put(questionNumber++, line.trim());
            }
        } catch (IOException e) {
            throw new IOException("Error reading the file: " + fileName, e);
        }
        return answers;
    }
}