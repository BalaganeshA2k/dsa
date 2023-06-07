package org.lern.dsa.arrays.prefixsum;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class PrefixSumOfArrayTest {

    private PrefixSumOfArray prefixSumOfArray;

    @BeforeAll
    void setUp() {
        this.prefixSumOfArray = new PrefixSumOfArray();
    }

    @Test
    void prefix_sum_should_return_array_of_prefix_sum() {
        int[] arr = { 1, 2, 3, 4, 5 };
        int[] expectedArr = { 1, 2, 3, 4, 5 };
        int[] expectedResponse = { 1, 3, 6, 10, 15 };
        int[] actualResponse = prefixSumOfArray.prefixSum(arr);
        assertArrayEquals(expectedResponse, actualResponse, "prefix sum not returned prefix sum array");
        assertArrayEquals(expectedArr, arr, "prefix sum array is calculated in-place");
    }

    @Test
    void prefix_sum_In_Place_should_return_array_of_prefix_sum() {
        int[] arr = { 1, 2, 3, 4, 5 };
        int[] expectedResponse = { 1, 3, 6, 10, 15 };
        prefixSumOfArray.prefixSumInPlace(arr);
        assertArrayEquals(expectedResponse, arr, "prefix sum not calculated in-place");
    }
}
