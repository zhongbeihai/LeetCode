package com.search;

import java.util.ArrayDeque;
import java.util.Arrays;

public class MinimumCostToMakeValidPathInAGrid_1368 {
    public int minCost(int[][] grid) {
        int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};
        int m = grid.length, n = grid[0].length;
        int[][] dist = new int[m][n];
        for(int[] row: dist) Arrays.fill(row, Integer.MAX_VALUE);
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{0,0});
        dist[0][0] = 0;

        while (!deque.isEmpty()){
            int[] c = deque.pollFirst();
            int cx = c[0], cy = c[1];
            int curDir = grid[cx][cy] - 1;
            for(int dir = 0; dir < 4; dir++){
                int nx = cx + dx[dir], ny = cy + dy[dir];
                if(nx >= 0 && ny >= 0 && nx < m && ny < n){
                    int cost = dist[cx][cy] + (curDir == dir ? 0 : 1);
                    if(cost < dist[nx][ny]){
                        dist[nx][ny] = cost;
                        if (dir == curDir) {
                            deque.offerFirst(new int[]{nx, ny});
                        } else {
                            deque.offerLast(new int[]{nx, ny});
                        }
                    }
                }
            }
        }

        return dist[m - 1][n - 1];
    }
}
