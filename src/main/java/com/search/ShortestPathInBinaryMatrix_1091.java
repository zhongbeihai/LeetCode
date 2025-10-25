package com.search;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMatrix_1091 {
    private int[][] dirs = new int[][]{{1,0}, {0,1},{-1, 0}, {0, -1}, {-1, -1}, {1, -1,}, {-1, 1}, {1, 1}};
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        if(grid[0][0] == 1 || grid[n - 1][m - 1]== 1) return -1;
        bfs(grid, 0, 0);

        return grid[n - 1][m - 1] == 0 ? -1 : grid[n - 1][m - 1];
    }

    public void dfs(int[][] grid, int x, int y, int[][] visited, int cnt){
        int n = grid.length, m = grid[0].length;
        visited[x][y] = cnt;
        for (int[] dir: dirs){
            int nx = x + dir[0], ny = y + dir[1];
            if (nx >= 0 && ny >= 0 && nx < n && ny < m && cnt + 1 < visited[nx][ny] && grid[nx][ny] == 0){
                dfs(grid, nx, ny, visited, cnt + 1);
            }
        }
    }

    public void bfs(int[][] grid, int x, int y){
        int n = grid.length, m = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        grid[0][0] = 1;

        while (!queue.isEmpty()){
            int[] cur = queue.poll();
            int curX= cur[0], curY = cur[1];

            if (curX == n - 1 && curY == n - 1) return;
            for (int[] d: dirs){
                int nx = curX + d[0], ny = curY + d[1];
                if (nx >= 0 && ny >= 0 && nx < n && ny < m && grid[nx][ny] == 0 ){
                    queue.offer(new int[]{nx, ny});
                    grid[nx][ny] = grid[curX][curY] + 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        ShortestPathInBinaryMatrix_1091 s = new ShortestPathInBinaryMatrix_1091();
        s.shortestPathBinaryMatrix(new int[][]{{0,0,0}, {1,1,0},{1,1,0}});
    }


}
