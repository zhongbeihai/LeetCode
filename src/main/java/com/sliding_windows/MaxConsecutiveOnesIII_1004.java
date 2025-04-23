package com.sliding_windows;

import java.util.ArrayDeque;
import java.util.Queue;

public class MaxConsecutiveOnesIII_1004 {
    public int longestOnes(int[] nums, int k) {
        int count = 0;
        int p1 = 0;
        int res = 0;
        Queue<Integer> zeros = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == 1) count++;
            else {
                zeros.add(i);
                if (k > 0) {
                    count++;
                    k--;
                }else {
                    int lastZeros = zeros.poll();
                    count -= lastZeros - p1;
                    p1 = lastZeros + 1;
                }
            }
            res = Math.max(count, res);
        }

        return count;
    }

    public static void main(String[] args) {
        MaxConsecutiveOnesIII_1004 m = new MaxConsecutiveOnesIII_1004();
        m.longestOnes(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3);
    }
}
