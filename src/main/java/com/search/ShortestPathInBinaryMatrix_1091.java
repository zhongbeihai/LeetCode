package com.search;

import java.util.ArrayDeque;
import java.util.Arrays;

public class ShortestPathInBinaryMatrix_1091 {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] visited = new int[n][m];
        for (int[] v: visited){
            Arrays.fill(v, Integer.MAX_VALUE);
        }
        visited[0][0] = 1;

        if (grid[0][0] == 1) return -1;
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{0, 0, 1});

        int[][] edges = new int[][]{{1,0}, {0,1},{-1, 0}, {0, -1}, {-1, -1}, {1, -1,}, {-1, 1}, {1, 1}};
        int[][] corners = new int[][]{};
        while (!deque.isEmpty()){
            int[] s = deque.pollFirst();
            int x = s[0], y = s[1], curStep = s[2];

            for (int[] edge : edges){
                int nx = x + edge[0], ny = y + edge[1];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && visited[nx][ny] > curStep + 1 && grid[nx][ny] == 0){
                    visited[nx][ny] = curStep + 1;
                    deque.add(new int[]{nx, ny, curStep + 1});
                }
            }
        }

        return visited[n - 1][m - 1] == Integer.MAX_VALUE ? -1 : visited[n - 1][m - 1];
    }

    public static void main(String[] args) {
        ShortestPathInBinaryMatrix_1091 s = new ShortestPathInBinaryMatrix_1091();
        s.shortestPathBinaryMatrix(new int[][]{{0,0,0}, {1,0,0},{1,1,0}});
    }


}
