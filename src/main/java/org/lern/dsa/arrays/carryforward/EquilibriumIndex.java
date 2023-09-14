package org.lern.dsa.arrays.carryforward;

public class EquilibriumIndex {
    // Also Discussed in Prefix Sum Method
    // Advantage over prefix sum method -> no extra space, no in-place calculation
    // T = O(N+N) => O(N)
    // S = O(1)
    int carryForwardSolution(int[] array) {
        double rightSum = 0;
        double leftSum = 0;
        for (int i = 1; i < array.length; i++)
            rightSum += array[i];

        // check for first index
        if (leftSum == rightSum)
            return 0;
        // check for 1 -> N-1
        for (int i = 1; i < array.length; i++) {
            leftSum += array[i - 1];
            rightSum -= array[i];
            if (leftSum == rightSum)
                return i;
        }
        return -1;
    }
}
