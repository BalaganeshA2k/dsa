package org.lern.dsa.arrays.carryforward;

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
        this.equilibriumIndex = new EquilibriumIndex();
    }

    @Test
    void carryForwardSolutionTest() {
        int[] arr = { -7, 3, 3, 2, -4, 0, 2, 1 };
        int expectedIndex = 3;
        int acutalIndex = equilibriumIndex.carryForwardSolution(arr);
        assertEquals(expectedIndex, acutalIndex);
        arr = new int[] { 1, 2, 3, 4, 5, -14 };
        expectedIndex = 0;
        acutalIndex = equilibriumIndex.carryForwardSolution(arr);
        assertEquals(expectedIndex, acutalIndex);
        arr = new int[] { 1, 2, 3, 4, 5, -15 };
        expectedIndex = -1;
        acutalIndex = equilibriumIndex.carryForwardSolution(arr);
        assertEquals(expectedIndex, acutalIndex);
    }
}
