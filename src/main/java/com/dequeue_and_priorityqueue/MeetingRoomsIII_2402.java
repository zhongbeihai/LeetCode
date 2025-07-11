package com.dequeue_and_priorityqueue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoomsIII_2402 {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, Comparator.comparingInt(i -> i[0]));
        PriorityQueue<int[]> inUsedQue = new PriorityQueue<>((i, j) -> {
            if (i[0] == j[0]) return i[1] - j[1];
            else return i[0] - j[0];
        }); // int[0] -> endTime, int[1] -> room Number
        PriorityQueue<Integer> unusedQue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            unusedQue.add(i);
        }
        int[] timesUsed = new int[n];

        for (int[] meeting: meetings){
            int startTime = meeting[0], endTime = meeting[1], duration = endTime - startTime;

            while (!inUsedQue.isEmpty() && inUsedQue.peek()[0] <= startTime){
                int[] p = inUsedQue.poll();
                unusedQue.add(p[1]);
            }

            if (!unusedQue.isEmpty()){
                int meetingRoom = unusedQue.poll();
                timesUsed[meetingRoom]++;

                inUsedQue.add(new int[]{endTime, meetingRoom});
            }else {
                int[] tem = inUsedQue.poll();
                timesUsed[tem[1]]++;

                int newStartTime = Math.max(tem[0], startTime);
                inUsedQue.add(new int[]{newStartTime + duration, tem[1]});
            }

        }

        int maxx = 0, res = 0;
        for (int i = 0; i < n; i++) {
            if (timesUsed[i] > maxx){
                maxx = timesUsed[i];
                res = i;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        MeetingRoomsIII_2402 m = new MeetingRoomsIII_2402();
        m.mostBooked(4, new int[][]{{18,19}, {3, 12}, {17, 19}, {2, 13}, {7, 10}});
        // m.mostBooked(3, new int[][]{{1,20},{2, 10}, {3, 5}, {4, 9}, {6, 8}});
    }
}
