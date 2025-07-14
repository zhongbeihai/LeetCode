package com.doublepointers;

import java.util.Arrays;

public class NumberOfSubsequenceThatSatisfyGivenSumCondition_1498 {
    public int numSubseq(int[] nums, int target) {
        int MOD = (int) (1E9 + 7);

        Arrays.sort(nums);
        int n = nums.length;
        int[] pow2 = new int[n];  // 预处理 2^i
        pow2[0] = 1;

        for (int i = 1; i < n; i++) {
            pow2[i] = (pow2[i - 1] * 2) % MOD;
        }

        int left = 0, right = n - 1, result = 0;

        while (left <= right) {
            if (nums[left] + nums[right] <= target) {
                result = (result + pow2[right - left]) % MOD;
                left++;
            } else {
                right--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        NumberOfSubsequenceThatSatisfyGivenSumCondition_1498 n = new NumberOfSubsequenceThatSatisfyGivenSumCondition_1498();
        n.numSubseq(new int[]{3,5,6,7}, 9);
    }
}
