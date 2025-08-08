package com.hashtable;

import java.util.*;

public class EvaluateDivision_399 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, HashMap<String, Double>> map = new HashMap<>();
        HashSet<String> inputSet = new HashSet<>();
        int i = 0;
        for (List<String> equation: equations){
            double val = values[i++];
            map.computeIfAbsent(equation.get(0), k -> new HashMap<>()).put(equation.get(1), val);
            map.computeIfAbsent(equation.get(1), k -> new HashMap<>()).put(equation.get(0), 1.0 / val);
            inputSet.add(equation.get(0));
            inputSet.add(equation.get(1));
        }

        double[] res = new double[queries.size()];
        for (int j = 0; j < queries.size(); j++) {
            List<String> query = queries.get(j);
            if (!inputSet.containsAll(query)) res[j] = -1.0;
            else if (query.get(0).equals(query.get(1))) {
                res[j] = 1.0;
            } else res[j] = dfs(query.get(0), query.get(1), 1.0, map, new HashSet<>());
        }

        return res;
    }

    public double dfs(String start, String end, double curValue, HashMap<String, HashMap<String, Double>> map, Set<String> visited){
        if (!map.containsKey(start) || visited.contains(start)) return -1.0;
        if (map.get(start).containsKey(end)) return curValue * map.get(start).get(end);

        visited.add(start);
        for (Map.Entry<String, Double> entry : map.get(start).entrySet()) {
            double result = dfs(entry.getKey(), end, curValue * entry.getValue(), map, visited);
            if (result != -1.0) return result;
        }
        return -1.0;
    }

    public static void main(String[] args) {

    }
}
