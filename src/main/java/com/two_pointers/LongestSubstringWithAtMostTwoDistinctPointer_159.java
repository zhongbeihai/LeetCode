package com.two_pointers;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostTwoDistinctPointer_159 {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int n = s.length();
        char[] ss = s.toCharArray();
        int left = 0, right = 0, maxL = 0;
        Map<Character, Integer> map = new HashMap<>();

        while (right < n){
            map.put(ss[right], map.getOrDefault(ss[right], 0) + 1);
            while (left <= right && map.size() > 2) {
                map.put(ss[left], map.get(ss[left]) - 1);
                if (map.get(ss[left]) == 0) map.remove(ss[left]);
                left++;
            }

            maxL = Math.max(maxL, right - left + 1);
            right++;
        }

        return maxL;
    }
}
