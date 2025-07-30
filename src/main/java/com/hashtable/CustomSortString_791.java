package com.hashtable;

public class CustomSortString_791 {
    public String customSortString(String order, String s) {
        int[] table = new int[26];

        char[] ss = s.toCharArray();
        for (char c: ss){
            table[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        char[] oo = order.toCharArray();
        for (char o: oo){
            while (table[o - 'a'] > 0){
                sb.append(o);
                table[o - 'a']--;
            }
        }

        for (int i = 0; i < 26; i++) {
            while (table[i] > 0){
                sb.append((char)(i + 'a'));
                table[i]--;
            }
        }

        return sb.toString();
    }
}
