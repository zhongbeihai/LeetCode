package com.sliding_windows;

import java.util.HashMap;
import java.util.Map;

public class CountNumberOfNiceSubarray_1248 {
    public int numberOfSubarrays(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int oddCnt = 0, res = 0;
        for (int num: nums){
            if (num % 2 == 1) oddCnt++;
            res += map.getOrDefault(oddCnt - k, 0);

            map.put(oddCnt, map.getOrDefault(oddCnt, 0) + 1);
        }

        return res;
    }

    public static void main(String[] args) {
        CountNumberOfNiceSubarray_1248 c = new CountNumberOfNiceSubarray_1248();
        c.numberOfSubarrays(new int[]{2,2,2,1,2,2,1,2,2,2}, 2);
    }
}
