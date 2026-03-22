package com.sliding_windows;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostKDistinctCharacters_340 {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int n = s.length();
        char[] ss = s.toCharArray();
        Map<Character, Integer> fre = new HashMap<>();

        int left = 0, right = 0, maxLen = Integer.MIN_VALUE;
        while (right < n){
            fre.put(ss[right], fre.getOrDefault(ss[right], 0) + 1);
            while (fre.size() > k){
                fre.put(ss[left], fre.get(ss[left]) - 1);
                if (fre.get(ss[left]) == 0) fre.remove(ss[left]);
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }

        return maxLen == Integer.MIN_VALUE ? 0 : maxLen;
    }
}
