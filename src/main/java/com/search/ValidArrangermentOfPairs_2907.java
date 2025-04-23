package com.search;

import java.util.*;

public class ValidArrangermentOfPairs_2907 {
    LinkedList<int[]> path = new LinkedList<>();

    public int[][] validArrangement(int[][] pairs) {
        Map<Integer, LinkedList<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> inOutDeg = new HashMap<>();

        // make it to graph
        for(int[] pair: pairs){
            inOutDeg.put(pair[0], inOutDeg.getOrDefault(pair[0], 0) + 1);
            inOutDeg.put(pair[1], inOutDeg.getOrDefault(pair[1], 0) - 1);
            LinkedList<Integer> l = graph.get(pair[0]);
            if (l == null){
                l = new LinkedList<>();
                l.add(pair[1]);
                graph.put(pair[0], l);
            }else {
                l.add(pair[1]);
            }
        }

        // find the starting node
        int startNode = pairs[0][0];
        for(int node: inOutDeg.keySet()){
            if(inOutDeg.get(node) == 1){
                startNode = node;
                break;
            }
        }


        dfs(graph, path, startNode);
        int[][] res= new int[path.size()][];
        path.toArray(res);
        return res;
    }

    private void dfs(Map<Integer, LinkedList<Integer>> graph, LinkedList<int[]> path, int curr){
        LinkedList<Integer> neighbors = graph.getOrDefault(curr, new LinkedList<>());
        while (!neighbors.isEmpty()){
            int next = neighbors.poll();
            dfs(graph, path, next);
            path.addFirst(new int[]{curr, next});
        }
    }


    public static void main(String[] args) {
        ValidArrangermentOfPairs_2907 v = new ValidArrangermentOfPairs_2907();
        v.validArrangement(new int[][]{{1,3},{1,2},{2,1}});
    }
}
