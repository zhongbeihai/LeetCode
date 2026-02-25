package com.search;

import com.backtrack.NQueens_51;

import java.util.*;

public class NumberOfConnectedComponentsInAnUndirectedGraph_323 {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {adjList.add(new ArrayList<>());}
        for (int[] edge: edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        int res = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]){
                Queue<Integer> queue = new ArrayDeque<>();
                queue.add(i);

                while (!queue.isEmpty()){
                    int cur = queue.poll();
                    visited[cur] = true;
                    List<Integer> adj = adjList.get(cur);
                    for (int next: adj){
                        if (!visited[next]) queue.add(next);
                    }
                }
                res++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        NumberOfConnectedComponentsInAnUndirectedGraph_323 n = new NumberOfConnectedComponentsInAnUndirectedGraph_323();
        n.countComponents(5, new int[][]{{0,1},{0,1},{1,2},{3,4}});
    }
}
