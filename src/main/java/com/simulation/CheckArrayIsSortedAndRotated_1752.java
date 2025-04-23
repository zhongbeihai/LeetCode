package com.simulation;

import java.util.function.BinaryOperator;

public class CheckArrayIsSortedAndRotated_1752 {
    public boolean check(int[] nums) {
        int p = 0, count = 0, n = nums.length;
        while (p< nums.length){
            if (nums[(p + 1) % n] < nums[p]) count++;
            if (count == 2) return false;
            p++;

        }

        return true;
    }

    public static void main(String[] args) {
        CheckArrayIsSortedAndRotated_1752 c= new CheckArrayIsSortedAndRotated_1752();
        c.check(new int[]{3,4,5,1,2});
    }
}
