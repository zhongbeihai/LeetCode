package com.sliding_windows;

public class LongestSubarrayOf1AfterDeletingOneElement_1493 {
    public int longestSubarray(int[] nums) {
        int maxLen = 0, zeroCnt = 0;
        int left = 0, n = nums.length;

        for (int right = 0; right < n; right++){
            while(left <= right && zeroCnt > 0 && nums[right] == 0){
                if (nums[left] == 0) zeroCnt--;
                left++;
            }

            if (nums[right] == 0) zeroCnt++;

            maxLen = Math.max(right - left, maxLen);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        LongestSubarrayOf1AfterDeletingOneElement_1493 l = new LongestSubarrayOf1AfterDeletingOneElement_1493();
        l.longestSubarray(new int[]{1,1,0,1});
    }
}
