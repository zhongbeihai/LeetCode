package com.sliding_windows;

public class FindNumbersWithEvenNumberOfDigits_1295 {
    public int findNumbers(int[] nums) {
        int res = 0;
        for (int num: nums){
            int digits = String.valueOf(num).length();
            if (digits % 2 == 0) res++;
        }

        return res;
    }
}
