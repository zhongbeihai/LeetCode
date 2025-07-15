package com.two_pointers;

public class ApplyOperationsToArray_2460 {
    public int[] applyOperations(int[] nums) {
        if (nums.length < 2) return nums;
        int p1 = 0, p2 = 1;
        while (p2 < nums.length){
            if (nums[p1] == nums[p2]){
                nums[p1] *= 2;
                nums[p2] = 0;
            }
            p1++;
            p2++;
        }

        int[] res = new int[nums.length];
        int c = 0;
        for (int num : nums) {
            if (num != 0) {
                res[c] = num;
                c++;
            }

        }

        return res;
    }
}
