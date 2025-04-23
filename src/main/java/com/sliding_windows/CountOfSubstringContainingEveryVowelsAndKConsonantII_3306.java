package com.sliding_windows;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CountOfSubstringContainingEveryVowelsAndKConsonantII_3306 {
    public long atLeastK(String word, int k) {
        int left = 0, currentK = 0;
        int res = 0;
        char[] words = word.toCharArray();
        HashSet<Character> vowels = Stream.of('a','e','o','i','u').
                collect(Collectors.toCollection(HashSet::new));
        HashMap<Character, Integer> vowelMap = new HashMap<>();

        for (int right = 0; right < words.length; right++){
            char rightChar = words[right];

            if (vowels.contains(rightChar)){
                vowelMap.put(rightChar, vowelMap.getOrDefault(rightChar, 0) + 1);
            }else {
                currentK++;
            }

            while (vowelMap.size() == 5 && currentK >= k){
                char leftChar = words[left];
                if (vowelMap.containsKey(leftChar)){
                    vowelMap.put(leftChar, vowelMap.get(leftChar) - 1);
                    if (vowelMap.get(leftChar) == 0) vowelMap.remove(leftChar);
                }else {
                    currentK--;
                }
                left++;
            }

        }

        return res;
    }


    public static void main(String[] args) {
        CountOfSubstringContainingEveryVowelsAndKConsonantII_3306 c = new CountOfSubstringContainingEveryVowelsAndKConsonantII_3306();

    }
}
