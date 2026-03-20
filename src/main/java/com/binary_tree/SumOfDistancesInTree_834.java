package com.binary_tree;

import java.util.*;

public class SumOfDistancesInTree_834 {
    // prune
    Map<String, Integer> mem = new HashMap<>();  // "start#end"
    List<List<Integer>> adj = new ArrayList<>();
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] e: edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        int[] res = new int[n];
        for (int i = 0; i < n; i++){
            int dis = 0;
            for (int j = 0; j < n; j++) {
                    dis += bfs(i, j, new boolean[n]);
            }
            res[i] = dis;
        }

        return res;
    }

    public int bfs(int start, int end, boolean[] visited){
        String key = start + "#" + end;
        String keyRev = end + "#" + start;
        if (mem.containsKey(key)) return mem.get(key);
        if (mem.containsKey(keyRev)) return mem.get(keyRev);

        Deque<int[]> nodeQueue = new ArrayDeque<>();
        nodeQueue.add(new int[]{start, 0});
        visited[start] = true;
        while (!nodeQueue.isEmpty()){
            int[] cur = nodeQueue.poll();
            int curNode = cur[0], curStep = cur[1];


            if (curNode == end){
                mem.put(key, curStep);
                mem.put(keyRev, curStep);
                return curStep;
            }

            for (int nei: adj.get(curNode)){
                if (!visited[nei]){
                    nodeQueue.add(new int[]{nei, curStep + 1});
                    visited[nei] = true;
                }
            }
        }

        return 0;
    }

    public int dfs(int start, int end){
        // return condition
        if (start == end) return 0;
        String key = start + "#" + end;
        if (mem.containsKey(key)) return mem.get(key);

        int dis = Integer.MAX_VALUE / 2;
        for (int nei: adj.get(start)){
            dis = Math.min(dis, dfs(nei, end)); // we must assume all node are connected
        }
        dis += 1;
        mem.put(key, dis);

        return dis;
    }
}
