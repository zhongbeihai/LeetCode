package com.sliding_windows;

public class SubarrayProductLessThanK_713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        int left = 0, cnt = 0, product = 1;

        for (int right = 0; right < n; right++){
            product *= nums[right];
            while (product >= k && left <= right){
                product /= nums[left];
                left++;
            }
            if (product < k) cnt += right - left + 1;
        }

        return cnt;
    }

    public static void main(String[] args) {
        SubarrayProductLessThanK_713 s= new SubarrayProductLessThanK_713();
        s.numSubarrayProductLessThanK(new int[]{10,5,2,6}, 100);
    }
}
