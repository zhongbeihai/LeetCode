package com.hashtable;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeMap;

public class LongestConsecutiveSequence_128 {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        // <last number of sequence, the length of sequence>
        HashMap<Integer, Integer> map = new HashMap<>();

        Arrays.sort(nums);
        for (int num: nums){
            if (map.containsKey(num - 1)){
                map.put(num, map.get(num - 1) + 1);
                map.remove(num - 1);
            }else {
                if (!map.containsKey(num))map.put(num, 1);
            }
        }


        return map.values().stream().max(Comparator.comparingInt(o -> o)).get();
    }

    public static void main(String[] args) {
        LongestConsecutiveSequence_128 l = new LongestConsecutiveSequence_128();
        l.longestConsecutive(new int[]{1,0,1,2});
    }
}
