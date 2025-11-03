package com.simulation;

public class LongestCommonPrefix_14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null) return "";

        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++){
            int p = 0;
            while (p < prefix.length() && p < strs[i].length() && prefix.charAt(p) == strs[i].charAt(p)) p++;
            prefix = prefix.substring(0, p);
        }

        return prefix;
    }

    public static void main(String[] args) {
        LongestCommonPrefix_14 l = new LongestCommonPrefix_14();
        l.longestCommonPrefix(new String[]{"cir","car"});
    }
}
