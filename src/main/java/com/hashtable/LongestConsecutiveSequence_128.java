package com.hashtable;

import java.util.*;

public class LongestConsecutiveSequence_128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num: nums){
            set.add(num);
        }

        int maxL = 0;
        for (int i: set) {
            if (set.contains(i - 1)) continue;

            int cur = i, cnt = 1;
            while (set.contains(cur + 1)){
                cur++;
                cnt++;
            }
            maxL = Math.max(maxL, cnt);
        }

        return maxL;
    }

    public static void main(String[] args) {
        LongestConsecutiveSequence_128 l = new LongestConsecutiveSequence_128();
        l.longestConsecutive(new int[]{1,0,1,2});
    }
}
