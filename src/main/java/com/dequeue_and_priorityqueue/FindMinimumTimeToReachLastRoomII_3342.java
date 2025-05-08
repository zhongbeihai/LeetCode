package com.dequeue_and_priorityqueue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class FindMinimumTimeToReachLastRoomII_3342 {
    public int minTimeToReach(int[][] moveTime) {
        int m = moveTime.length, n = moveTime[0].length;
        int[][] time = new int[m][n];
        for (int[] row: time) Arrays.fill(row, Integer.MAX_VALUE);

        PriorityQueue<int[]> deque = new PriorityQueue<>(Comparator.comparingInt(value -> value[0]));
        time[0][0] = 0;
        deque.add(new int[]{0,0,0});

        int[][] directions = new int[][]{{1,0},{-1,0}, {0,1},{0, -1}};
        while(!deque.isEmpty()){
            int[] p = deque.poll();
            int curTime = p[0], x = p[1], y = p[2];

            if (x == m - 1 && y == n - 1) return curTime;
            for (int[] dir: directions){
                int nx = x + dir[0], ny = y + dir[1];
                int stepSize = (nx + ny) % 2 == 0 ? 2 : 1;

                if (nx < 0 || nx >= m || ny < 0 || ny >= n || moveTime[nx][ny] == -1) continue;
                int nextTime = Math.max(curTime, moveTime[nx][ny]) + stepSize;
                if (nextTime >= time[nx][ny]) continue;


                time[nx][ny] = nextTime;
                moveTime[nx][ny] = -1;
                deque.add(new int[]{nextTime, nx, ny});
            }
        }

        return time[m - 1][n - 1];
    }

    public static void main(String[] args) {
        FindMinimumTimeToReachLastRoomII_3342 f = new FindMinimumTimeToReachLastRoomII_3342();
        f.minTimeToReach(new int[][]{{0,4},{4,4}});
    }
}
