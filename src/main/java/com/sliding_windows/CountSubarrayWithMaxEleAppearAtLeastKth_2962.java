package com.sliding_windows;

import java.util.Arrays;

public class CountSubarrayWithMaxEleAppearAtLeastKth_2962 {
    public long countSubarrays(int[] nums, int k) {
        int maxEle = Arrays.stream(nums).max().getAsInt(), maxCount = 0;
        long res = 0;
        int left = 0, n = nums.length;
        for (int right = 0; right < n; right++){
            if (nums[right] == maxEle) {
                maxCount++;
            }
            if (maxCount == k) res += n - right;
            while (left <= right && maxCount >= k){
                if (nums[left] == maxEle) maxCount--;
                left++;
                if (maxCount == k) res += n - right;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        CountSubarrayWithMaxEleAppearAtLeastKth_2962 c = new CountSubarrayWithMaxEleAppearAtLeastKth_2962();
        c.countSubarrays(new int[]{1,3,2,3,3}, 2);
    }
}
