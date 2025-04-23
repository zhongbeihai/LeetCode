package com.dynamic_programming;

public class MaximumAlternatingSubsequenceSum_1911 {
    public long maxAlternatingSum(int[] nums) {
        // dp0[i] 表示到 i 处，最佳子序列长度为偶数时的最大交替和
        // dp1[i] 表示到 i 处，最佳子序列长度为奇数时的最大交替和
        long[] dp0 = new long[nums.length], dp1 = new long[nums.length];

        dp0[0] = nums[0];

        for(int i = 1; i < nums.length; i++){
            dp0[i] = Math.max(dp0[i - 1], dp1[i - 1] + nums[i]);
            dp1[i] = Math.max(dp0[i - 1] - nums[i], dp1[i -1]);
        }

        return Math.max(dp0[nums.length - 1], dp1[nums.length - 1]);
    }

    public static void main(String[] args) {
        MaximumAlternatingSubsequenceSum_1911 m = new MaximumAlternatingSubsequenceSum_1911();
        m.maxAlternatingSum(new int[]{4,2,5,3});
    }
}
