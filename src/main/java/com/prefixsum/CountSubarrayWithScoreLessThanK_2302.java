package com.prefixsum;

public class CountSubarrayWithScoreLessThanK_2302 {
    public long countSubarrays(int[] nums, long k) {
        int left = 0, n = nums.length;
        long curSum = 0, res = 0;


        for (int right = 0; right < n; right++){
            curSum += nums[right];

            if ((right - left + 1) * curSum < k) res += (right - left + 1);
            while (left <= right && (right - left + 1) * curSum >= k){
                curSum -= nums[left];
                left++;
                if ((right - left + 1) * curSum < k) res += (right - left + 1);
            }

        }

        return res;
    }

    public static void main(String[] args) {
        CountSubarrayWithScoreLessThanK_2302 c = new CountSubarrayWithScoreLessThanK_2302();
        // c.countSubarrays(new int[]{2,1,4,3,5}, 10);
        c.countSubarrays(new int[]{1,1,1}, 5);
    }
}
