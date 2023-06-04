package org.lern.dsa.arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class ReverseAnArrayTest {
    private ReverseAnArray reverseAnArray;

    @BeforeAll
    void setUp() {
        this.reverseAnArray = new ReverseAnArray();
    }

    @Test
    void check_if_array_with_even_size_is_reversed() {
        int[] input = { 1, 2, 3, 4 };
        int[] expectedOutput = { 4, 3, 2, 1 };
        reverseAnArray.reverseInPlace(input);
        assertArrayEquals(expectedOutput, input, () -> "array is not reversed in place");
    }

    @Test
    void check_if_array_with_odd_size_is_reversed() {
        int[] input = { 1, 2, 3, 4, 5 };
        int[] expectedOutput = { 5, 4, 3, 2, 1 };
        reverseAnArray.reverseInPlace(input);
        assertArrayEquals(expectedOutput, input, () -> "array is not reversed in place");
    }

    @Test
    void check_if_generic_array_with_even_size_is_reversed() {
        Integer[] input = { 1, 2, 3, 4 };
        Integer[] expectedOutput = { 4, 3, 2, 1 };
        reverseAnArray.genericReverseInPlace(input);
        assertArrayEquals(expectedOutput, input, () -> "array is not reversed in place");
    }

    @Test
    void check_if_generic_array_with_odd_size_is_reversed() {
        Integer[] input = { 1, 2, 3, 4, 5 };
        Integer[] expectedOutput = { 5, 4, 3, 2, 1 };
        reverseAnArray.genericReverseInPlace(input);
        assertArrayEquals(expectedOutput, input, () -> "array is not reversed in place");
    }
}
