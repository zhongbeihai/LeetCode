package com.search;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class MapOfHighestPeak_1765 {
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length, n = isWater[0].length;
        int[][] grid = new int[m][n];
        Queue<int[]> pq = new LinkedList<>();
        int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (isWater[i][j] == 1) {
                    grid[i][j] = 0;
                    pq.add(new int[]{i, j, 0});
                }
                else grid[i][j] = Integer.MAX_VALUE;
            }
        }

        while (!pq.isEmpty()){
            int[] c = pq.poll();
            int cx = c[0], cy = c[1], cv = c[2];
            if (grid[cx][cy] != Integer.MAX_VALUE) continue;
            for (int[] dir: dirs){
                int nx = cx + dir[0], ny = cy + dir[1];
                if(nx >=0 && ny >= 0 && nx < m && ny < n && grid[nx][ny] == Integer.MAX_VALUE){
                    grid[nx][ny] = cv + 1;
                    pq.add(new int[]{nx, ny, grid[nx][ny]});
                }
            }
        }

        return grid;
    }

    public static void main(String[] args) {
        MapOfHighestPeak_1765 m = new MapOfHighestPeak_1765();
        m.highestPeak(new int[][]{{0,0,1}, {1,0,0},{0,0,0}});
    }
}
