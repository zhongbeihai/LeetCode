package com.prefixsum;

public class ProductOfArrayExceptSelf_238 {
    public int[] productExceptSelf(int[] nums) {
        int zeroCnt = 0;
        int prod = 1;
        for (int num: nums){
            if (num != 0) prod *= num;
            else zeroCnt++;
        }

        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0){
                if (zeroCnt == 1) res[i] = prod;
                else res[i] = 0;
            }else {
                if (zeroCnt == 0) res[i] = prod / nums[i];
                else res[i] = 0;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        ProductOfArrayExceptSelf_238 p = new ProductOfArrayExceptSelf_238();
        p.productExceptSelf(new int[]{1,2,3,4});
    }
}
