package org.lern.dsa.arrays.prefixsum;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class SumInMultipleRangesTest {
    private SumInMultipleRanges sumInMultipleRanges;

    @BeforeAll
    void setUp() {
        this.sumInMultipleRanges = new SumInMultipleRanges();

    }

    @Test
    void bruteForceApproachReturnsValidResults() {
        int[] arr = { 1, 2, 3, 4, 5 };
        int[] from = { 0, 2, 3 };
        int[] to = { 1, 4, 3 };
        int[] expectedResponse = { 3, 12, 4 };
        int[] actualResponse = sumInMultipleRanges.sumInMultipleRangesBruteForce(arr, from, to);
        assertArrayEquals(expectedResponse, actualResponse);

    }

    @Test
    void prefixSumApproachReturnsValidResults() {
        int[] arr = { 1, 2, 3, 4, 5 };
        int[] from = { 0, 2, 3 };
        int[] to = { 1, 4, 3 };
        int[] expectedResponse = { 3, 12, 4 };
        int[] actualResponse = sumInMultipleRanges.sumInMultipleRangesPrefixSum(arr, from, to);
        assertArrayEquals(expectedResponse, actualResponse);

    }

    @Test
    void prefixSumInPlaceApproachReturnsValidResults() {
        int[] arr = { 1, 2, 3, 4, 5 };
        int[] from = { 0, 2, 3 };
        int[] to = { 1, 4, 3 };
        int[] expectedResponse = { 3, 12, 4 };
        int[] actualResponse = sumInMultipleRanges.sumInMultipleRangesPrefixSumInPlace(arr, from, to);
        assertArrayEquals(expectedResponse, actualResponse);
        assertArrayEquals(new int[] { 1, 3, 6, 10, 15 }, arr);

    }
}
