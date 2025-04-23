package com.search;

public class CountSubIslands_1905 {
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int count = 0;
        for(int i = 0; i < grid2.length; i++){
            for(int j = 0; j < grid2[0].length; j++){
                if(grid2[i][j] != 1) continue;
                if(dfs(grid1, grid2, i, j)) count++;
            }
        }
        return count;
    }

    public boolean dfs(int[][] grid1, int[][] grid2, int r, int c){
        boolean res = true;
        if(grid2[r][c] == 1 && grid1[r][c] == 0) res = false;

        grid2[r][c] = 2;
        for(int[] direction : directions){
            int row = r + direction[0];
            int col = c + direction[1];
            if(row >= 0 && row < grid2.length && col >= 0 && col < grid2[0].length
                    && grid2[row][col] == 1){
                res = dfs(grid1, grid2, row, col) && res;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        CountSubIslands_1905 c  = new CountSubIslands_1905();
        c.countSubIslands(new int[][]{{1,0,1,0,1},{1,1,1,1,1},{0,0,0,0,0}, {1,1,1,1,1},{1,0,1,0,1}},
                new int[][]{{0,0,0,0,0},{1,1,1,1,1},{0,1,0,1,0},{0,1,0,1,0},{1,0,0,0,1}});
    }

}
