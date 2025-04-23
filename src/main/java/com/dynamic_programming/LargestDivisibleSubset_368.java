package com.dynamic_programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset_368 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        List<Integer>[] dp = new ArrayList[n];
        for (int i = 0; i < n; i++){
            dp[i] = new ArrayList<>();
            dp[i].add(nums[i]);
        }


        for (int i = 1; i < n; i++){
            int cur = 0;
            int idx = -1;
            for (int j = i - 1; j >= 0; j--){
                if (nums[i] % nums[j] == 0 && dp[i].size() + cur < dp[i].size() + dp[j].size()){
                    idx = j;
                    cur = dp[j].size();
                }
            }
            if (idx != -1)dp[i].addAll(dp[idx]);
        }

        int maxlen = -1;
        int m = 0;
        for (int i =0; i < n; i++){
            if (dp[i].size() > maxlen){
                maxlen = dp[i].size();
                m = i;
            }
        }

        return dp[m];
    }

    public static void main(String[] args) {
        LargestDivisibleSubset_368 l = new LargestDivisibleSubset_368();
        l.largestDivisibleSubset(new int[]{4,8,10,240});
    }
}
