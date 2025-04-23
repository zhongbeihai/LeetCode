package com.dynamic_programming;

import java.util.Arrays;

public class MaxConsecutiveOnesII_487 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int[] consecutiveOnesFromLeft = new int[n];
        int count = 0;
        for (int i = 0; i < n; i++){
            if (nums[i] == 1) count++;
            else count = 0;
            consecutiveOnesFromLeft[i] = count;
        }
        count = 0;
        int[] consecutiveOnesFromRight = new int[n];
        for (int i = n - 1; i >= 0; i--){
            if (nums[i] == 1) count++;
            else count = 0;
            consecutiveOnesFromRight[i] = count;
        }

        int res = Arrays.stream(consecutiveOnesFromLeft).max().getAsInt();
        for (int i = 0; i < n; i++){
            if (nums[i] == 1) continue;
            int l = 0, r = 0;
            if (i >= 1) l = consecutiveOnesFromLeft[i - 1];
            if (i + 1 < n) r = consecutiveOnesFromRight[i + 1];
            res = Math.max(res, l + r + 1);
        }

        return res;
    }

    public static void main(String[] args) {
        MaxConsecutiveOnesII_487 m = new MaxConsecutiveOnesII_487();
        m.findMaxConsecutiveOnes(new int[]{1,0,1,1,0});
    }
}
