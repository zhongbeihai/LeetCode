package com.simulation;

public class PalindromeNumber_9 {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;

        char[] nums = String.valueOf(x).toCharArray();
        int h = 0, r = nums.length - 1;
        while (h < r){
            if (nums[h] == nums[r]){
                h++;
                r--;
            }else {
                return false;
            }
        }

        return true;
    }
}
