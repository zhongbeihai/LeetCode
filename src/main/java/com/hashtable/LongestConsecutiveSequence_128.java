package com.hashtable;

import java.util.*;

public class LongestConsecutiveSequence_128 {
    public int longestConsecutive(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for (int num: nums){
            set.add(num);
        }

        int maxLen = 0;
        for (int num: set){
            if (set.contains(num - 1)) continue;
            int cur = num, cnt = 0;
            while (set.contains(cur)){
                cnt++;
                cur++;
            }
            maxLen = Math.max(maxLen, cnt);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        LongestConsecutiveSequence_128 l = new LongestConsecutiveSequence_128();
        l.longestConsecutive(new int[]{1,0,1,2});
    }
}
