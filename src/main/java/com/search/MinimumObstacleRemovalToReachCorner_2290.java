package com.search;

import java.util.*;

public class MinimumObstacleRemovalToReachCorner_2290 {
    public int minimumObstacles(int[][] grid) {
        Deque<int[]> pq =new ArrayDeque<>();
        int[][] directions = new int[][]{{1, 0}, {-1,0}, {0, 1},{0, -1}};
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (boolean[] v : visited){
            Arrays.fill(v, false);
        }

        pq.add(new int[]{0,0,grid[0][0]});
        while (!pq.isEmpty()){
            int[] cur = pq.pollFirst();
            if(cur[0] == grid.length - 1 && cur[1] == grid[0].length - 1) return cur[2];
            if (visited[cur[0]][cur[1]]) continue;
            visited[cur[0]][cur[1]] = true;
            for(int[] dir: directions){
                int nx = cur[0] + dir[0];
                int ny = cur[1] + dir[1];
                if(nx >= 0 && nx < grid.length
                        && ny >= 0 && ny < grid[0].length){
                    int a = cur[2];
                    if (grid[nx][ny] == 1) {
                        a++;
                        pq.addLast(new int[]{nx, ny, a});
                    }else {
                        pq.addFirst(new int[]{nx, ny, a});
                    }
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        MinimumObstacleRemovalToReachCorner_2290 m = new MinimumObstacleRemovalToReachCorner_2290();
        int a = m.minimumObstacles(new int[][]{{0,1,1},{1,1,0},{1,1,0}});
    }
}
