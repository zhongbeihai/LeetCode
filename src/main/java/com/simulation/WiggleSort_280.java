package com.simulation;

import java.util.Arrays;

public class WiggleSort_280 {
    public void wiggleSort(int[] nums) {
        if (nums.length == 1) return;
        Arrays.sort(nums);
        int n = nums.length;
        int[] res = new int[n];

        for (int i = 0, j = n - 1, k = 0; i <= j && k < n; i++, j--, k += 2){
            res[k] = nums[i];
            if(k + 1 < n) res[k + 1] = nums[j];
        }

        for (int i = 0; i < n; i++){
            nums[i] = res[i];
        }
    }
}
