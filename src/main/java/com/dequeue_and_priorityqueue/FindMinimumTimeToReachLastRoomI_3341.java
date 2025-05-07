package com.dequeue_and_priorityqueue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class FindMinimumTimeToReachLastRoomI_3341 {
    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length, m = moveTime[0].length;
        int[][] dist = new int[n][m];
        for (int[] row: dist) Arrays.fill(row, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(value -> value[0]));

        pq.add(new int[]{1, 0, 0});
        dist[0][0] = 1;
        int[][] dirs = new int[][]{{0,1}, {0,-1},{1,0},{-1,0}};
        while (!pq.isEmpty()){
            int[] p = pq.poll();
            int curTime = p[0], x = p[1], y = p[2];
            if (x == n - 1 && y == m - 1) return curTime ;
            if (curTime > dist[x][y]) continue;

            for (int[] dir: dirs){
                int nx = x + dir[0], ny = y + dir[1];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m){
                    int nextTime = curTime + 1;
                    nextTime = Math.max(curTime + 1, moveTime[nx][ny]);

                    if (nextTime < dist[nx][ny]) {
                        dist[nx][ny] = nextTime;
                        pq.add(new int[]{nextTime, nx, ny});
                    }
                }

            }
        }
        return dist[n - 1][m - 1];
    }

    public static void main(String[] args) {
        FindMinimumTimeToReachLastRoomI_3341 f = new FindMinimumTimeToReachLastRoomI_3341();
        f.minTimeToReach(new int[][]{{0,4},{4,4}});
    }
}
