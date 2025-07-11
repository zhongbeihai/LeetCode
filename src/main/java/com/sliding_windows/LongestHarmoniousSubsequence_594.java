package com.sliding_windows;

import java.util.*;

public class LongestHarmoniousSubsequence_594 {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int start = 0, maxLen = 0;

        for (int end = 0; end < nums.length; end++) {
            // shrink window if diff > 1
            while (nums[end] - nums[start] > 1) {
                start++;
            }

            // check harmonious condition
            if (nums[end] - nums[start] == 1) {
                maxLen = Math.max(maxLen, end - start + 1);
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        LongestHarmoniousSubsequence_594 l = new LongestHarmoniousSubsequence_594();
        l.findLHS(new int[]{1,3,2,2,5,2,3,7});
    }
}
