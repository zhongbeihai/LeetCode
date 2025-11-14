package com.hashtable;

import java.util.*;

public class EvaluateDivision_399 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, HashMap<String, Double>> map = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> list = equations.get(i);
            map.computeIfAbsent(list.get(0), k -> new HashMap<>()).put(list.get(1), values[i]);
            map.computeIfAbsent(list.get(1), k -> new HashMap<>()).put(list.get(0), 1.0 / values[i]);
        }

        double[] res = new double[queries.size()];
        int i = 0;
        for (List<String > query: queries){
            res[i++] = dfs(map, query.get(0), query.get(1), new HashSet<>());
        }

        return res;

    }

    public double dfs(HashMap<String, HashMap<String, Double>> map, String start, String end, Set<String> visited){
        if (!map.containsKey(start)) return -1.0;
        if (start.equals(end)) return 1.0;

        visited.add(start);
        HashMap<String, Double> nexts = map.get(start);
        if (nexts == null) return  -1;

        for (String next: nexts.keySet()){
            if (Objects.equals(next, end)) return nexts.get(next);
            if (!visited.contains(next)) {
                double v = nexts.get(next) * dfs(map, next, end, visited);
                if (v > 0) return v;
            }
        }

        return -1;
    }


    public static void main(String[] args) {

    }
}
