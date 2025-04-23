package com.prefixsum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MakeSumDividiedByP_1590 {
    public int minSubarray(int[] nums, int p) {
        int sum = 0;
        for (int num : nums) {
            sum = (sum + num) % p;
        }
        // prefixSum[i] ->
        int prefixSum = 0;
        int res = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            prefixSum = (prefixSum + nums[i]) % p;
            int key = (prefixSum - sum + p) % p;
            if (map.containsKey(key)) {
                int l = map.get(key);
                res = Math.min(res, i + 1 - l);
            }

            map.put(prefixSum, i + 1);
        }
        return res == nums.length ? -1 : res;
    }

    public static void main(String[] args) {
        MakeSumDividiedByP_1590 m = new MakeSumDividiedByP_1590();
        System.out.println(0 % 7);
        m.minSubarray(new int[]{1000000000,1000000000,1000000000}, 3);
    }
}
