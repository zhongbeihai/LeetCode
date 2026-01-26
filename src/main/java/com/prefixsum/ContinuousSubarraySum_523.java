package com.prefixsum;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum_523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> restLastOccurIdx = new HashMap<>();
        restLastOccurIdx.put(0, -1);

        int curSum = 0;
        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];

            int r = curSum % k;
            if (r < 0) r += k;
            if (restLastOccurIdx.containsKey(r)){
                if (i - restLastOccurIdx.get(r) > 1 )return true;
            }else {
                restLastOccurIdx.put(r, i);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        ContinuousSubarraySum_523 c = new ContinuousSubarraySum_523();
        c.checkSubarraySum(new int[]{2, 4, 3}, 6);
    }
}
