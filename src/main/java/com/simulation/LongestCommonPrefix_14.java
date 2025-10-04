package com.simulation;

public class LongestCommonPrefix_14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null) return "";

        String ori = strs[0];
        for (int i = 1; i < strs.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < ori.length() && j < strs[i].length(); j++) {
                if (ori.charAt(j) == strs[i].charAt(j)) sb.append(ori.charAt(j));
                else break;
            }
            ori = sb.toString();
        }

        return ori;
    }

    public static void main(String[] args) {
        LongestCommonPrefix_14 l = new LongestCommonPrefix_14();
        l.longestCommonPrefix(new String[]{"cir","car"});
    }
}
