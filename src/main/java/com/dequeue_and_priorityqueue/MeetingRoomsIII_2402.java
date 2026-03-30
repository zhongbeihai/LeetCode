package com.dequeue_and_priorityqueue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoomsIII_2402 {
    // sort the meetings by its start time
    // use two priorityQueue ->
    // 1. maintain the meeting rooms in used  (in the order of end time)
    // 2. the meeting room that are available(in the order of the number)
    // traverse all the meetings
    // record the meeting room that used the most
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, Comparator.comparingInt(i -> i[0]));
        PriorityQueue<Integer> availableRoom = new PriorityQueue<>(); // in the order the room number
        PriorityQueue<long[]> roomInUsed = new PriorityQueue<>((i, j) -> {
            if (i[1] == j[1]) return Long.compare(i[0], j[0]);
            return Long.compare(i[1], j[1]);
        }); // {room number, end time of the meetings}
        for (int i = 0; i < n; i++) availableRoom.add(i);

        int[] count = new int[n];
        // traversal all the meetings
        for (int[] m: meetings){
            int start = m[0], end = m[1], duration = end - start;
            // release all the rooms that become available
            while (!roomInUsed.isEmpty() && start >= roomInUsed.peek()[1]){
                availableRoom.add((int) roomInUsed.poll()[0]);
            }

            // there all still available meeting rooms
            if (!availableRoom.isEmpty()){
                int roomNumber = availableRoom.poll();
                count[roomNumber]++;
                roomInUsed.add(new long[]{roomNumber, end});
            }else { // not any meeting room is available
                // we must wait for the room that will be released earliest
                long[] room = roomInUsed.poll();
                int roomNumber = (int) room[0];
                count[roomNumber]++;
                roomInUsed.add(new long[]{roomNumber, room[1] + duration});
            }
        }

        int ans = 0;
        for (int i = 1; i < n; i++) {
            if (count[i] > count[ans]) {
                ans = i;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        MeetingRoomsIII_2402 m = new MeetingRoomsIII_2402();
        // m.mostBooked(4, new int[][]{{18,19}, {3, 12}, {17, 19}, {2, 13}, {7, 10}});
        m.mostBooked(3, new int[][]{{1,20},{2, 10}, {3, 5}, {4, 9}, {6, 8}});

        // inUsed: {2, 10} , {1, 10}, {0, 20},
    }
}
