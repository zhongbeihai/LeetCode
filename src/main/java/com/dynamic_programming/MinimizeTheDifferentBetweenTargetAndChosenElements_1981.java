package com.dynamic_programming;

import java.util.Arrays;

public class MinimizeTheDifferentBetweenTargetAndChosenElements_1981 {
    public int minimizeTheDifference(int[][] mat, int target) {
        boolean[] dp = new boolean[2* target + 1];
        dp[0] = true;
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                for(int p = target; p > 0; p-- ){
                    int m = mat[i][j];
                    int finalP = p;
                    if((Arrays.stream(mat[i]).anyMatch(num -> num ==  finalP - m) && finalP - m != m)|| p - mat[i][j] < 0) continue;
                    dp[p] = dp[p] || dp[p - mat[i][j]];
                }
            }
        }
        for(int i = target; i >= 0; i++){
            if(dp[i]) return Math.abs(target - i);
        }
        return target;
    }

    public static void main(String[] args) {
        MinimizeTheDifferentBetweenTargetAndChosenElements_1981 m = new MinimizeTheDifferentBetweenTargetAndChosenElements_1981();
        //m.minimizeTheDifference(new int[][]{{1,2,3},{4,5,6},{7,8,9}}, 10);
        //m.minimizeTheDifference(new int[][]{{1},{2},{3}}, 10);
        m.minimizeTheDifference(new int[][]{{1,2,9,8,7}}, 6);
    }
}
