package org.lern.dsa.arrays.carryforward;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class CountOfPairsTest {
    private CountOfPairs countOfPairs;

    @BeforeAll
    void setUp() {
        countOfPairs = new CountOfPairs();
    }

    @Test
    void test_bruteforce_solution() {
        int[] input = { 1, 2, 2, 3, 4, 2 };
        int left = 1;
        int right = 2;
        assertEquals(3, countOfPairs.bruteforceSolution(input, left, right));
        left = 2;
        assertEquals(3, countOfPairs.bruteforceSolution(input, left, right));
        right = 3;
        assertEquals(2, countOfPairs.bruteforceSolution(input, left, right));
    }

    @Test
    void test_carry_forward_solution() {
        int[] input = { 1, 2, 2, 3, 4, 2 };
        int left = 1;
        int right = 2;
        assertEquals(3, countOfPairs.carryForwardSolution(input, left, right));
        left = 2;
        assertEquals(3, countOfPairs.carryForwardSolution(input, left, right));
        right = 3;
        assertEquals(2, countOfPairs.carryForwardSolution(input, left, right));
    }

    @Test
    void test_suffixSumSolution() {
        int[] input = { 1, 2, 2, 3, 4, 2 };
        int left = 1;
        int right = 2;
        assertEquals(3, countOfPairs.suffixSumSolution(input, left, right));
        left = 2;
        assertEquals(3, countOfPairs.suffixSumSolution(input, left, right));
        right = 3;
        assertEquals(2, countOfPairs.suffixSumSolution(input, left, right));
    }
}
