package com.search;

import java.util.*;

public class MakeALargeIsland_827 {
    private int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public int largestIsland(int[][] grid) {
        int m = grid[0].length, n = grid.length;
        List<Integer> key = new ArrayList<>();
        int groupId = 2;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] == 1) {
                    int res = bfs(grid, new int[]{i, j}, groupId);
                    key.add(res);
                    groupId++;
                }
            }
        }
        if (key.isEmpty()) return 0;

        int max = 0;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] == 0){
                    HashSet<Integer> seen = new HashSet<>();
                    int sum = 1;
                    for (int[] dir: dirs){
                        int ni = i + dir[0], nj = j + dir[1];
                        if (ni >= 0 && ni < n && nj >= 0 && nj < n && grid[ni][nj] >= 2) {
                            int islandId = grid[ni][nj];
                            if (!seen.contains(islandId)){
                                sum += key.get(islandId - 2);
                                seen.add(islandId);
                            }
                        }
                    }
                    max = Math.max(max, sum);
                }
            }
        }
        return max == 0 ? n * n : max;
    }

    public int bfs(int[][] grid, int[] start, int id){
        Queue<int[]> queue = new LinkedList<>();
        int m = grid[0].length, n = grid.length;

        queue.add(start);

        grid[start[0]][start[1]] = id;
        int count = 0;
        while (!queue.isEmpty()){
            int[] curPoint = queue.poll();
            int x = curPoint[0], y = curPoint[1];
            count++;
            for (int[] dir: dirs){
                int nx = x + dir[0], ny = y + dir[1];
                if (nx >= 0 && ny >= 0 &&
                nx < m && ny < n && grid[nx][ny] == 1){
                    queue.add(new int[]{nx, ny});
                    grid[nx][ny] = id;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        MakeALargeIsland_827 m = new MakeALargeIsland_827();
        m.largestIsland(new int[][]{{1,1},{0,1}});
    }

}
