package com.simulation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.stream.Collectors;

public class StoneGame_877 {
    public boolean stoneGame(int[] piles) {
        int[][] dp = new int[piles.length][piles.length];
        dp[0][0] = 0;
        dp[0][1] = Math.abs(piles[0] - piles[1]);

        for(int i = 2; i < piles.length; i++){

        }
        return true;
    }

    public static void main(String[] args) {
        StoneGame_877 s = new StoneGame_877();
        s.stoneGame(new int[]{3,2,10,4});
    }
}
