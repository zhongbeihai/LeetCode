package com.prefixsum;

import java.util.HashMap;
import java.util.List;

public class CountOfInterestingSubarrays_2845 {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        long count = 0L, equals = 0L;
        HashMap<Integer, Long> map = new HashMap<>();
        map.put(0, 1L);
        for (int num: nums){
            if (num % modulo == k) equals++;
            int rem = (int) (equals % modulo);

            int needed = (rem - k + modulo) % modulo;
            count += map.getOrDefault(needed, 0L);
            map.put(rem, map.getOrDefault(rem, 0L) + 1);
        }

        return count;
    }
}
