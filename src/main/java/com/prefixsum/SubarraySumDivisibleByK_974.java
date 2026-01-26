package com.prefixsum;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumDivisibleByK_974 {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> restFre = new HashMap<>();

        restFre.put(0, 1);
        int curSum = 0, cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];

            int r = curSum % k;
            if (r < 0) r += k;
            if (restFre.containsKey(r)) cnt += restFre.get(r);

            restFre.put(r, restFre.getOrDefault(r, 0) + 1);
        }

        return cnt;
    }

    public static void main(String[] args) {
        SubarraySumDivisibleByK_974 s = new SubarraySumDivisibleByK_974();
        s.subarraysDivByK(new int[]{4,5,0,-2,-3,1}, 5);
    }

}
