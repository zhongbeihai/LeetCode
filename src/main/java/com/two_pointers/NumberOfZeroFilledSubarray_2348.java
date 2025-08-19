package com.two_pointers;

public class NumberOfZeroFilledSubarray_2348 {
    public long zeroFilledSubarray(int[] nums) {
        int left = 0, cnt = 0;
        for (int right = 0; right < nums.length; right++){
            if (nums[right] == 0){
                cnt += right - left + 1;
            }else {
                left = right;
                if (nums[left] != 0) left++;
            }
        }

        return cnt;
    }
}
