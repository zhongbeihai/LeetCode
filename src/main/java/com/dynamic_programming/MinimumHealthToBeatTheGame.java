package com.dynamic_programming;

import java.util.Arrays;
import java.util.EnumMap;

public class MinimumHealthToBeatTheGame {
    public long minimumHealth(int[] damage, int armor) {
        long sum = 0L;
        int max = 0;
        for (int num : damage){
            sum += num;
            max = Math.max(max , num);
        }

        if (armor > max) return sum - max;
        else return sum - armor;
    }
}
