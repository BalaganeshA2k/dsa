package org.lern.dsa.arrays.prefixsum;

public class EquilibriumIndex {
    private PrefixSumOfArray prefixSumOfArray;

    public EquilibriumIndex(PrefixSumOfArray prefixSumOfArray) {
        this.prefixSumOfArray = prefixSumOfArray;
    }

    // T = O(N+N) ==> O(N)
    // S = O(N)
    public int solutionWithExtraSpace(int[] arr) {
        int[] prefixsum = prefixSumOfArray.prefixSum(arr);
        if (prefixsum[arr.length - 1] - prefixsum[0] == 0)
            return 0;
        for (int i = 1; i < arr.length; i++) {
            int leftSum = prefixsum[i - 1];
            int rightSum = prefixsum[arr.length - 1] - prefixsum[i];
            if (leftSum == rightSum)
                return i;
        }
        return -1;
    }

    // T = O(N+N) ==> O(N)
    // S = O(1)
    public int solutionWhenInPlaceAllowed(int[] arr) {
        prefixSumOfArray.prefixSumInPlace(arr);
        // check for first index
        if (arr[arr.length - 1] - arr[0] == 0)
            return 0;
        // check for 1 -> N-1
        for (int i = 1; i < arr.length; i++) {
            int leftSum = arr[i - 1];
            int rightSum = arr[arr.length - 1] - arr[i];
            if (leftSum == rightSum)
                return i;
        }
        return -1;
    }

    // T = O(N+N) ==> O(N)
    // S = O(1)
    // NOT A PREFIX SUM METHOD - CARRY FORWARD TECHNIQUE
    public int solutionWithoutExtraSpaceAndInPlaceCalculationNotAllowed(int[] nums) {
        double rightSum = 0;
        double leftSum = 0;
        for (int i = 1; i < nums.length; i++)
            rightSum += nums[i];

        // check for first index
        if (leftSum == rightSum)
            return 0;
        // check for 1 -> N-1
        for (int i = 1; i < nums.length; i++) {
            leftSum += nums[i - 1];
            rightSum -= nums[i];
            if (leftSum == rightSum)
                return i;
        }
        return -1;
    }
}
