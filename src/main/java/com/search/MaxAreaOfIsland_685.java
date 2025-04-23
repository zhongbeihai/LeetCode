package com.search;

public class MaxAreaOfIsland_685 {
    private int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 0) continue;
                if(grid[i][j] == 1){
                    maxArea = Math.max(maxArea, dfs(grid, i, j));
                }
            }
        }
        return maxArea;
    }

    public int dfs(int[][] grid, int i, int j){

        int area = 1;
        grid[i][j] = 2;
        for(int[] direction : directions){
            int row = i + direction[0];
            int col = j + direction[1];
            if(row >= 0 && row < grid.length && col >= 0 && col < grid[0].length
                    && grid[row][col] == 1){
                area += dfs(grid, row, col);
            }
        }
        return area;
    }

    public static void main(String[] args) {
        MaxAreaOfIsland_685 m =  new MaxAreaOfIsland_685();
        m.maxAreaOfIsland(new int[][]{{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0}, {0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}});
    }
}
