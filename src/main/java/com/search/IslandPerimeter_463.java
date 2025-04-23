package com.search;

public class IslandPerimeter_463 {
    int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int islandPerimeter(int[][] grid) {
        int r = -1, c = -1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1){
                    r = i;
                    c = j;
                    break;
                }
            }
            if(r != -1) break;
        }

        return dfs(grid, r, c) + 1;

    }

    public int dfs(int[][] grid, int r, int c){
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0) {
            return 1;
        }
        if (grid[r][c] == 2) {
            return 0;
        }

         grid[r][c] = 2;
        int p = 0;
        for(int[] direction : directions){
            int row = r + direction[0];
            int col = c + direction[1];
            p += dfs(grid, row, col);
        }
        return p;
    }

    public static void main(String[] args) {
        IslandPerimeter_463 i = new IslandPerimeter_463();
        //i.islandPerimeter(new int[][]{{0,1,0,0}, {1,1,1,0}, {0,1,0,0}, {1,1,0,0}});
        i.islandPerimeter(new int[][]{{1,1},{1,1}});
    }
}
