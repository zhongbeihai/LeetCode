package com.dynamic_programming;

public class HouseRobber_198 {
    public int rob(int[] nums) {
        // dp[i] is the largest money can get from 0 - ith
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        if(nums.length < 2) return dp[0];
        dp[1] = nums[1];
        if(nums.length < 3) return Math.max(dp[0], dp[1]);

        for (int i = 2; i < nums.length; i++){
            if(i - 3 >= 0){
                dp[i] = Math.max(dp[i - 3],dp[i - 2] ) + nums[i];
            }else {
                dp[i] = dp[i - 2] + nums[i];
            }
        }

        return Math.max(dp[nums.length - 1], dp[nums.length - 2]);
    }

    public static void main(String[] args) {
        HouseRobber_198 n = new HouseRobber_198();
        n.rob(new int[]{2,1,1,2});
    }
}
