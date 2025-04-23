package com.sliding_windows;

import java.util.HashMap;

public class LengthOfLongestSubarrayWithMostKFrequencies_2958 {
    public int maxSubarrayLength(int[] nums, int k) {
        int left = 0, right = 0;
        HashMap<Integer, Integer> fre = new HashMap<>();
        int maxLength = 0;
        while (right < nums.length){
            fre.put(nums[right], fre.getOrDefault(nums[right], 0) + 1);

            while (fre.get(nums[right]) > k && left <= right){
                fre.put(nums[left], fre.get(nums[left]) - 1);
                left++;
            }
            right++;
            maxLength = Math.max(maxLength, right - left);

        }

        return maxLength;
    }

    public static void main(String[] args) {
        LengthOfLongestSubarrayWithMostKFrequencies_2958 l = new LengthOfLongestSubarrayWithMostKFrequencies_2958();
        l.maxSubarrayLength(new int[]{1,2,3,1,2,3,1,2}, 2);
    }
}
