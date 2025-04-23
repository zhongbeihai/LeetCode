package com.search;

import java.util.ArrayList;
import java.util.List;

public class CountTheNumberOfCompleteComponents_2685 {
    public int countCompleteComponents(int n, int[][] edges) {
        List<Integer>[] graph = new List[n];
        for (int i = 0 ; i < n; i++){
            graph[i] = new ArrayList<>();
        }

        for (int[] edge: edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        int[] visited = new int[n];
        int res = 0;
        for (int i = 0; i < n; i++){
            if (visited[i] == 0) {
                int[] r = dfs(graph, visited, i);
                if ((r[0] * (r[0] - 1) / 2) == r[1]) res++;
            }
        }

        return res;
    }

    public int[] dfs(List<Integer>[] graph, int[] visited, int start){

        int nc = 0, ec = 0;
        visited[start] = 1;
        nc++;
        
        for (int next: graph[start]){
            if (visited[next] == 0){
                int[] r = dfs(graph, visited, next);
                nc += r[0];
                ec += r[1];
            } else if (visited[next] == 1) {
                ec++;
            }
        }

        visited[start] = 2;

        return new int[]{nc ,ec};
    }

    public static void main(String[] args) {
        CountTheNumberOfCompleteComponents_2685 c= new CountTheNumberOfCompleteComponents_2685();
        c.countCompleteComponents(6, new int[][]{{0,1},{0,2},{1,2},{3,4},{3,5}});
    }
}
