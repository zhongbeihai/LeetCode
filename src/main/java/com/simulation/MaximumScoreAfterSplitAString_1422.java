package com.simulation;

public class MaximumScoreAfterSplitAString_1422 {
    public int maxScore(String s) {
        int[] zeros = new int[s.length() + 1];
        int[] ones = new int[s.length() + 1];
        for(int i = 1; i <= s.length(); i++){
            if(s.charAt(i - 1) == '0') zeros[i] += zeros[i - 1] + 1;
            else zeros[i] += zeros[i - 1];
            if(s.charAt(i - 1) == '1') ones[i] = ones[i - 1] + 1;
            else ones[i] += ones[i - 1];
        }
        int max = 0;
        int maxOne = ones[ones.length - 1];
        for(int i = 1; i < s.length(); i++){
            int left = zeros[i];
            int right = maxOne - ones[i];
            max = Math.max(max, left + right);
        }
        return max;
    }

    public static void main(String[] args) {
        MaximumScoreAfterSplitAString_1422 m = new MaximumScoreAfterSplitAString_1422();
        m.maxScore("00");
    }
}
