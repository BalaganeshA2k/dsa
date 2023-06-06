package org.lern.dsa.arrays;

public class RotateArray {
    public void rotateClockwiseUsingReverseMethod(int[] arr, int rotations) {
        if (rotations > arr.length)
            rotations %= arr.length;
        int lastIndex = arr.length - 1;
        reverse(arr, 0, lastIndex);
        reverse(arr, 0, rotations - 1);
        reverse(arr, rotations, lastIndex);
    }

    public void rotateAntiClockwise(int[] arr, int rotations) {
        if (rotations > arr.length)
            rotations %= arr.length;
        int lastIndex = arr.length - 1;
        rotations = arr.length - rotations;
        reverse(arr, 0, lastIndex);
        reverse(arr, 0, rotations - 1);
        reverse(arr, rotations, lastIndex);
    }

    private void reverse(int[] arr, int from, int to) {
        int temp = 0;
        while (from < to) {
            temp = arr[from];
            arr[from] = arr[to];
            arr[to] = temp;
            from++;
            to--;
        }
    }
}
