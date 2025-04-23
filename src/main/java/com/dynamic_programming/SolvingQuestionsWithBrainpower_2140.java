package com.dynamic_programming;

import java.util.Arrays;

public class SolvingQuestionsWithBrainpower_2140 {
    public long mostPoints(int[][] questions) {
        long[] dp = new long[questions.length];
        Arrays.fill(dp, -1);

        return rec(0, questions.length, questions, dp);
    }

    public long rec(int idx, int n, int[][] questions, long[] dp){
        if (idx >= n) return 0;

        if (dp[idx] != -1) return dp[idx];

        int point = questions[idx][0],  brainPower = questions[idx][1];
        long take = point + rec(idx + brainPower + 1, n, questions, dp);
        long notTake = rec(idx + 1, n, questions, dp);

        dp[idx] = Math.max(take, notTake);

        return dp[idx];
    }

    public static void main(String[] args) {
        SolvingQuestionsWithBrainpower_2140 s= new SolvingQuestionsWithBrainpower_2140();
        s.mostPoints(new int[][]{{92,3},{74,2},{39,4},{58,2},{5,5},{49,4},{65,3}});
    }
}
