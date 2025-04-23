package com.backtrack;

import java.util.ArrayList;
import java.util.List;

public class AllPathFromSourceToTarget_797 {
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        ArrayList<Integer> l = new ArrayList<>();
        l.add(0);
        backtrack(graph, l, 0);
        return res;
    }

    public void backtrack(int[][] graph, List<Integer> tem, int location) {
        if(location == graph.length - 1) {
            res.add(new ArrayList<>(tem));
        }
        if(graph[location] == null){
            return;
        }
        for(int i = 0; i < graph[location].length; i++){
            tem.add(graph[location][i]);

            backtrack(graph, tem, graph[location][i]);

            tem.remove(tem.size() - 1);
        }
    }

    public static void main(String[] args) {
        AllPathFromSourceToTarget_797 a = new AllPathFromSourceToTarget_797();
        a.allPathsSourceTarget(new int[][]{{4,3,1}, {3,2,4},{3}, {4},{}});
    }
}
