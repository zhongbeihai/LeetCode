package com.simulation;

public class LongestCommonPrefix_14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";

        String prefix = strs[0];
        for (String str: strs){
            int p = 0;
            while (p < prefix.length() && p < str.length() && prefix.charAt(p) == str.charAt(p)) p++;
            prefix = prefix.substring(0, p);
        }

        return prefix;
    }

    public static void main(String[] args) {
        LongestCommonPrefix_14 l = new LongestCommonPrefix_14();
        l.longestCommonPrefix(new String[]{"cir","car"});
    }
}
