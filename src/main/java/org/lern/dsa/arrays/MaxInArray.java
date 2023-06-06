package org.lern.dsa.arrays;

public class MaxInArray {
    // T= O(N)
    // S = O(1)
    public int maxValue(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int value : arr)
            if (value > max)
                max = value;
        return max;
    }

    // T= O(N + N)
    // S = O(1)
    public int firstMaxIndex(int[] arr) {
        if (arr.length == 0)
            return -1;
        int max = maxValue(arr);
        int i = 0;
        while (i < arr.length) {
            if (arr[i] == max)
                break;
            i++;
        }
        return i;
    }

    // T= O(N)
    // S = O(1)
    public int firstMaxIndexApproach2(int[] arr) {
        if (arr.length == 0)
            return -1;
        int max = arr[0];
        int maxIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                maxIndex = i;
                max = arr[i];
            }
        }
        return maxIndex;
    }

    // T= O(N)
    // S = O(1)
    public int lastMaxIndex(int[] arr) {
        if (arr.length == 0)
            return -1;
        int max = arr[0];
        int maxIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            // here it is changed
            if (arr[i] >= max) {
                maxIndex = i;
                max = arr[i];
            }
        }
        return maxIndex;
    }
}
