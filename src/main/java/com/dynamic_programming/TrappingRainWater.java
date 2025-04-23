package com.dynamic_programming;

public class TrappingRainWater {
    public int trap(int[] height) {
        int[] maxToRight = new int[height.length];
        int[] maxToLeft = new int[height.length];
        int count = 0;

        for(int i = height.length - 2; i >= 0; i--){
            maxToRight[i] = Math.max(maxToRight[i + 1], height[i + 1]);
        }

        for(int i = 1; i < height.length; i++){
            maxToLeft[i] = Math.max(maxToLeft[i - 1], height[i - 1]);
        }

        for(int i = 1; i < height.length; i++){
            int min = Math.min(maxToRight[i], maxToLeft[i]);
            if(min > height[i]){
                count += min - height[i];
            }
        }

        return count;
    }
}
