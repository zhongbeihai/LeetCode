package com.dynamic_programming;

import java.util.*;

public class FurthestBuildingYouCanReach_1642 {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int n = heights.length;
        for (int i = 1; i < n; i++){
            int diff = heights[i] - heights[i - 1];
            if (diff > 0){
                pq.add(diff);
                if (pq.size() > ladders){
                    bricks -= pq.poll();
                }
                if (bricks < 0) return i - 1;
            }
        }

        return n - 1;
    }

    public static void main(String[] args) {
        FurthestBuildingYouCanReach_1642 f = new FurthestBuildingYouCanReach_1642();
        f.furthestBuilding(new int[]{4,12,2,7,3,18,20,3,19}, 10, 2);
    }
}
