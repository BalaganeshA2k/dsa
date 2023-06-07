package org.lern.dsa.arrays.prefixsum;

public class PrefixSumOfArray {
    // T = O(N)
    // S = O(N)
    public int[] prefixSum(int[] arr) {
        int[] prefixSum = new int[arr.length];
        prefixSum[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }
        return prefixSum;
    }

    // T = O(N)
    // S = O(1)
    public void prefixSumInPlace(int[] arr) {
        for (int i = 1; i < arr.length; i++)
            arr[i] += arr[i - 1];
    }
}
