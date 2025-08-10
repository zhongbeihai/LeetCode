package com.hashtable;

import java.util.*;

public class LongestConsecutiveSequence_128 {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();

        int res = 1;
        for (int num: nums){
            if (map.containsKey(num - 1)){
                res = Math.max(res, map.get(num - 1) + 1);
                map.put(num, map.get(num - 1) + 1);
            }else {
                map.put(num, 1);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        LongestConsecutiveSequence_128 l = new LongestConsecutiveSequence_128();
        l.longestConsecutive(new int[]{1,0,1,2});
    }
}
