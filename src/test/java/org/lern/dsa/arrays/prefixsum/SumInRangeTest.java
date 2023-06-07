package org.lern.dsa.arrays.prefixsum;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class SumInRangeTest {

    private SumInRange sumInRange;

    @BeforeAll
    void setUp() {
        this.sumInRange = new SumInRange();
    }

    @Test
    void sum_should_return_sum_for_valid_from_to() {
        int[] arr = { 1, 2, 3, 4, 5, 6 };
        int from = 1;
        int to = 4;
        int expectedResponse = 14;
        int actualResponse = sumInRange.sum(arr, from, to);
        assertEquals(expectedResponse, actualResponse, "sum in range wrong for valid from and to");
    }

    @Test
    void sum_should_thow_illegal_argument_exception_when_from_or_to_is_invalid() {
        int[] arr = { 1, 2, 3, 4, 5, 6 };
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> sumInRange.sum(arr, -1, 4));
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> sumInRange.sum(arr, 1, 20));
    }
}
