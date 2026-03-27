package com.simulation;

import java.util.Arrays;

public class ValidTriangleNumber_611 {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);

        // fix the biggest edge
        int res = 0;
        for (int k = nums.length - 1; k >= 0; k--){
            int i = 0, j = k - 1;
            while (i < j){
                if (nums[i] + nums[j] > nums[k]){
                    res += j - i;
                    j--;
                }else {
                    i++;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        ValidTriangleNumber_611 v = new ValidTriangleNumber_611();
        v.triangleNumber(new int[]{2,2,3,4});
    }
}
