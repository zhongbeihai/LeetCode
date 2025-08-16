package com.dynamic_programming;


import java.util.*;
import java.util.stream.Collectors;

public class LongestIncreasingSubsequence_300 {
    public int lengthOfLIS(int[] nums) {
        // dp[i] -> The longest increasing subarray ending with nums[i]
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        int max = -1;
        for (int i = 1; i < nums.length; i++){
            for (int j = 0; j < i; j++){
                if (nums[i] > nums[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            max = Math.max(max, dp[i]);
        }

        return max;
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
        l.lengthOfLISImprove(new int[]{10,9,2,5,3,7,101,18});
    }
}
