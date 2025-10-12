package com.search;

import java.util.*;

public class PacificAlanticWaterFlow_417 {
    int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        Queue<int[]> queue = new ArrayDeque<>();

        // pacific
        boolean[][] pac = new boolean[m][n];
        for (int i = 0; i < n; i++){
            queue.add(new int[]{0, i});
            pac[0][i] = true;
        }
        for (int i = 0; i < m; i++) {
            queue.add(new int[]{i, 0});
            pac[i][0] = true;
        }
        // bfs
        bfs(heights, queue, pac);

        queue.clear();
        // atlantic
        boolean[][] atl = new boolean[m][n];
        for (int i = 0; i < n; i++){
            queue.add(new int[]{m - 1, i});
            atl[m-1][i] = true;
        }
        for (int i = 0; i < m; i++) {
            queue.add(new int[]{i, n - 1});
            atl[i][n-1] = true;
        }
        bfs(heights, queue, atl);

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pac[i][j] && atl[i][j]){
                    res.add(Arrays.asList(i, j));
                }
            }
        }

        return res;
    }

    void bfs(int[][] heights, Queue<int[]> queue, boolean[][] pac){
        int m = heights.length, n = heights[0].length;
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1], h = heights[x][y];

            for (int[] dir: dirs){
                int nx = x + dir[0], ny = y + dir[1];
                if (nx >= 0 && ny >= 0 && nx < m && ny < n && heights[nx][ny] >= h && !pac[nx][ny]){
                    queue.add(new int[]{nx, ny});
                    pac[nx][ny] = true;
                }
            }
        }
    }

}
