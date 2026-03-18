package com.search;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] time: times){
            adj.get(time[0] - 1).add(new int[]{time[1] - 1, time[2]}); // {destination, time}
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(i -> i[1]));
        int cnt = 0, timeUsed = 0;
        pq.add(new int[]{k - 1, 0});
        boolean[] visited = new boolean[n];
        while (!pq.isEmpty()){
            int[] cur = pq.poll();
            int curNode = cur[0], curTime = cur[1];
            if (visited[curNode]) continue;

            timeUsed = Math.max(timeUsed, curTime);
            cnt++;
            visited[curNode] = true;

            for (int[] nei: adj.get(curNode)){
                if (!visited[nei[0]]){
                    pq.add(new int[]{nei[0], curTime + nei[1]});
                }
            }
        }

        return cnt == n ? timeUsed : -1;
    }

    public static void main(String[] args) {

    }
}
