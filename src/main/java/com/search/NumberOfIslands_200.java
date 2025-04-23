package com.search;

public class NumberOfIslands_200 {
    public int count = 0;
    public int[][] visited;
    public int numIslands(char[][] grid) {
        visited = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(visited[i][j] == 0 && grid[i][j] == '1'){
                    count++;
                    DFS(grid, i, j);
                }
            }
        }

        return count;
    }

    public void DFS(char[][] grid, int l, int w){
        if (l > grid.length || w > grid[0].length) return;
        if(visited[l][w] == 1 || grid[l][w] == '0') return;
        visited[l][w] = 1;
        if(l + 1 < grid.length) DFS(grid, l + 1, w);
        if(w + 1 < grid[0].length) DFS(grid, l, w + 1);
        if(l - 1 >= 0) DFS(grid, l - 1, w);
        if(w - 1 >= 0) DFS(grid, l, w - 1);
    }

    public static void main(String[] args) {
        char[][] grid = new char[][]{{'1','1','1'},{'0','1','0'},
                {'1','1','1'}};
        NumberOfIslands_200 n = new NumberOfIslands_200();
        n.numIslands(grid);
    }
}
