package com.search;

public class MaxAreaOfIsland_685 {
    private int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        int maxArea = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) maxArea = Math.max(maxArea, dfs(grid, i, j));
            }
        }

        return maxArea;
    }

    public int dfs(int[][] grid, int x, int y){
        grid[x][y] = 0;
        int r = 1;
        for (int[] dir: directions){
            int nx = x + dir[0], ny = y + dir[1];
            if (nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length && grid[nx][ny] == 1){
                r += dfs(grid, nx, ny);
            }
        }

        return r;
    }



    public static void main(String[] args) {
        MaxAreaOfIsland_685 m =  new MaxAreaOfIsland_685();
        m.maxAreaOfIsland(new int[][]{{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0}, {0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}});
    }
}
