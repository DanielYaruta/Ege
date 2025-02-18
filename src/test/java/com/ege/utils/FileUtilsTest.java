package com.ege.utils;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;

public class FileUtilsTest {

    private static final String VALID_FILE = "src/test/resources/valid_keys.txt";
    private static final String INVALID_FILE = "src/test/resources/invalid_keys.txt";

    @Test
    void testReadAnswersFromFile_Success() throws IOException {
        Map<Integer, String> expectedAnswers = new HashMap<>();
        expectedAnswers.put(1, "1-A");
        expectedAnswers.put(2, "2-B");
        expectedAnswers.put(3, "3-C");

        Map<Integer, String> actualAnswers = FileUtils.readAnswersFromFile(VALID_FILE);
        assertEquals(expectedAnswers, actualAnswers);
    }

    @Test
    void testReadAnswersFromFile_FileNotFound() {
        assertThrows(FileNotFoundException.class, () -> {
            FileUtils.readAnswersFromFile(INVALID_FILE);
        });
    }
}