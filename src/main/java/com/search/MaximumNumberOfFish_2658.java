package com.search;

public class MaximumNumberOfFish_2658 {
    int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public int findMaxFish(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        int res = 0;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] <= 0) continue;
                res = Math.max(res, dfs(grid, 0, i, j));
            }
        }

        return res;
    }

    public int dfs(int[][] grid, int count, int x, int y){
        count += grid[x][y];
        grid[x][y] = 0;
        for (int[] dir: dirs){
            int nx = x + dir[0], ny = y + dir[1];
            if (nx >= 0 && ny >= 0
                    && nx < grid.length && ny < grid[0].length
                    && grid[nx][ny] > 0){
                count += dfs(grid, 0, nx, ny);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        MaximumNumberOfFish_2658 m = new MaximumNumberOfFish_2658();
        m.findMaxFish(new int[][]{{0,2,1,0},{4,0,0,3},{1,0,0,4},{0,3,2,0}});
    }
}
