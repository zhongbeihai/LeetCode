package com.search;

import java.util.Arrays;

public class SwimInRisingWater_778 {
    int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public int swimInWater(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] memo = new int[n][m];
        for (int[] me: memo){
            Arrays.fill(me, Integer.MAX_VALUE);
        }

        dfs(grid, memo, 0, 0, grid[0][0]);

        return memo[n - 1][m - 1];
    }

    public void dfs(int[][] grid, int[][] memo, int x, int y, int now){
        int n = grid.length, m = grid[0].length;

        memo[x][y] = now;
        for (int[] dir: dirs){
            int nx = x + dir[0], ny = y + dir[1];

            if (nx >= 0 && ny >= 0 && nx < n && ny < m && now < memo[nx][ny]){
                dfs(grid, memo, nx, ny , Math.max(now, grid[nx][ny]));
            }
        }
    }

    public static void main(String[] args) {
        SwimInRisingWater_778 s = new SwimInRisingWater_778();
        s.swimInWater(new int[][]{{0,1,2,3,4}, {24,23,22,21,5},{12,13,14,15,16},{11,17,18,19,20},{10,9,8,7,6}});
    }


}
