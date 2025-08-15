package com.search;

public class NumberOfIslands_200 {
    public int count = 0;
    public int[][] visited;
    public int numIslands(char[][] grid) {
        int n = grid.length, m = grid[0].length;
        visited = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1' && visited[i][j] == 0){
                    count++;
                    dfs(grid, i, j);
                }
            }
        }

        return count;
    }

    public void dfs(char[][] grid, int x, int y){
        visited[x][y] = 1;
        int n = grid.length, m = grid[0].length;
        int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        for (int[] dir: dirs){
            int nx = x + dir[0], ny = y + dir[1];
            if (nx >= 0 && nx < n && ny >= 0 && ny < m && grid[nx][ny] == '1' && visited[nx][ny] == 0) dfs(grid, nx, ny);
        }
    }



    public static void main(String[] args) {
        char[][] grid = new char[][]{{'1','1','1'},{'0','1','0'},
                {'1','1','1'}};
        NumberOfIslands_200 n = new NumberOfIslands_200();
        n.numIslands(grid);
    }
}
