package com.dynamic_programming;

import java.util.Arrays;

public class BestSightseeingPair_1014 {
    public int maxScoreSightseeingPair(int[] values) {
        int[] cvalue = new int[values.length];
        int maxFixed = 0;
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < values.length;i++){
            ans = Math.max(ans, maxFixed + values[i] - i);
            maxFixed = Math.max(maxFixed, values[i] + i);
        }
        return ans;

    }

    public static void main(String[] args) {
        BestSightseeingPair_1014 b = new BestSightseeingPair_1014();
        b.maxScoreSightseeingPair(new int[]{8,1,5,2,6});
    }
}
