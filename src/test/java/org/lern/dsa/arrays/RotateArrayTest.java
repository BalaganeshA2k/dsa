package org.lern.dsa.arrays;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class RotateArrayTest {

    private RotateArray rotateArray;

    @BeforeAll
    void setUp() {
        this.rotateArray = new RotateArray();
    }

    @Test
    @Timeout(unit = SECONDS, value = 1)
    void rotateClockwiseUsingReverseMethod_should_rotate_even_sized_arrays() {
        int[] input = { 1, 2, 3, 4 };
        int rotation = 9;
        int[] expectedOutput = { 4, 1, 2, 3 };
        rotateArray.rotateClockwiseUsingReverseMethod(input, rotation);
        assertArrayEquals(expectedOutput, input, "array is not rotated for odd rotation");
        rotation = 6;
        input = new int[] { 1, 2, 3, 4 };
        expectedOutput = new int[] { 3, 4, 1, 2 };
        rotateArray.rotateClockwiseUsingReverseMethod(input, rotation);
        assertArrayEquals(expectedOutput, input, "array is not rotated for even rotation");
    }

    @Test
    @Timeout(unit = SECONDS, value = 1)
    void rotateClockwiseUsingReverseMethod_should_rotate_odd_sized_arrays() {
        int[] input = { 1, 2, 3, 4, 5 };
        int rotation = 11;
        int[] expectedOutput = { 5, 1, 2, 3, 4 };
        rotateArray.rotateClockwiseUsingReverseMethod(input, rotation);
        assertArrayEquals(expectedOutput, input, "array is not rotated for odd rotation");
        rotation = 6;
        input = new int[] { 1, 2, 3, 4, 5 };
        expectedOutput = new int[] { 5, 1, 2, 3, 4 };
        rotateArray.rotateClockwiseUsingReverseMethod(input, rotation);
        assertArrayEquals(expectedOutput, input, "array is not rotated for even rotation");
    }

    @Test
    @Timeout(unit = SECONDS, value = 1)
    void rotateAntiClockwiseUsingReverseMethod_should_rotate_even_sized_arrays() {
        int[] input = { 1, 2, 3, 4 };
        int rotation = 9;
        int[] expectedOutput = { 2, 3, 4, 1 };
        rotateArray.rotateAntiClockwise(input, rotation);
        assertArrayEquals(expectedOutput, input, "array is not rotated for odd rotation");
        rotation = 6;
        input = new int[] { 1, 2, 3, 4 };
        expectedOutput = new int[] { 3, 4, 1, 2 };
        rotateArray.rotateAntiClockwise(input, rotation);
        assertArrayEquals(expectedOutput, input, "array is not rotated for even rotation");
    }

    @Test
    @Timeout(unit = SECONDS, value = 1)
    void rotateAntiClockwiseUsingReverseMethod_should_rotate_odd_sized_arrays() {
        int[] input = { 1, 2, 3, 4, 5 };
        int rotation = 11;
        int[] expectedOutput = { 2, 3, 4, 5, 1 };
        rotateArray.rotateAntiClockwise(input, rotation);
        assertArrayEquals(expectedOutput, input, "array is not rotated for odd rotation");
        rotation = 6;
        input = new int[] { 1, 2, 3, 4, 5 };
        expectedOutput = new int[] { 2, 3, 4, 5, 1 };
        rotateArray.rotateAntiClockwise(input, rotation);
        assertArrayEquals(expectedOutput, input, "array is not rotated for even rotation");
    }

}
