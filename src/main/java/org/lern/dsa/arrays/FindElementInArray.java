package org.lern.dsa.arrays;

public class FindElementInArray {

    public int solution(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == target)
                return i;
        return -1;
    }

    public <T> int genericSolution(T[] arr, T target) {
        for (int i = 0; i < arr.length; i++)
            if (arr[i].equals(target))
                return i;
        return -1;
    }
}
