package com.search;

import java.util.PriorityQueue;

public class TrappingWaterII_407 {
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length, n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>(((o1, o2) -> o1[0] - o2[0]));
        int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i== 0 || i== m-1 || j==0 || j== n-1){
                    pq.add(new int[]{heightMap[i][j], i, j});
                    visited[i][j]=true;
                }
            }
        }

        int res = 0;
        while (!pq.isEmpty()){
            int[] c = pq.poll();
            int cv = c[0], cx = c[1], cy = c[2];

            for(int[] dir: dirs){
                int nx = cx + dir[0], ny = cy + dir[1];
                if(nx >= 0 && ny >= 0 && nx < m && ny < n && !visited[nx][ny]){
                    int nv = heightMap[nx][ny];
                    if(cv - nv > 0){
                        res += (cv - nv);
                        pq.add(new int[]{cv, nx, ny});
                    }
                    else {
                        pq.add(new int[]{nv, nx, ny});
                    }
                    visited[nx][ny]=true;
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
