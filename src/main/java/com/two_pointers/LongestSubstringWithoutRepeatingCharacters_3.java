package com.two_pointers;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters_3 {
    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) return 0;

        int left = 0, res = 1;
        int[] fre = new int[128];
        for (int right = 0; right < s.length(); right++){
            int cur = s.charAt(right);
            fre[cur]++;
            while (left <= right && fre[cur] > 1){
                fre[s.charAt(left)]--;
                left++;
            }
            res = Math.max(res, right - left + 1);
        }

        return res;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters_3 l = new LongestSubstringWithoutRepeatingCharacters_3();
        l.lengthOfLongestSubstring("pwwkew");
    }
}
