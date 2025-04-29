package com.sliding_windows;

public class CountSubarrayWithMaxEleAppearAtLeastKth_2962 {
    public long countSubarrays(int[] nums, int k) {
        int maxEle = -1, maxCount = 0;
        long res = 0;
        int left = 0, n = nums.length;
        for (int right = 0; right < n; right++){
            if (nums[right] > maxEle){
                maxEle = nums[right];
                maxCount = 1;
            } else if (nums[right] == maxEle) {
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
