package com.search;

import java.util.Arrays;

public class FindTheSmallestDivisorGivenAThreshold_1283 {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1, high = Arrays.stream(nums).max().getAsInt();

        while (low < high) {
            int mid = (low + high) / 2;
            if (isValidDivisor(nums, mid, threshold)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    public boolean isValidDivisor(int[] nums, int divisor, int threshold) {
        int sum = 0;
        for (int num : nums) {
            sum += (num + divisor - 1) / divisor;
            if (sum > threshold) {
                return false;
            }
        }
        return sum <= threshold;
    }

    public static void main(String[] args) {
        FindTheSmallestDivisorGivenAThreshold_1283 f= new FindTheSmallestDivisorGivenAThreshold_1283();
        f.smallestDivisor(new int[]{1,2,5,9},6);
    }
}
