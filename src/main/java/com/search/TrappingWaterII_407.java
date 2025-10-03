package com.search;

import java.util.Comparator;
import java.util.PriorityQueue;

public class TrappingWaterII_407 {
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length, n = heightMap[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(i -> i[2])); //i[] -> {x, y, height}

        int[][] dirs = new int[][]{{1,0},{-1, 0}, {0, 1}, {0, -1}};
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (i == 0 || j == 0 || i == m - 1 || j == n - 1) {
                    pq.add(new int[]{i, j, heightMap[i][j]});
                    visited[i][j] = true;
                 }
            }
        }

        int res = 0;
        while (!pq.isEmpty()){
            int[] cur = pq.poll();
            int x = cur[0], y = cur[1], curH = cur[2];

            for (int[] dir: dirs){
                int nx = dir[0] + x, ny = dir[1] + y;
                if (nx >= 0 && ny >= 0 && nx < m && ny < n && !visited[nx][ny]){
                    int neiHeight = heightMap[nx][ny];
                    if (neiHeight < curH) res += curH - neiHeight;
                    pq.add(new int[]{nx, ny, Math.max(neiHeight, curH)});
                    visited[nx][ny] = true;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        TrappingWaterII_407 t = new TrappingWaterII_407();
        t.trapRainWater(new int[][]{{1,4,3,1,3,2},{3,2,1,3,2,4},{2,3,3,2,3,1}});
    }
}
