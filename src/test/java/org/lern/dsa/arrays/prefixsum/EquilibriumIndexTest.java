package org.lern.dsa.arrays.prefixsum;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class EquilibriumIndexTest {
    private EquilibriumIndex equilibriumIndex;

    @BeforeAll
    void setUp() {

        this.equilibriumIndex = new EquilibriumIndex(new PrefixSumOfArray());
    }

    @Test
    void solutionWithExtraSpace_shouldReturn_indexWhereSumOfLeftOfIndexEqualsRight() {
        int[] arr = { -7, 3, 3, 2, -4, 0, 2, 1 };
        int expectedIndex = 3;
        int acutalIndex = equilibriumIndex.solutionWithExtraSpace(arr);
        assertEquals(expectedIndex, acutalIndex);
        arr = new int[] { 1, 2, 3, 4, 5, -14 };
        expectedIndex = 0;
        acutalIndex = equilibriumIndex.solutionWithExtraSpace(arr);
        assertEquals(expectedIndex, acutalIndex);
        arr = new int[] { 1, 2, 3, 4, 5, -15 };
        expectedIndex = -1;
        acutalIndex = equilibriumIndex.solutionWithExtraSpace(arr);
        assertEquals(expectedIndex, acutalIndex);
    }

    @Test
    void solutionWhenInPlaceAllowed_shouldReturn_indexWhereSumOfLeftOfIndexEqualsRight1() {
        int[] arr = { -7, 3, 3, 2, -4, 0, 2, 1 };
        int expectedIndex = 3;
        int acutalIndex = equilibriumIndex.solutionWhenInPlaceAllowed(arr);
        assertEquals(expectedIndex, acutalIndex);
        arr = new int[] { 1, 2, 3, 4, 5, -14 };
        expectedIndex = 0;
        acutalIndex = equilibriumIndex.solutionWhenInPlaceAllowed(arr);
        assertEquals(expectedIndex, acutalIndex);
        arr = new int[] { 1, 2, 3, 4, 5, -15 };
        expectedIndex = -1;
        acutalIndex = equilibriumIndex.solutionWhenInPlaceAllowed(arr);
        assertEquals(expectedIndex, acutalIndex);
    }

    @Test
    void solutionWithoutExtraSpaceAndInPlaceCalculationNotAllowed_shouldReturn_indexWhereSumOfLeftOfIndexEqualsRight1() {
        int[] arr = { -7, 3, 3, 2, -4, 0, 2, 1 };
        int expectedIndex = 3;
        int acutalIndex = equilibriumIndex.solutionWithoutExtraSpaceAndInPlaceCalculationNotAllowed(arr);
        assertEquals(expectedIndex, acutalIndex);
        arr = new int[] { 1, 2, 3, 4, 5, -14 };
        expectedIndex = 0;
        acutalIndex = equilibriumIndex.solutionWithoutExtraSpaceAndInPlaceCalculationNotAllowed(arr);
        assertEquals(expectedIndex, acutalIndex);
        arr = new int[] { 1, 2, 3, 4, 5, -15 };
        expectedIndex = -1;
        acutalIndex = equilibriumIndex.solutionWithoutExtraSpaceAndInPlaceCalculationNotAllowed(arr);
        assertEquals(expectedIndex, acutalIndex);
    }

}
