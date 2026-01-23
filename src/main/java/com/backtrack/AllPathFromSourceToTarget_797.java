package com.backtrack;

import java.util.*;

public class AllPathFromSourceToTarget_797 {
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        Map<Integer, List<Integer>> graphs = new HashMap<>();
        for (int i = 0; i < graph.length; i++) {
            graphs.putIfAbsent(i, new ArrayList<>());
            List<Integer> list = graphs.get(i);
            for (int g: graph[i]) list.add(g);
        }

        List<Integer> tem = new ArrayList<>();
        tem.add(0);
        dfs(graphs, 0, tem);

        return res;
    }

    public void dfs(Map<Integer, List<Integer>> graphs, int idx, List<Integer> tem){
        if (idx == graphs.size() - 1) {
            res.add(new ArrayList<>(tem));
            return;
        }

        List<Integer> neis = graphs.get(idx);
        for (int n: neis){
            tem.add(n);

            dfs(graphs, n, tem);

            tem.remove(tem.size() - 1);
        }
    }

    public static void main(String[] args) {
        AllPathFromSourceToTarget_797 a = new AllPathFromSourceToTarget_797();
        a.allPathsSourceTarget(new int[][]{{4,3,1}, {3,2,4},{3}, {4},{}});
    }
}
