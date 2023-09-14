package org.lern.dsa.arrays.carryforward;

public class CountOfPairs {

    public int bruteforceSolution(int[] arr, int left, int right) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == left) {
                int c = 0;
                for (int j = i + 1; j < arr.length; j++)
                    if (arr[j] == right)
                        c++;
                count += c;
            }
        }
        return count;
    }

    public int carryForwardSolution(int[] arr, int left, int right) {
        int count = 0;
        int rightCount = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == left)
                count += rightCount;
            if (arr[i] == right)
                rightCount++;
        }
        return count;
    }

    public int suffixSumSolution(int[] arr, int left, int right) {
        int count = 0;
        int[] countOfRightValues = new int[arr.length];
        for (int i = arr.length - 2; i >= 0; i--)
            countOfRightValues[i] = arr[i + 1] == right ? countOfRightValues[i + 1] + 1 : countOfRightValues[i + 1];
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == left)
                count += countOfRightValues[i];
        return count;

    }

}
