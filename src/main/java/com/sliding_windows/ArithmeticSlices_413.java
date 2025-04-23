package com.sliding_windows;

public class ArithmeticSlices_413 {
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3) return 0;
        int left = 0, diff = nums[1] - nums[0];
        int res =0;
        for (int right = left + 1; right < nums.length; right++){
            if (nums[right] - nums[right - 1] == diff){
                if (right - left >= 2) res += right - left - 1;
            }else {
                while (left + 1< right){
                    if (nums[left + 1] - nums[left] != nums[right] - nums[right - 1]){
                        left++;
                    }
                }
                diff = nums[right] - nums[right - 1];
            }
        }

        return res;
    }

    public static void main(String[] args) {
        ArithmeticSlices_413 a = new ArithmeticSlices_413();
        a.numberOfArithmeticSlices(new int[]{1,2,3,4,7,8,9});
    }
}
