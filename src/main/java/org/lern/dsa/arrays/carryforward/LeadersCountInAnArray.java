package org.lern.dsa.arrays.carryforward;

//A leader element in an array is the element,
// which is greater than all the elements to the right of it
public class LeadersCountInAnArray {
    // T = O(N^2)
    // S = O(1)
    public int bruteforceSolution(int[] array) {
        int ans = 0;
        for (int i = 0; i < array.length; i++) {
            int j = i + 1;
            while (j < array.length) {
                if (array[j] > array[i])
                    break;
                j++;
            }
            if (j == array.length)
                ans++;
        }
        return ans;

    }

    // T = O(N)
    // S = O(1)
    public int carryForwardSolution(int[] array) {
        int ans = 1;
        int currentMax = array[array.length - 1];
        for (int i = array.length - 2; i >= 0; i--) {
            if (array[i] > currentMax) {
                ans++;
                currentMax = array[i];
            }
        }
        return ans;
    }
}
