package com.search;

import java.util.*;

public class MinimumCostWalkInWeightedGraph_3108 {
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        List<List<int[]>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] e : edges){
            int u = e[0], v = e[1], w = e[2];
            graph.get(u).add(new int[]{v, w});
            graph.get(v).add(new int[]{u, w});
        }

        int q = query.length;
        int[] res = new int[q];
        for(int i = 0; i < q; i++){
            int start = query[i][0];
            int end = query[i][1];
            res[i] = dj(n, graph, start, end);
        }
        return res;
    }


    public int dj(int n, List<List<int[]>> graph, int start, int end){
        int[] best = new int[n];
        // -1 means still haven't found solution
        Arrays.fill(best, -1);

        best[start] = 0xFFFFFFFF;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{start, best[start]});

        while (!pq.isEmpty()){
            int[] ele = pq.poll();
            int u = ele[0];
            int w = ele[1];

            if (w > best[u]) continue;

            if (u == end){
                return w;
            }

            for (int[] edge: graph.get(u)){
                int v = edge[0];
                int nw = w & edge[1];

                if (best[v] == -1 || nw < best[v]){
                    best[v] = nw;
                    pq.offer(new int[]{v, best[v]});
                }
            }
        }

        return -1;

    }
}
