package com.search;

public class BombEnemy_361 {
    public int maxKilledEnemies(char[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '0') res = Math.max(res, findEnemies(grid, i ,j));
            }
        }

        return res;
    }

    public int findEnemies(char[][] grid, int x, int y){
        int count = 0;

        for (int i = x - 1; i >= 0; i--){
            if (grid[i][y] == 'W') break;
            if (grid[i][y] == 'E') count++;
        }

        for (int i = x + 1; i < grid.length; i++) {
            if (grid[i][y] == 'W') break;
            if (grid[i][y] == 'E') count++;
        }

        for (int j = y - 1; j >= 0; j--){
            if (grid[x][j] == 'W') break;
            if (grid[x][j] == 'E') count++;
        }

        for (int j = y + 1; j < grid[0].length; j++){
            if (grid[x][j] == 'W') break;
            if (grid[x][j] == 'E') count++;
        }

        return count;
    }
}
