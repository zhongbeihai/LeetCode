package com.search;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class ShortestDistanceFromAllBuildings_317 {
    int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public int shortestDistance(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] sumDit = new int[n][m];
        int[][] reach = new int[n][m];
        int numOfBuildings = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (grid[i][j] == 1){
                    sumDit[i][j] = Integer.MAX_VALUE;
                    numOfBuildings++;
                    bfs(grid, sumDit, reach, new int[]{i, j});
                }else if (grid[i][j] == 2){
                    sumDit[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (grid[i][j] == 0 && reach[i][j] == numOfBuildings) res = Math.min(res, sumDit[i][j]);
            }
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public void bfs(int[][] grid, int[][] sumDit,int[][] reach,  int[] o){
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        queue.add(new int[]{o[0], o[1], 0});
        while (!queue.isEmpty()){
            int[] q = queue.poll();
            int x = q[0], y = q[1], d = q[2];
            sumDit[x][y] += d;
            reach[x][y]++;
            for (int[] dir: dirs){
                int nx = x + dir[0], ny = y + dir[1];
                if (nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length && grid[nx][ny] == 0 && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny, d + 1});
                }
            }
        }
    }

    public static void main(String[] args) {
        ShortestDistanceFromAllBuildings_317 s = new ShortestDistanceFromAllBuildings_317();
        s.shortestDistance(new int[][]{{1,0,2,0,1},{0,0,0,0,0},{0,0,1,0,0}});
    }
}
