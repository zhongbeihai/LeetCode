package com.two_pointers;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters_3 {
    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) return 0;
        char[] ss = s.toCharArray();
        int[] fre = new int[128];
        int left = 0, max = 1;
        for (int right = 0; right < ss.length; right++){
            fre[ss[right]]++;
            while (fre[ss[right]] > 1){
                fre[ss[left]]--;
                left++;
            }
            max = Math.max(max, right - left + 1);
        }

        return max;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters_3 l = new LongestSubstringWithoutRepeatingCharacters_3();
        l.lengthOfLongestSubstring("abcabcbb");
    }
}
