package com.dynamic_programming;

public class MaximumNumberOfSubsequencesInAString_2207 {
    public long maximumSubsequenceCount(String text, String pattern) {
        int cnt0 = 0, cnt1 = 0;
        int res = 0;
        for(int i = 0 ; i < text.length() ; i++){

            if(text.charAt(i) == pattern.charAt(1)){
                cnt1++;
                res += cnt0;
            }
            if(text.charAt(i) == pattern.charAt(0)){
                cnt0++;
            }
        }
        res += Math.max(cnt1, cnt0);
        return res;
    }

    public static void main(String[] args) {
        MaximumNumberOfSubsequencesInAString_2207 m = new MaximumNumberOfSubsequencesInAString_2207();
        m.maximumSubsequenceCount("abdcdbc", "ac");
    }
}
