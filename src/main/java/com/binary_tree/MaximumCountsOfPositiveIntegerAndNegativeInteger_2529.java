package com.binary_tree;

public class MaximumCountsOfPositiveIntegerAndNegativeInteger_2529 {
    public int maximumCount(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (nums[mid] < 0) {
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        int leftBound = right;
        left = 0;
        right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] > 0){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        int rightBound = left;

        return Math.max(leftBound + 1, nums.length - rightBound);
    }

    public static void main(String[] args) {
        MaximumCountsOfPositiveIntegerAndNegativeInteger_2529 m = new MaximumCountsOfPositiveIntegerAndNegativeInteger_2529();
        m.maximumCount(new int[]{-2,-1,-1,1,2,3});
    }
}
