package org.lern.dsa.arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class FindElementInArrayTest {
    private static FindElementInArray findElementInArray;

    @BeforeAll
    static void setUp() {
        findElementInArray = new FindElementInArray();
    }

    @Test
    void solution_returns_index_if_target_found() {
        int[] arr = { 1, 2, 3, 4, 5 };
        int response = findElementInArray.solution(arr, 2);
        int expectedResponse = 1;
        assertEquals(expectedResponse, response);
    }

    @Test
    void solution_returns_negative_1_if_target_is_not_found() {
        int[] arr = { 1, 2, 3, 4, 5 };
        int response = findElementInArray.solution(arr, 10);
        int expectedResponse = -1;
        assertEquals(expectedResponse, response);
    }

    @Test
    void generic_solution_returns_index_if_target_found() {
        int[] arr = { 1, 2, 3, 4, 5 };
        int response = findElementInArray.solution(arr, 2);
        int expectedResponse = 1;
        assertEquals(expectedResponse, response);
    }

    @Test
    void generic_solution_returns_negative_1_if_target_is_not_found() {
        int[] arr = { 1, 2, 3, 4, 5 };
        int response = findElementInArray.solution(arr, 10);
        int expectedResponse = -1;
        assertEquals(expectedResponse, response);
    }
}
