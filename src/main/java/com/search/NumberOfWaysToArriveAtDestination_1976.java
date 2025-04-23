package com.search;

import java.util.*;

public class NumberOfWaysToArriveAtDestination_1976 {
    public int countPaths(int n, int[][] roads) {
        int MOD = 1_000_000_007;
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }

        for (int[] road: roads){
            int u = road[0], v = road[1], time = road[2];
            graph.get(u).add(new int[]{v, time});
            graph.get(v).add(new int[]{u, time});
        }

        long[] dist = new long[n];
        int[] ways = new int[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0; ways[0] = 1;

        PriorityQueue<long[]> queue = new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));
        queue.add(new long[]{0,0});

        while (!queue.isEmpty()){
            long[] p = queue.poll();
            int node = (int) p[0];
            long curTime = p[1];
            if (curTime > dist[node]) continue;

            List<int[]> neighbors = graph.get(node);
            for (int[] nei: neighbors){
                int nextNode = nei[0], weight = nei[1];
                if (dist[node] + weight < dist[nextNode]){
                    dist[nextNode] = dist[node] + weight;
                    ways[nextNode] = ways[node];
                    queue.add(new long[]{nextNode, dist[nextNode]});
                } else if (dist[node] + weight == dist[nextNode]) {
                    ways[nextNode] = (ways[node] + ways[nextNode]) % MOD;
                }
            }
        }


        return ways[n - 1];
    }
}
