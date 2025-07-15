package com.two_pointers;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int max = Integer.MIN_VALUE;
        int start = 0, end = height.length - 1;
        while (start < end){
            int w = end - start;
            int h = Math.min(height[start], height[end]);
            max = Math.max(max, w * h);
            if(height[start] < height[end]){
                start++;
            }else {
                end--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        ContainerWithMostWater c = new ContainerWithMostWater();
        c.maxArea(new int[]{1,8,6,2,5,4,8,3,7});
    }
}
