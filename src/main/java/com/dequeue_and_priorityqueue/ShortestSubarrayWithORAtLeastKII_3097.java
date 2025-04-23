package com.dequeue_and_priorityqueue;

import java.util.Arrays;

public class ShortestSubarrayWithORAtLeastKII_3097 {
    public int minimumSubarrayLength(int[] nums, int k) {
        int left = 0, right = 0;
        int tem = 0;
        int minSize = Integer.MAX_VALUE;
        Arrays.sort(nums);
        while (right < nums.length ){
            tem |= nums[right];

            while (tem >= k && left <= right){
                minSize = Math.min(minSize, right - left + 1);
                tem = tem & ~nums[left];
                left++;
            }

            right++;
        }
        return minSize == Integer.MAX_VALUE ? -1 : minSize;
    }

    public static void main(String[] args) {
        ShortestSubarrayWithORAtLeastKII_3097 s =new ShortestSubarrayWithORAtLeastKII_3097();
        //s.minimumSubarrayLength(new int[]{1,2,32,21}, 55);
        System.out.println(2 | 32 | 21);
    }
}
