package com.dynamic_programming;

public class HouseRobber_198 {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n]; // dp[i] -> the maximum money we can get from robbing house i;

        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            // dp[i] = (nums[i] + dp[i - 2], dp[i - 1])
            int p = i - 1 >= 0 ? dp[i - 1] : 0;
            int q = i - 2 >= 0 ? dp[i - 2] : 0;
            dp[i] = Math.max(nums[i] + q, p);
            res = Math.max(res, dp[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        HouseRobber_198 n = new HouseRobber_198();
        n.rob(new int[]{2,1,1,2});
    }
}
