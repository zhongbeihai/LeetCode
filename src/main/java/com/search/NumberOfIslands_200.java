package com.search;

public class NumberOfIslands_200 {
    public int count = 0;
    private final int[][] dirs = new int[][]{{0,1}, {1, 0},{0, -1}, {-1, 0}};
    public int numIslands(char[][] grid) {
        if (grid.length == 0) return 0;
        int m = grid.length, n = grid[0].length;

        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1'){
                    count++;
                    dfs(grid, i, j);
                }
            }
        }

        return count;
    }

    public void dfs(char[][] grid, int x, int y){
        int m = grid.length, n = grid[0].length;
        grid[x][y] = '0';

        for (int[] dir: dirs){
            int nx = x + dir[0], ny = y + dir[1];
            if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == '1') dfs(grid, nx, ny);
        }
    }



    public static void main(String[] args) {
        char[][] grid = new char[][]{{'1','1','1'},{'0','1','0'},
                {'1','1','1'}};
        NumberOfIslands_200 n = new NumberOfIslands_200();
        n.numIslands(grid);
    }
}
