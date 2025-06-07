package com.stack;

import java.util.Stack;

public class LexicographicallyMinimumStringAfterRemovingStars_3170 {
    public String clearStars(String s) {
        StringBuilder sb = new StringBuilder();
        char[] ss = s.toCharArray();

        int[] minCharCount = new int[26];

        for (char c: ss){
            if (c != '*') {
                minCharCount[c - 'a']++;
                sb.append(c);
            }else {
                int minChar = 0;
                while (minChar < 26  && minCharCount[minChar] == 0){
                    minChar++;
                }
                sb.deleteCharAt(sb.lastIndexOf(String.valueOf((char)(minChar + 'a'))));
                minCharCount[minChar]--;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        LexicographicallyMinimumStringAfterRemovingStars_3170 l = new LexicographicallyMinimumStringAfterRemovingStars_3170();
        l.clearStars("aaba*");
    }
}
