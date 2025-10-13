package com.dynamic_programming;

public class HouseRobber_198 {
    public int rob(int[] nums) {
        int n = nums.length;
        // dp[i] -> the largest money can get from house 0 to ith
        int[] dp = new int[n];
        dp[0] = nums[0];

        int res = 0;
        for (int i = 1; i < n; i++){
            int lastRobbed = i - 2 > 0 ? i - 2 : i;
            dp[i] = Math.max(dp[lastRobbed] + nums[i], dp[i - 1]);
            res = Math.max(res, dp[i]);
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        HouseRobber_198 n = new HouseRobber_198();
        n.rob(new int[]{2,1,1,2});
    }
}
