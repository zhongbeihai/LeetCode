package com.search;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adjMap = new ArrayList<>();
        for (int i = 0; i <= n; i++) adjMap.add(new ArrayList<>());
        for (int[] time: times){
            adjMap.get(time[0]).add(new int[]{time[1], time[2]});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingLong(i -> i[1])); // {point, curTime}
        pq.add(new int[]{k, 0});
        boolean[] visited = new boolean[n + 1];
        int cnt = 0;
        while (!pq.isEmpty()){
            int[] cur = pq.poll();
            int curNode = cur[0], curTime = cur[1];

            if (visited[curNode]) continue;

            visited[curNode] = true;
            cnt++;

            if (cnt == n) return curTime;

            List<int[]> adj = adjMap.get(curNode);
            for (int[] next : adj) {
                if (!visited[next[0]]) {
                    pq.add(new int[]{next[0], curTime + next[1]});
                }
            }
        }

        return -1;
    }
}
