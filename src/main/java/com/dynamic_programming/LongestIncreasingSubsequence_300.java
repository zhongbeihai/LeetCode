package com.dynamic_programming;


import java.util.*;
import java.util.stream.Collectors;

public class LongestIncreasingSubsequence_300 {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n]; // dp[i] -> the longest increasing subsequence ending at i

        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
                res = Math.max(res, dp[i]);

            }
        }

        return res;
    }

    public int lengthOfLISImprove(int[] nums){
        // ith element stands for the first smallest element in nums for length i LIS
        List<Integer> sub = new ArrayList<>();

        for (int num : nums){
            int firstPlace = Collections.binarySearch(sub, num);

            if (firstPlace < 0){
                firstPlace = -(firstPlace + 1);
            }

            if (firstPlace == sub.size()){
                sub.add(num);
            }else {
                sub.set(firstPlace, num);
            }
        }

        return sub.size();
    }



    public static void main(String[] args) {
        LongestIncreasingSubsequence_300 l = new LongestIncreasingSubsequence_300();
        l.lengthOfLIS(new int[]{1,3,6,7,9,4,10,5,6});
    }
}
