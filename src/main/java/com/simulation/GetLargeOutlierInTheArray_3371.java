package com.simulation;

import java.util.Arrays;
import java.util.Comparator;

public class GetLargeOutlierInTheArray_3371 {
    public int getLargestOutlier(int[] nums) {
        nums = Arrays.stream(nums).boxed()
                .sorted((a,b) -> Integer.compare(Math.abs(a), Math.abs(b)))
                .mapToInt(Integer::intValue).toArray();
        int sum = Arrays.stream(nums).sum();
        int n = nums.length;
        for (int j = n - 1; j >= 0; j--){
            int p = 0;
            if (j != n - 1) p = nums[n - 1];
            else p = nums[n - 2];
            if (sum - nums[j] - p == p) return nums[j];
        }

        return -1;
    }

    public static void main(String[] args) {
        GetLargeOutlierInTheArray_3371 g = new GetLargeOutlierInTheArray_3371();
        g.getLargestOutlier(new int[]{-2,-1,-3,-6,4});
    }
}
