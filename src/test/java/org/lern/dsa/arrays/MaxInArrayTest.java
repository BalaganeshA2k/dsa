package org.lern.dsa.arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.Timeout;

@TestInstance(Lifecycle.PER_CLASS)
@Timeout(unit = TimeUnit.SECONDS, value = 1)
public class MaxInArrayTest {

    private MaxInArray maxInArray;

    @BeforeAll
    public void setUp() {
        this.maxInArray = new MaxInArray();

    }

    @Test
    void maxValueTest() {
        final Random rand = new Random();
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++)
            arr[i] = rand.nextInt(9999);
        int expectedMax = Arrays.stream(arr).max().getAsInt();
        int max = maxInArray.maxValue(arr);
        assertEquals(expectedMax, max, "max value test non empty array failed");
        arr = new int[] {};
        expectedMax = Integer.MIN_VALUE;
        max = maxInArray.maxValue(arr);
        assertEquals(expectedMax, max, "max value test for empty array failed");

    }

    @Test
    void firstMaxIndexTest() {
        int arr[] = { 1, 2, 3, 4, 3, 2, 5, 2, 5, 2, 1 };
        int expectedMaxIndex = 6;
        int actualMaxIndex = maxInArray.firstMaxIndex(arr);
        assertEquals(expectedMaxIndex, actualMaxIndex, "first max Index method failed");
    }

    @Test
    void firstMaxIndexApproach2Test() {
        int arr[] = { 1, 2, 3, 4, 3, 2, 5, 2, 5, 2, 1 };
        int expectedMaxIndex = 6;
        int actualMaxIndex = maxInArray.firstMaxIndexApproach2(arr);
        assertEquals(expectedMaxIndex, actualMaxIndex, "first max Index approach 2 method failed");
    }

    @Test
    void lastMaxIndexTest() {
        int arr[] = { 1, 2, 3, 4, 3, 2, 5, 2, 5, 2, 1 };
        int expectedMaxIndex = 8;
        int actualMaxIndex = maxInArray.lastMaxIndex(arr);
        assertEquals(expectedMaxIndex, actualMaxIndex, "first max Index approach 2 method failed");
    }

}
