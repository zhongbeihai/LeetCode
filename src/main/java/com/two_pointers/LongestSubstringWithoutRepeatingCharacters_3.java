package com.two_pointers;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters_3 {
    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) return 0;

        Set<Character> set = new HashSet<>();
        int left = 0, maxL = 0;
        for (int right = 0; right < s.length(); right++){
            while (!set.add(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxL = Math.max(maxL, right - left + 1);
        }

        return maxL;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters_3 l = new LongestSubstringWithoutRepeatingCharacters_3();
        l.lengthOfLongestSubstring("pwwkew");
    }
}
