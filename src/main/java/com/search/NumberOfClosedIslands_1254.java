package com.search;

import java.util.Arrays;

public class NumberOfClosedIslands_1254 {
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int closedIsland(int[][] grid) {
        int count = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] != 0) continue;
                if(dfs(grid, i, j)) count++;
            }
        }
        return count;
    }

    public boolean dfs(int[][] grid, int i, int j) {
        boolean res = true;
        if(i == 0 || i == grid.length - 1 ||
            j == 0 || j == grid[0].length - 1) res = false;

        grid[i][j] = 2;
        for(int[] direction : directions){
            int row = i + direction[0];
            int col = j + direction[1];
            if(row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] == 0){
                res = dfs(grid, row, col) && res;
            }
        }
        return res;
    }
}
