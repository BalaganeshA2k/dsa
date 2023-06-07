package org.lern.dsa.arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

public class SearchInUnsortedArrayTest {
    private static SearchInUnsortedArray findElementInArray;

    @BeforeAll
    static void setUp() {
        findElementInArray = new SearchInUnsortedArray();
    }

    @Test
    @Timeout(unit = TimeUnit.SECONDS, value = 1)
    void solution_returns_index_if_target_found() {
        int[] arr = { 1, 2, 3, 4, 5 };
        int response = findElementInArray.solution(arr, 2);
        int expectedResponse = 1;
        assertEquals(expectedResponse, response);
    }

    @Test
    @Timeout(unit = TimeUnit.SECONDS, value = 1)
    void solution_returns_negative_1_if_target_is_not_found() {
        int[] arr = { 1, 2, 3, 4, 5 };
        int response = findElementInArray.solution(arr, 10);
        int expectedResponse = -1;
        assertEquals(expectedResponse, response);
    }

    @Test
    @Timeout(unit = TimeUnit.SECONDS, value = 1)
    void generic_solution_returns_index_if_target_found() {
        Integer[] arr = { 1, 2, 3, 4, 5 };
        int response = findElementInArray.genericSolution(arr, 2);
        int expectedResponse = 1;
        assertEquals(expectedResponse, response);
    }

    @Test
    @Timeout(unit = TimeUnit.SECONDS, value = 1)
    void generic_solution_returns_negative_1_if_target_is_not_found() {
        Integer[] arr = { 1, 2, 3, 4, 5 };
        int response = findElementInArray.genericSolution(arr, 10);
        int expectedResponse = -1;
        assertEquals(expectedResponse, response);
    }
}
