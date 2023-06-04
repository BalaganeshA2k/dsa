package org.lern.dsa.arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class PrintAllElementsTest {
    private PrintAllElements printAllElements;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @AfterAll
    void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @BeforeAll

    void setUp() throws IOException {
        printAllElements = new PrintAllElements();
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        outContent.close();
        errContent.close();
    }

    @Test
    void printAllElements_test() {
        int[] arr = { 1, 2, 3, 4 };
        printAllElements.solution(arr);
        assertTrue(outContent.toString().contains("1"), () -> "contains1");
        assertTrue(outContent.toString().contains("4"), () -> "contains1");
        assertTrue(outContent.toString().contains("3"), () -> "contains1");
        assertTrue(outContent.toString().contains("2"), () -> "contains1");
    }

}
