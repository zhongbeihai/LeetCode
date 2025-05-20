package com.prefixsum;

public class ZeroArrayTransformationI_3355 {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] diff = new int[n + 1];
        for(int[] query : queries){
            diff[query[0]]--;
            diff[query[1] + 1]++;
        }

        for (int i = 1; i <= n; i++) {
            diff[i] += diff[i - 1];
            nums[i - 1] += diff[i - 1];
            if (nums[i - 1] > 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        ZeroArrayTransformationI_3355 z = new ZeroArrayTransformationI_3355();
        z.isZeroArray(new int[]{1,0,1}, new int[][]{{0,2}});
    }
}
