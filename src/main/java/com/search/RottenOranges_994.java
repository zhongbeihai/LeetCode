package com.search;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.sql.PreparedStatement;
import java.util.*;

public class RottenOranges_994 {
    public int orangesRotting(int[][] grid) {
        PriorityQueue<int[]> rotten = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        int m = grid.length, n = grid[0].length;
        int[][] visited = new int[m][n];
        int count = 0, fresh = 0;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] == 2) {
                    rotten.add(new int[]{i, j, 1});
                    visited[i][j] = 1;
                }
                if (grid[i][j] == 1) fresh++;
            }
        }
        int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        while (!rotten.isEmpty()){
            int[] p = rotten.poll();
            int x = p[0], y = p[1], min = p[2];
            if (visited[x][y] == 0) fresh--;
            visited[x][y] = min;
            count = Math.max(count, min - 1);
            for (int[] dir: dirs){
                int nx = x + dir[0], ny = y + dir[1], nm = min + 1;
                if (nx >= 0 && nx < m && ny >= 0 && ny < n
                        && grid[nx][ny] == 1 &&
                        (visited[nx][ny] > nm || visited[nx][ny] == 0)){
                    rotten.add(new int[]{nx, ny, nm});
                }
            }
        }

        if (fresh != 0) return -1;
        return count;
    }

    public static void main(String[] args) {
        RottenOranges_994 r = new RottenOranges_994();
        r.orangesRotting(new int[][]{{2,2},{1,1},{0,0},{2,0}});
    }
}
