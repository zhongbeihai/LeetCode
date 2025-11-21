package com.simulation;

import java.util.HashSet;

public class UniqueLength3PalindromicSubsequences_1930 {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        char[] ss = s.toCharArray();
        int[] mostRight = new int[26];
        for (int i = n - 1; i >= 0 ; i--) {
            if (mostRight[ss[i] - 'a'] == 0) mostRight[ss[i] - 'a'] = i;
        }

        HashSet<Character> visited = new HashSet<>();
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (!visited.contains(ss[i]) && mostRight[ss[i] - 'a'] > i){
                HashSet<Character> cont = new HashSet<>();
                int right = mostRight[ss[i] - 'a'];
                for (int j = i + 1; j < right; j++) {
                    cont.add(ss[j]);
                }
                res += cont.size();
            }
            visited.add(ss[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        UniqueLength3PalindromicSubsequences_1930 u = new UniqueLength3PalindromicSubsequences_1930();
        u.countPalindromicSubsequence("aabca");
    }
}
