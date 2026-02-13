package com.two_pointers;

public class MergeStringAlternately_1768 {
    public String mergeAlternately(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int p1 = 0, p2 = 0;

        StringBuilder sb = new StringBuilder();
        while (p1 < m && p2 < n){
            sb.append(word1.charAt(p1)).append(word2.charAt(p2));
            p1++;
            p2++;
        }
        while (p1 < m){
            sb.append(word1.charAt(p1++));
        }
        while (p2 < n){
            sb.append(word2.charAt(p2++));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        MergeStringAlternately_1768 m = new MergeStringAlternately_1768();
        m.mergeAlternately("abcd", "pq");
    }
}
