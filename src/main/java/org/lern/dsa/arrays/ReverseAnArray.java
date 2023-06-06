package org.lern.dsa.arrays;

public class ReverseAnArray {

    public void reverseInPlace(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
    }

    public void reverseInPlaceTwoPointerMethod(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public <T> void genericReverseInPlace(T[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            T temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

}
