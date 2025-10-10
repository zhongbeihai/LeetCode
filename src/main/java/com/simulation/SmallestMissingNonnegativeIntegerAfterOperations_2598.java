package com.simulation;

import java.util.*;

public class SmallestMissingNonnegativeIntegerAfterOperations_2598 {
    public int findSmallestInteger(int[] nums, int value) {
        int[] cnt = new int[value];

        for (int x: nums){
            int m = mod(x, value);
            cnt[m]++;
        }

        int i = 0;
        while (true){
            int m = i % value;
            if (cnt[m] > 0) {
                cnt[m]--;
                i++;
            }else {
                return i;
            }
        }
    }

    public int mod(int num, int m){
        int r = num % m;
        if (r < 0) r += m;

        return r;
    }

    public static void main(String[] args) {
        SmallestMissingNonnegativeIntegerAfterOperations_2598 s = new SmallestMissingNonnegativeIntegerAfterOperations_2598();
        s.findSmallestInteger(new int[]{0,3,1,1,2,2,0,0,2,2,3,2}, 4);
    }
}
