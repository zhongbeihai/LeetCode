package com.search;

import java.util.*;

public class MaximumCandiesYouCanGetFromBoxes_1298 {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        Set<Integer> keysGotten = new HashSet<>();
        boolean[] boxesVisited = new boolean[candies.length];
        boolean[] boxesOwned = new boolean[candies.length];

        Deque<Integer> queue = new ArrayDeque<>();
        for (int i : initialBoxes) {
            boxesOwned[i] = true;
            queue.add(i);
        }


        int res = 0;
        boolean progress = true;
        while (progress){
            progress = false;
            for (int i = 0; i < queue.size(); i++){
                int curBox = queue.pollFirst();
                if (!boxesVisited[curBox] && (status[curBox] == 1 || keysGotten.contains(curBox))){
                    res += candies[curBox];
                    progress = true;
                    boxesVisited[curBox] = true;

                    for (int k: keys[curBox]){
                        keysGotten.add(k);
                        if (!boxesVisited[k] && boxesOwned[k]) queue.add(k);
                    }

                    for (int c : containedBoxes[curBox] ) {
                        boxesOwned[c] = true;
                        queue.add(c);

                    }
                }else {
                    queue.add(curBox);
                }
            }
        }


        return res;
    }
}
