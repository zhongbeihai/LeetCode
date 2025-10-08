package com.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberOfOperationsToMakeNetworkConnected_1319 {
    public int makeConnected(int n, int[][] connections) {
        int numberOfConnections = connections.length;
        if (numberOfConnections < n - 1) return -1;
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] c: connections){
            adj[c[0]].add(c[1]);
            adj[c[1]].add(c[0]);
        }

        int cnt = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]){
                dfs(adj, visited, i);
                cnt++;
            }
        }

        return cnt - 1;
    }

    public void dfs(List<Integer>[] adj, boolean[] visited, int startPoint){
        visited[startPoint] = true;

        List<Integer> neis = adj[startPoint];
        for (int n: neis){
            if (!visited[n]) dfs(adj, visited, n);
        }
    }

    public static void main(String[] args) {
        NumberOfOperationsToMakeNetworkConnected_1319 n = new NumberOfOperationsToMakeNetworkConnected_1319();
        n.makeConnected(4, new int[][]{{0,1},{0,2}, {1,2}});
    }
}
