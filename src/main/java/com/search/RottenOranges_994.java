package com.search;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.sql.PreparedStatement;
import java.util.*;

public class RottenOranges_994 {
    public int orangesRotting(int[][] grid) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(i -> i[0])); // (time, x, y)
        int m = grid.length, n = grid[0].length;

        int cntOranges = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2 || grid[i][j] == 1) cntOranges++;
                if (grid[i][j] == 2)pq.add(new int[]{0, i, j});
            }
        }

        int[][] dirs = new int[][]{{1,0}, {0,1}, {-1, 0}, {0, -1}};
        // bfs
        int maxTime = 0;
        while (!pq.isEmpty()){
            int[] curO = pq.poll();
            int t = curO[0], x = curO[1], y = curO[2];
            maxTime = Math.max(maxTime, curO[0]);
            cntOranges--;
            for(int[] dir: dirs){
                int nx = x + dir[0], ny = y + dir[1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == 1){
                    pq.add(new int[]{t + 1, nx, ny});
                    grid[nx][ny] = 2;
                }
            }
        }

        return cntOranges == 0 ? maxTime : -1;
    }

    public static void main(String[] args) {
        RottenOranges_994 r = new RottenOranges_994();
        r.orangesRotting(new int[][]{{2,2},{1,1},{0,0},{2,0}});
    }
}
