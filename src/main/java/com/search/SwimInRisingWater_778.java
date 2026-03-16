package com.search;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SwimInRisingWater_778 {
    private int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int lo = grid[0][0], hi = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                hi = Math.max(hi, grid[i][j]);
            }
        }

        while (lo < hi){
            int mid = lo + (hi - lo) / 2;
            if (dfs(grid, 0, 0, mid, new boolean[n][n])){
                hi = mid;
            }else {
                lo = mid + 1;
            }
        }

        return hi;
    }

    public boolean dfs(int[][]grid, int x, int y, int curHeight, boolean[][] visited){
        int n = grid.length;
        visited[x][y] = true;

        if (x == n - 1 && y == n - 1) return true;

        boolean flag = false;
        for (int[] dir: dirs){
            int nx = x + dir[0], ny = y + dir[1];
            if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny] && curHeight >= grid[nx][ny])
                flag |=  dfs(grid, nx, ny, curHeight, visited);
        }

        return flag;
    }

    public int Dijkstra(int[][] grid){
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(i -> i[2])); // {x, y, maximum height in this path}
        pq.add(new int[]{0,0, grid[0][0]});

        while (!pq.isEmpty()){
            int[] cur = pq.poll();
            int x = cur[0], y = cur[1], mhei = cur[2];
            visited[x][y] = true;
            if (x == n - 1 && y == n - 1) return mhei;

            for (int[] dir:dirs){
                int nx = x + dir[0], ny = y + dir[1];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny]){
                    pq.add(new int[]{nx, ny, Math.max(mhei, grid[nx][ny])});
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        SwimInRisingWater_778 s = new SwimInRisingWater_778();
        s.swimInWater(new int[][]{{0,1,2,3,4}, {24,23,22,21,5},{12,13,14,15,16},{11,17,18,19,20},{10,9,8,7,6}});
    }


}
