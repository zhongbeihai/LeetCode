package com.dynamic_programming;

public class TrappingRainWater {
    public int trap(int[] height) {
        int n = height.length;
        int[] maxToRight = new int[n]; // maxToRight[i] -> first bigger right neighbor
        int[] maxToLeft = new int[n];

        for (int i = 1; i < n; i++) {
            maxToLeft[i] = Math.max(maxToLeft[i - 1], height[i - 1]);
        }

        for (int i = n - 2; i >= 0 ; i--) {
            maxToRight[i] = Math.max(maxToRight[i + 1], height[i + 1]);
        }

        int res = 0;
        for (int i = 1; i < n - 1; i++) {
            int neighborMin = Math.min(maxToRight[i], maxToLeft[i]);

            if (height[i] < neighborMin) res += neighborMin - height[i];
        }

        return res;
    }
}
