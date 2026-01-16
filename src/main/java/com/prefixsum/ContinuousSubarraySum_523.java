package com.prefixsum;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum_523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        // sum(i, j) % k == 0;
        // (prefixSum[j] - prefixSum[i]) % k == 0;
        // prefixSum[j] % k == prefixSum[i] % k

        int n = nums.length;
        if (k == 0) {
            for (int i = 1; i < n; i++) {
                if (nums[i] == 0 && nums[i - 1] == 0) return true;
            }
            return false;
        }


        int[] p = new int[n];
        p[0] = nums[0];
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        map.putIfAbsent(p[0] % k, 0);
        for (int i = 1; i < n; i++) {
            p[i] = p[i - 1] + nums[i];
            if (map.containsKey(p[i] % k) ){
                if (i - map.get(p[i] % k) >= 2) return true;
            }else {
                map.put(p[i] % k, i);
            }
        }


        return false;
    }

    public static void main(String[] args) {
        ContinuousSubarraySum_523 c = new ContinuousSubarraySum_523();
        c.checkSubarraySum(new int[]{23,2,4,6,6}, 7);
    }
}
