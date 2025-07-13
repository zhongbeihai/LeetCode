package com.doublepointers;

import java.util.Arrays;

public class MaximumMatchingOfPlayerWithTrainer_2410 {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        int p1 = 0, p2 = 0;
        Arrays.sort(players);
        Arrays.sort(trainers);
        int n = players.length, m = trainers.length;

        int res = 0;
        while (p1 < n && p2 < m){
            if (players[p1] <= trainers[p2]){
                p1++;
                res++;
            }
            p2++;
        }

        return res;
    }
}
