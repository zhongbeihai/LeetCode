package com.search;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class PacificAlanticWaterFlow_417 {
    int[][]
    public List<List<Integer>> pacificAtlantic(int[][] heights) {

    }

    public int[] bfs(int[][] heights, int x, int y){
        int m = heights.length, n = heights[0].length;

        boolean[][] mark = new boolean[m][n];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x, y});

        while (!queue.isEmpty()){
            int[] cur = queue.poll();


        }
    }
}
