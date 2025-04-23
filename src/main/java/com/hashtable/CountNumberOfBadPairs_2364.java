package com.hashtable;

import java.util.*;

public class CountNumberOfBadPairs_2364 {
    public long countBadPairs(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            int key = nums[i] - i;
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        long totalPairs = (long) n * (n - 1) / 2;

        // Step 3: 计算好对数
        long goodPairs = 0;
        for (int freq : map.values()) {
            goodPairs += (long) freq * (freq - 1) / 2;
        }

        // Step 4: 坏对数 = 总对数 - 好对数
        return totalPairs - goodPairs;
    }

    public static void main(String[] args) {
        CountNumberOfBadPairs_2364 c = new CountNumberOfBadPairs_2364();
        c.countBadPairs(new int[]{1,2,2});
    }
}
