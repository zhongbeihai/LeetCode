package com.simulation;

public class Maximum69Number_1323 {
    public int maximum69Number (int num) {
        char[] nums = String.valueOf(num).toCharArray();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == '6') {
                nums[i] = '9';
                return Integer.parseInt(String.valueOf(nums));
            }
        }

        return num;
    }
}
