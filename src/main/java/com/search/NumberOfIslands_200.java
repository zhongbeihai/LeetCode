package com.search;

public class NumberOfIslands_200 {
    int[][] dirs = new int[][]{{1,0}, {-1, 0}, {0,1 },{0 , - 1}};
    public int numIslands(char[][] grid) {
        int res = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    res++;
                }
            }
        }

        return res;
    }

    public void dfs(char[][] grid, int x, int y){
        grid[x][y] = '0';

        for (int[] dir: dirs){
            int nx = x + dir[0], ny = y + dir[1];

            if (nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length && grid[nx][ny] == '1') dfs(grid, nx, ny);
        }
    }



    public static void main(String[] args) {
        char[][] grid = new char[][]{{'1','1','1'},{'0','1','0'},
                {'1','1','1'}};
        NumberOfIslands_200 n = new NumberOfIslands_200();
        n.numIslands(grid);
    }
}
