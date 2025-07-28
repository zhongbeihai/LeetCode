package com.two_pointers;

public class CountHillsAndValleysInArray_2210 {
    public int countHillValley(int[] nums) {
        int left = 0, count = 0;

        for (int right = 1; right < nums.length - 1; right++){
            if (nums[right] == nums[right + 1]) continue;
            else {
                if ( (nums[right] < nums[left] && nums[right] < nums[right + 1]) || (nums[right] > nums[left] && nums[right] > nums[right + 1])) count++;
            }
            left = right;
        }

        return count;
    }

    public static void main(String[] args) {
        CountHillsAndValleysInArray_2210 c = new CountHillsAndValleysInArray_2210();
        c.countHillValley(new int[]{6,6,5,5,4,1});
    }
}
