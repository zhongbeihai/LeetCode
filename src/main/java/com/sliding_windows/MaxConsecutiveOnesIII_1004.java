package com.sliding_windows;

import java.util.ArrayDeque;
import java.util.Queue;

public class MaxConsecutiveOnesIII_1004 {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length, countZero = 0, res = 0, left = 0;
        for (int right = 0; right < n; right++){
            if (nums[right] == 0) countZero++;
            while (countZero > k){
                if (nums[left] == 0) countZero--;
                left++;
            }
            res = Math.max(res, right - left + 1);
        }

        return res;
    }

    public static void main(String[] args) {
        MaxConsecutiveOnesIII_1004 m = new MaxConsecutiveOnesIII_1004();
        m.longestOnes(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3);
    }
}
