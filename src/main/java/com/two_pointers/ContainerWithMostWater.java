package com.two_pointers;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int maxArea = Integer.MIN_VALUE;
        int left = 0, right = height.length - 1;
        while (left < right){
            int availHeight = Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, (right - left) * availHeight);

            if (height[left] > height[right]) right--;
            else left++;
        }

        return maxArea;
    }

    public static void main(String[] args) {
        ContainerWithMostWater c = new ContainerWithMostWater();
        c.maxArea(new int[]{1,8,6,2,5,4,8,3,7});
    }
}
