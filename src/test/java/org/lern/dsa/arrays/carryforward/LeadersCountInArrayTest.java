package org.lern.dsa.arrays.carryforward;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class LeadersCountInArrayTest {
    private LeadersCountInAnArray leaderCountInArray;

    @BeforeAll
    public void setUp() {
        this.leaderCountInArray = new LeadersCountInAnArray();
    }

    @Test
    void bruteforceSolutionTest() {
        int[] input = { 1, 2, 3, 4, 5 };
        int expectedOutput = 1;
        int actualOutput = leaderCountInArray.bruteforceSolution(input);
        assertEquals(expectedOutput, actualOutput);
        input = new int[] { 5, 4, 3, 2, 1 };
        expectedOutput = 5;
        actualOutput = leaderCountInArray.bruteforceSolution(input);
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void carryForwardSolutionTest() {
        int[] input = { 1, 2, 3, 4, 5 };
        int expectedOutput = 1;
        int actualOutput = leaderCountInArray.carryForwardSolution(input);
        assertEquals(expectedOutput, actualOutput);
        input = new int[] { 5, 4, 3, 2, 1 };
        expectedOutput = 5;
        actualOutput = leaderCountInArray.carryForwardSolution(input);
        assertEquals(expectedOutput, actualOutput);
    }

}
