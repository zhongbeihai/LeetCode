package com.simulation;

import javax.management.relation.Relation;

public class FindTheCelebrity_277 {
    boolean knows(int a, int b) {return true;}

    public int findCelebrity(int n) {
        int candidate = 0;
        for (int i = 1; i < n; i++){
            if (knows(candidate, i)) candidate = i;
        }

        for (int j = 0; j < n; j++){
            if (j == candidate) continue;
            if (!knows(j, candidate)) return -1;
            if (knows(candidate, j)) return -1;
        }

        return candidate;
    }
}
