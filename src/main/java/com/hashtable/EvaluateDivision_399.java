package com.hashtable;

import java.util.*;

public class EvaluateDivision_399 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> adj = new HashMap<>();
        for (int i = 0; i < equations.size(); i++){
            List<String > equ = equations.get(i);
            adj.computeIfAbsent(equ.get(0), v -> new HashMap<>()).put(equ.get(1), values[i]);
            adj.computeIfAbsent(equ.get(1), v -> new HashMap<>()).put(equ.get(0), 1.0 / values[i]);
        }

        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String > query = queries.get(i);
            String start = query.get(0), end = query.get(1);
            if (!adj.containsKey(start) || !adj.containsKey(end)) res[i] = -1;
            else {
                res[i] = dfs(adj, start, end,  new HashSet<>(), 1.0);
            }
        }

        return res;
    }

    public double dfs(Map<String, Map<String, Double>> adj, String start, String end, Set<String> visited, double acc){
        // end condition
        if (start.equals(end)) return acc;

        Map<String, Double> nexts = adj.get(start);
        visited.add(start);

        for (String next: nexts.keySet()){
            if (!visited.contains(next)){
                double ans = dfs(adj, next, end, visited, acc * nexts.get(next));
                if (ans != -1.0) return ans;
            }
        }

        return -1.0;
    }



    public static void main(String[] args) {
        List<String> e1 = new ArrayList<>();
        e1.add("a");
        e1.add("b");
        List<String> e2 = new ArrayList<>();
        e2.add("b");
        e2.add("c");
        List<List<String>> eq = new ArrayList<>();
        eq.add(e1);
        eq.add(e2);
        double[] values = {2.0, 3.0};

        List<String> q1 = new ArrayList<>();
        q1.add("a");
        q1.add("c");
        List<List<String>> queries = new ArrayList<>();
        queries.add(q1);

        EvaluateDivision_399 e = new EvaluateDivision_399();
        e.calcEquation(eq, values, queries);
    }
}
