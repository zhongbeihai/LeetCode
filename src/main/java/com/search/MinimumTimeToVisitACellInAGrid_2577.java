package com.search;

import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class MinimumTimeToVisitACellInAGrid_2577 {
    public int minimumTime(int[][] grid) {
        Deque<Pair<Integer, Integer>> deque = new ArrayDeque<>();
        int[][] directions = new int[][]{{0,1}, {-1,0}, {1,0},{0,-1}};
        int res = Integer.MAX_VALUE;
        boolean[] visited = new boolean[grid.length * grid[0].length];
        Arrays.fill(visited, false);

        deque.add(new Pair<>(0, 0));
        while (!deque.isEmpty()){
            Pair<Integer, Integer> curCell = deque.poll();
            int in = curCell.getKey(), li = curCell.getValue();
            visited[in] = true;
            if(in == grid.length * grid[0].length - 1) res = Math.min(res, li);
            int x = in / grid[0].length, y = in % grid[0].length;
            for (int[] dir: directions){
                int nx = x + dir[0];
                int ny = y + dir[1];
                if(nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length
                        && grid[nx][ny] <= li + 1){
                    int nin = nx * grid[0].length + ny;
                    if(visited[nin]) continue;
                    deque.add(new Pair<>(nin, li + 1));
                }
            }
        }
        return !visited[grid.length * grid[0].length - 1] ? -1 : res;
    }

    public static void main(String[] args) {
        MinimumTimeToVisitACellInAGrid_2577 m = new MinimumTimeToVisitACellInAGrid_2577();
        m.minimumTime(new int[][]{{0,1,3,2},{5,1,2,5},{4,3,8,6}});
    }
}
