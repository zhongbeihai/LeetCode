package com.sliding_windows;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class CountVowelsSubstringOfAString_2062 {
    public int countVowelSubstrings(String word) {
        int  left = 0, leftStart = 0, res = 0;
        char[] words = word.toCharArray();
        HashMap<Character, Integer> vowelsCount = new HashMap<>();

        for (int right = 0; right < words.length; right++){
            char rightChar = words[right];

            // when rightChar is not vowel, reset window
            if (!isVowel(rightChar)){
                vowelsCount.clear();
                left = right + 1;
                leftStart = right + 1;
                continue;
            }

            if (vowelsCount.containsKey(rightChar)) leftStart = right;
            vowelsCount.put(rightChar, vowelsCount.getOrDefault(rightChar, 0) + 1);

            while (vowelsCount.size() == 5){
                res += (right - leftStart) + 1;
                char leftChar = words[leftStart];
                vowelsCount.put(leftChar, vowelsCount.get(leftChar) - 1);
                if (vowelsCount.get(leftChar) == 0) vowelsCount.remove(leftChar);
                leftStart++;
            }
        }

        return res;
    }

    private boolean isVowel(char c) {
        return "aeiou".indexOf(c) != -1;
    }

    public static void main(String[] args) {
        CountVowelsSubstringOfAString_2062 c = new CountVowelsSubstringOfAString_2062();
        c.countVowelSubstrings("cuaieuouac");
    }
}
