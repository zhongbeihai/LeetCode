package com.search;

import com.binary_tree.FindUniqueBinaryString_1980;

public class FindMinimumInRotatedArray_153 {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;
        int ans = Integer.MAX_VALUE;
        while (low <= high){
            int mid = low + (high - low) / 2;
            if(nums[low]==nums[mid]&&nums[mid]==nums[high])
            {
                ans = Math.min(ans,nums[high]);
                high--;
                low++;
                continue;
            }

            if (nums[low] <= nums[mid]){
                ans = Math.min(ans, nums[low]);
                low = mid + 1;
            }else {
                ans = Math.min(ans, nums[mid]);
                high = mid -1;
            }
        }
        return nums[low];
    }

    public static void main(String[] args) {
        FindMinimumInRotatedArray_153 f = new FindMinimumInRotatedArray_153();
        //f.findMin(new int[]{13, 14, 0, 1, 2, 3, 4,5,6});
        // f.findMin(new int[]{2,2,2,0,1});
        f.findMin(new int[]{3,3,1,3});
    }
}
