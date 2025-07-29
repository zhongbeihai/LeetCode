package com.sliding_windows;

public class MinimumSizesSubarrayInInfiniteArray_2875 {
    public int minSizeSubarray(int[] nums, int target) {
        int sum = 0, n = nums.length;
        for (int num: nums){
            sum += num;
        }

        int fullRepeats = target / sum;
        int remainTarget = target % sum;

        int[] doubleNums = new int[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            doubleNums[i] = nums[i % n];
        }

        int left = 0, windowSum = 0, minWindowLen = Integer.MAX_VALUE;
        for (int right = 0; right < 2 * n; right++){
            windowSum += doubleNums[right];

            while (left <= right && windowSum > remainTarget){
                windowSum -= doubleNums[left];
                left++;
            }

            if (windowSum == remainTarget) minWindowLen = Math.min(minWindowLen, right - left + 1);
        }

        if (target == 0) return 0;
        return minWindowLen == Integer.MAX_VALUE ? -1 : fullRepeats * n + minWindowLen;
    }
}
