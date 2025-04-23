package com.dynamic_programming;

public class MinimumDeletionsToMakeStringBalanced_1653 {
    public int minimumDeletions(String s) {
        char[] ss = s.toCharArray();
        int[] Bs = new int[ss.length];

        int bcount = 0;
        for(int i = 0 ; i < Bs.length; i++){
            if(ss[i] == 'b') bcount++;
            Bs[i] = bcount;
        }


        int[] dp = new int[ss.length + 1];
        for(int i = 1; i < ss.length; i++){
            if(ss[i] == 'b'){
                dp[i] = dp[i - 1];
            }else {
                dp[i] = Math.min(dp[i - 1] + 1, Bs[i - 1]);
            }
        }

        return dp[ss.length - 1];
    }

    public static void main(String[] args) {
        MinimumDeletionsToMakeStringBalanced_1653 m = new MinimumDeletionsToMakeStringBalanced_1653();
        m.minimumDeletions("aababbab");
    }
}
