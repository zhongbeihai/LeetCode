package com.two_pointers;

public class MergeStringAlternately_1768 {
    public String mergeAlternately(String word1, String word2) {
        // p1 -> word1, p2 -> word2
        int p1 = 0, p2 = 0;
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();
        int m = word1.length(), n = word2.length();
        StringBuilder sb = new StringBuilder();
        while (p1 < m && p2 < n){
            sb.append(w1[p1]);
            sb.append(w2[p2]);
            p1++;
            p2++;
        }

        if (m > n){
            while (p1 < m) sb.append(w1[p1++]);
        }else {
            while (p2 < n) sb.append(w2[p2++]);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        MergeStringAlternately_1768 m = new MergeStringAlternately_1768();
        m.mergeAlternately("abcd", "pq");
    }
}
