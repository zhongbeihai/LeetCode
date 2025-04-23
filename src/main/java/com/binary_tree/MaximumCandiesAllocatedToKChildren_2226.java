package com.binary_tree;

import java.util.Arrays;

public class MaximumCandiesAllocatedToKChildren_2226 {
    public int maximumCandies(int[] candies, long k) {
        if (candies.length == 0) return 0;
        long maxCandies = 0;
        for (int candy: candies){
            maxCandies = Math.max(maxCandies, candy);
        }
        long left = 1, right =  Math.max(maxCandies, k);

        while (left <= right){
            long mid = left + (right - left) /2;
            if (isValidAllocate(candies, k , mid)){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }

        return (int)right;
    }

    public boolean isValidAllocate(int[] candies, long k, long allocation){
        long max = 0;
        for (int i: candies){
            max += (i / allocation);
            if (max >= k) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        MaximumCandiesAllocatedToKChildren_2226 m = new MaximumCandiesAllocatedToKChildren_2226();
        m.maximumCandies(new int[]{10000000}, 1000000000000L);
    }
}
