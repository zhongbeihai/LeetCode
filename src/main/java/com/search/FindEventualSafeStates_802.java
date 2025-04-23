package com.search;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FindEventualSafeStates_802 {

    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> safe = new ArrayList<>();
        int[] states = new int[graph.length];

        for (int i = 0; i < graph.length; i++){
            if (dfs(graph, i, states)) safe.add(i);
        }

        return safe;
    }

    public boolean dfs(int[][] graph, int node, int[] states){
        if (states[node] > 0) return states[node] == 2;
        states[node] = 1;

        for (int next: graph[node]){
            if (states[next] == 1 || !dfs(graph, next, states)) return false;
        }

        states[node] = 2;
        return true;
    }

    public static void main(String[] args) {
        FindEventualSafeStates_802 f = new FindEventualSafeStates_802();
        f.eventualSafeNodes(new int[][]{{1,2},{2,3},{5},{0},{5},{},{}});
    }
}
