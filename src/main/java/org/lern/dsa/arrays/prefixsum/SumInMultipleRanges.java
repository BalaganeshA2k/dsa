package org.lern.dsa.arrays.prefixsum;

// assume from and to have same length
// 0 <= from[i] < arr.length for 0 <= i < from.length
// 0 <= to[i] < arr.length for 0 <= i < to.length
// from[i] <= to[i] for 0 <= i < to.length
public class SumInMultipleRanges {

    // T = O(N^2)
    // S = O(1)
    int[] sumInMultipleRangesBruteForce(int[] arr, int[] from, int[] to) {
        // skipping from and to validation
        int[] result = new int[from.length];
        for (int i = 0; i < from.length; i++) {
            int left = from[i];
            int right = to[i];
            int sum = 0;
            while (left <= right) {
                sum += arr[left];
                left++;
            }
            result[i] = sum;
        }
        return result;
    }

    // T = O(N+N) ==> O(N)
    // S = O(N)
    public int[] sumInMultipleRangesPrefixSum(int[] arr, int[] from, int[] to) {
        // queryResult doesn't count as the output should be of size N and space
        // complexity is the extra space taken
        int[] queryResult = new int[from.length];
        int inputLength = arr.length;
        // Extra space of size N
        int[] prefixSum = new int[inputLength];
        prefixSum[0] = arr[0];
        for (int i = 1; i < inputLength; i++)
            prefixSum[i] = arr[i] + prefixSum[i - 1];
        for (int i = 0; i < from.length; i++) {
            int left = from[i];
            int right = to[i];
            if (left == 0)
                queryResult[i] = prefixSum[right];
            else
                queryResult[i] = prefixSum[right] - prefixSum[left - 1];

        }
        return queryResult;
    }

    // T = O(N+N) ==> O(N)
    // S = O(1)
    public int[] sumInMultipleRangesPrefixSumInPlace(int[] arr, int[] from, int[] to) {
        // queryResult doesn't count as the output should be of size N and space
        // complexity is the extra space taken
        int[] queryResult = new int[from.length];
        for (int i = 1; i < arr.length; i++)
            arr[i] = arr[i] + arr[i - 1];
        for (int i = 0; i < from.length; i++) {
            int left = from[i];
            int right = to[i];
            if (left == 0)
                queryResult[i] = arr[right];
            else
                queryResult[i] = arr[right] - arr[left - 1];

        }
        return queryResult;
    }
}
