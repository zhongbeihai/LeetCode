package com.dequeue_and_priorityqueue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoomsIII_2402 {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, Comparator.comparingInt(i -> i[0]));
        PriorityQueue<long[]> inUsed = new PriorityQueue<>((i, j) -> {
            if (i[1] == j[1]) return Long.compare(i[0], j[0]);
            return Long.compare(i[1], j[1]);
        }); // {idx, ending time}
        PriorityQueue<Integer> unUsed = new PriorityQueue<>();
        int[] fre = new int[n];
        for (int i = 0; i < n; i++) unUsed.add(i);

        for (int[] m: meetings){
            long start = m[0], end = m[1];

            while (!inUsed.isEmpty() && inUsed.peek()[1] <= start) {
                unUsed.add((int) inUsed.poll()[0]);
            }

            if (!unUsed.isEmpty()) {
                int availableRoom = unUsed.poll();
                fre[availableRoom]++;
                inUsed.add(new long[]{availableRoom, end});
            } else {
                long[] room = inUsed.poll();
                fre[(int) room[0]]++;
                long during = end - start;
                inUsed.add(new long[]{room[0], room[1] + during});
            }
        }

        int room = -1, f = 0;
        for (int i = 0; i < n; i++) {
            if (fre[i] > f){
                room = i;
                f = fre[i];
            }
        }

        return room;
    }

    public static void main(String[] args) {
        MeetingRoomsIII_2402 m = new MeetingRoomsIII_2402();
        // m.mostBooked(4, new int[][]{{18,19}, {3, 12}, {17, 19}, {2, 13}, {7, 10}});
        m.mostBooked(3, new int[][]{{1,20},{2, 10}, {3, 5}, {4, 9}, {6, 8}});

        // inUsed: {2, 10} , {1, 10}, {0, 20},
    }
}
