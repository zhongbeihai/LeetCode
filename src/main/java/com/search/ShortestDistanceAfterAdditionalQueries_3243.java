package com.search;

import javafx.util.Pair;

import java.util.*;

public class ShortestDistanceAfterAdditionalQueries_3243 {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        int[] res = new int[queries.length];
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < n - 1; i++){
            List<Integer> tem = new ArrayList<>();
            tem.add(i + 1);
            list.add(tem);
        }
        for(int i = 0; i < queries.length; i++){
            List<Integer> tem = list.get(queries[i][0]);
            tem.add(queries[i][1]);
            res[i] = distanceQuery(list, n);
        }
        return res;
    }

    public int distanceQuery(List<List<Integer>> list, int end){
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>((a,b) -> a.getValue() - b.getValue());
        pq.add(new Pair<>(0 , 0));
        boolean[] visited = new boolean[end];
        Arrays.fill(visited, false);
        while (!pq.isEmpty()){
            Pair<Integer, Integer> pair = pq.poll();
            int u = pair.getKey(), c = pair.getValue();
            if(u == end - 1) return c;
            visited[u] = true;
            List<Integer> tem = list.get(u);
            for (Integer integer : tem) {
                if (visited[integer]) continue;
                pq.add(new Pair<>(integer, c + 1));
            }
        }

        return end;
    }

    public static void main(String[] args) {
        ShortestDistanceAfterAdditionalQueries_3243 s = new ShortestDistanceAfterAdditionalQueries_3243();
        s.shortestDistanceAfterQueries(5, new int[][]{{2,4},{0,2},{0,4}});
    }
}
