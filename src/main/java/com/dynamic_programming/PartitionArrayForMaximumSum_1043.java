package com.dynamic_programming;

public class PartitionArrayForMaximumSum_1043 {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        // dp[i] -> maximum sum from 1 - i
        int[] dp = new int[arr.length + 1];

        for(int i= 0; i <= arr.length; i++){
            int m = 0;
            for(int j = 1; j <= k && i - j >=0; j++){
                m = Math.max(m, arr[i - j]);
                dp[i] = Math.max(dp[i], dp[i - j] + m * j);
            }
        }

        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        PartitionArrayForMaximumSum_1043 p = new PartitionArrayForMaximumSum_1043();
        p.maxSumAfterPartitioning(new int[]{1,15,7,9,2,5,10}, 3);
    }
}
