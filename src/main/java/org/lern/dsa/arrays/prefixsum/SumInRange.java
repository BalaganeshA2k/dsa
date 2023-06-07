package org.lern.dsa.arrays.prefixsum;

public class SumInRange {
    // T = O(N)
    // S = o(1)
    public int sum(int[] arr, int from, int to) {
        if (from < 0 || to > arr.length)
            throw new IllegalArgumentException("from and toshould be within the array size");
        int sum = 0;
        while (from <= to) {
            sum += arr[from];
            from++;
        }
        return sum;
    }
}
