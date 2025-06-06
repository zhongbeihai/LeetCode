package com.prefixsum;

public class ProductOfArrayExceptSelf_238 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];

        prefix[0] = 1;
        suffix[n - 1] = 1;
        for (int i = 1; i < n; i++){
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }

        for (int i = n - 2; i >=0; i--){
            suffix[i] = suffix[i + 1] * nums[i + 1];
        }

        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = suffix[i] * prefix[i];
        }

        return arr;
    }

    public static void main(String[] args) {
        ProductOfArrayExceptSelf_238 p = new ProductOfArrayExceptSelf_238();
        p.productExceptSelf(new int[]{1,2,3,4});
    }
}
