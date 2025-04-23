package com.search;

import java.util.PriorityQueue;

public class RottingOranges_994 {
    public int orangesRotting(int[][] grid) {
        // [x, y, time]
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        int n = grid.length, m = grid[0].length;
        int numFreshOranges = 0;
        for(int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (grid[i][j] == 2) pq.add(new int[]{i, j, 0});
                if (grid[i][j] == 1) numFreshOranges++;
            }
        }

        int res = 0;
        int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        // bfs
        while (!pq.isEmpty()){
            int[] e = pq.poll();
            grid[e[0]][e[1]] = 2;
            res = Math.max(res, e[2]);
            for (int[] dir: dirs){
                int nx = e[0] + dir[0], ny = e[1] + dir[1];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && grid[nx][ny] == 1){
                    pq.add(new int[]{nx, ny, e[2] + 1});
                    grid[nx][ny] = 3; // it has been added to the queue
                    numFreshOranges--;
                }
            }
        }
        if (numFreshOranges > 0) return -1;
        return res;
    }

    public static void main(String[] args) {
        RottingOranges_994 r = new RottingOranges_994();
        r.orangesRotting(new int[][]{{2,1,1},{1,1,0},{0,1,1}});
    }
}
