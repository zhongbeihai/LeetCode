package com.hashtable;

import java.util.*;

public class EvaluateDivision_399 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> map = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String st = equations.get(i).get(0), ed = equations.get(i).get(1);
            map.computeIfAbsent(st, k -> new HashMap<>()).put(ed, values[i]);
            map.computeIfAbsent(ed, k-> new HashMap<>()).put(st, 1.0 / values[i]);
        }

        double[] res = new double[queries.size()];
        int i = 0;
        for (List<String> query: queries){
            String start = query.get(0), end = query.get(1);
            if (!map.containsKey(start) || !map.containsKey(end)) res[i++] = -1;
            else {
                res[i++] = dfs(map, start, end, 1.0, new HashSet<>());
            }
        }

        return res;
    }

    public double dfs(Map<String, Map<String, Double>> map, String start, String end, double acc, Set<String> visited){
        if (start.equals(end)) return acc;
        visited.add(start);
        Map<String, Double> cur = map.get(start);
        for (String key: cur.keySet()){
            if (!visited.contains(key)){
                double ans = dfs(map, key, end, acc * cur.get(key), visited);
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
