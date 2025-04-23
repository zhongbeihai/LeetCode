package com.sliding_windows;

public class LongestNiceArray_2401 {
    public int longestNiceSubarray(int[] nums) {
        int left = 0, maxlen = 0;
        int and = 0;
        for (int right = left + 1; right < nums.length; right++){
            while ((and & nums[right]) != 0){
                and ^=  nums[left];
                left++;
            }

            and |= nums[right];
            maxlen = Math.max(maxlen, right - left + 1);
        }

        return maxlen;
    }

    public static void main(String[] args) {
        LongestNiceArray_2401 l = new LongestNiceArray_2401();
        l.longestNiceSubarray(new int[]{1,3,8,48,10});
    }
}
