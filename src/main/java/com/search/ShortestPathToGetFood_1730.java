package com.search;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class ShortestPathToGetFood_1730 {
    public int getFood(char[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] shortest = new int[n][m];
        for (int[] s: shortest) Arrays.fill(s, Integer.MAX_VALUE);

        // find start point
        int sx = -1, sy = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '*') {sx = i; sy = j;}
            }
        }
        shortest[sx][sy] = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{sx, sy});
        int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

        int res = Integer.MAX_VALUE;
        while (!queue.isEmpty()){
            int[] s = queue.poll();
            int x = s[0], y = s[1];

            for (int[] dir: dirs){
                int nx = x + dir[0], ny = y + dir[1];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m &&
                        grid[nx][ny] != 'X' && shortest[nx][ny] > shortest[x][y] + 1){
                    queue.add(new int[]{nx, ny});
                    shortest[nx][ny] = shortest[x][y] + 1;
                    if (grid[nx][ny] == '#'){
                        res = Math.min(res, shortest[nx][ny]);
                    }
                }
            }
        }

        return res != Integer.MAX_VALUE ? res : -1;
    }
}
