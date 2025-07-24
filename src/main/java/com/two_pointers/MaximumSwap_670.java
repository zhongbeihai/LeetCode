package com.two_pointers;

public class MaximumSwap_670 {
    public int maximumSwap(int num) {
        char[] nums = String.valueOf(num).toCharArray();

        for (int i = 0; i < nums.length; i++){
            int p = i;
            for (int j = nums.length - 1; j > i; j--){
                if (nums[j] - '0' > nums[p]  -'0') p = j;
            }
            if (p != i){
                char tem = nums[i];
                nums[i] = nums[p];
                nums[p] = tem;

                return Integer.parseInt(String.valueOf(nums));
            }
        }

        return num;
    }

    public static void main(String[] args) {
        MaximumSwap_670 m = new MaximumSwap_670();
        m.maximumSwap(3726);
    }

}
