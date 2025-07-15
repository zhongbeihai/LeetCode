package com.two_pointers;

public class NumberOfSubarrayWithBoundedMaximum_795 {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int l = 0, r = 0, res = 0, maxIdx = -1;

        while (l < nums.length){
            if (nums[r] >= left && nums[r] <= right){
                maxIdx = r;
            }
            if(nums[r] > right){
                r++;
                l = r;
                maxIdx = -1;
                continue;
            }
            if (maxIdx != -1){
                res += maxIdx - l + 1;
            }
            r++;
        }

        return res;
    }

    public static void main(String[] args) {
        NumberOfSubarrayWithBoundedMaximum_795 n = new NumberOfSubarrayWithBoundedMaximum_795();
        n.numSubarrayBoundedMax(new int[]{2,9,2,1,5,6}, 2, 8);
    }
}
