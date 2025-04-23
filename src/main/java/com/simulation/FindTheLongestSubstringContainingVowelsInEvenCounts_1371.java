package com.simulation;

import java.util.HashMap;

public class FindTheLongestSubstringContainingVowelsInEvenCounts_1371 {
    public int findTheLongestSubstring(String s) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = s.length();
        int maxLength = 0, mask = 0;
        char[] ss = s.toCharArray();
        map.put(0, -1);
        for (int i = 0; i < n; i++){
            char c = ss[i];
            if (c == 'a') mask ^= (1 << 0);
            else if (c == 'e') mask ^= (1 << 1);
            else if (c == 'i') mask ^= (1 << 2);
            else if (c == 'o') mask ^= (1 << 3);
            else if (c == 'u') mask ^= (1 << 4);

            if (map.containsKey(mask)){
                maxLength = Math.max(maxLength, i - map.get(mask));
            }else {
                map.put(mask, i);
            }
        }

        return maxLength;
    }
}
