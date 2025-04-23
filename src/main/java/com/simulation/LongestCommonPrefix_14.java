package com.simulation;

public class LongestCommonPrefix_14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null) return "";

        String common = strs[0];

        for (int i = 1; i < strs.length; i++){
            while (!strs[i].startsWith(common)){
                common = common.substring(0, common.length() - 1);
            }

            if (common.isEmpty()) return "";
        }

        return common;
    }

    public static void main(String[] args) {
        LongestCommonPrefix_14 l = new LongestCommonPrefix_14();
        l.longestCommonPrefix(new String[]{"cir","car"});
    }
}
