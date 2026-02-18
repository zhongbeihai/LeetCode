package com.simulation;

public class SquaresOfASortedArray_977 {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;

        int p = 0;
        while (p + 1< n && Math.abs(nums[p]) >= Math.abs(nums[p + 1])) p++;
        int f = p + 1;

        int[] res = new int[n];
        int i = 0;
        while (p >= 0 && f < n){
            if (Math.abs(nums[p]) > Math.abs(nums[f])) {
                res[i++] = nums[p] * nums[p];
                p--;
            } else {
                res[i++] = nums[f] * nums[f];
                f++;
            }
        }
        while (p >= 0){
            res[i++] = nums[p] * nums[p];
            p--;
        }
        while (f < n){
            res[i++] = nums[f] * nums[f];
            f++;
        }

        return res;
    }
}
