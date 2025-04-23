package com.sliding_windows;

import java.util.HashMap;
import java.util.HashSet;

public class NumberOfSubarrayContainsAllThreeCharacters_1358 {
    public int numberOfSubstrings(String s) {
        int left = 0, n = s.length();
        int res = 0;
        char[] ss = s.toCharArray();
        HashMap<Character, Integer> set = new HashMap<>();

        for (int right = 0; right < n; right++){
            char rightChar = ss[right];
            set.put(rightChar, set.getOrDefault(rightChar, 0) + 1);

            while (left < right && set.size() >= 3){
                res += n - right;
                char leftChar = ss[left];
                set.put(leftChar, set.get(leftChar) - 1);
                if (set.get(leftChar) == 0) set.remove(leftChar);
                left++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        NumberOfSubarrayContainsAllThreeCharacters_1358 n = new NumberOfSubarrayContainsAllThreeCharacters_1358();
        n.numberOfSubstrings("abcabc");
    }
}
