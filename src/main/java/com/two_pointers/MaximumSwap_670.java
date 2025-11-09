package com.two_pointers;

import java.util.Arrays;

public class MaximumSwap_670 {
    public int maximumSwap(int num) {
        char[] nums = String.valueOf(num).toCharArray();

        for (int i = 0; i < nums.length; i++){
            int p = nums.length - 1, biggestIdx = i;
            while (p > i){
                if (nums[p] > nums[biggestIdx]) biggestIdx = p;
                p--;
            }
            if (biggestIdx != i){
                char tem = nums[i];
                nums[i] = nums[biggestIdx];
                nums[biggestIdx] = tem;
                break;
            }
        }

        return Integer.parseInt(String.valueOf(nums));
    }

    public static void main(String[] args) {
        MaximumSwap_670 m = new MaximumSwap_670();
        m.maximumSwap(3726);
    }

}
