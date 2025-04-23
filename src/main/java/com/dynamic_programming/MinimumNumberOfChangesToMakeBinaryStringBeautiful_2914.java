package com.dynamic_programming;

public class MinimumNumberOfChangesToMakeBinaryStringBeautiful_2914 {
    public int minChanges(String s) {
        int dp = 0;
        for(int i = 1; i < s.length(); i += 2){
            if(s.charAt(i) != s.charAt(i - 1)) dp += 1;
        }

        return dp;
    }

    public static void main(String[] args) {
        MinimumNumberOfChangesToMakeBinaryStringBeautiful_2914 m = new MinimumNumberOfChangesToMakeBinaryStringBeautiful_2914();
        m.minChanges("10001001");
    }
}
