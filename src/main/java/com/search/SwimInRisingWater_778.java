package com.search;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;

public class SwimInRisingWater_778 {
    private int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public int swimInWater(int[][] grid) {
        int n = grid.length;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(i -> i[2])); // {x, y, time];
        pq.add(new int[]{0,0, 0});

        grid[0][0] = -1;
        while (!pq.isEmpty()){
            int[] cur = pq.poll();
            int x = cur[0], y = cur[1], curTime = cur[2];

            if (x == n - 1 && y == n - 1) return curTime;

            for (int[] dir: dirs){
                int nx = x + dir[0], ny = y + dir[1];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && grid[nx][ny] != -1){
                    pq.add(new int[]{nx, ny, Math.max(curTime, grid[nx][ny])});
                    grid[nx][ny] = -1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        SwimInRisingWater_778 s = new SwimInRisingWater_778();
        s.swimInWater(new int[][]{{0,1,2,3,4}, {24,23,22,21,5},{12,13,14,15,16},{11,17,18,19,20},{10,9,8,7,6}});
    }


}
