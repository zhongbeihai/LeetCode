package com.dynamic_programming;

import java.util.*;

public class LargestColorValueInDirectedGraph_1857 {
    public int largestPathValue(String colors, int[][] edges) {
        char[] colorsChar = colors.toCharArray();

        HashMap<Integer, List<Integer>> adaj = new HashMap<>();
        for (int[] edge: edges){
            adaj.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
        }


        int[][] dp = new int[colorsChar.length][26];
        int[] visit = new int[colorsChar.length]; // 0 -> not visit, 1 -> visiting, 2 -> visited

        int res = 0;
        for (int i = 0; i < colorsChar.length; i++){
            res = Math.max(res, dfs(i, colorsChar, adaj, dp, visit));
        }

        return res;
    }

    public int dfs(int node, char[] colors, Map<Integer, List<Integer>> adaj, int[][] dp, int[] visit){
        if (visit[node] == 1) { // circle
            return Integer.MAX_VALUE;
        }

        if (visit[node] == 2){
            return dp[node][colors[node] - 'a'];
        }

        visit[node] = 1;

        List<Integer> nextNode = adaj.get(node);
        if (nextNode != null && !nextNode.isEmpty()){
            for (int nn: nextNode){
                int res = dfs(nn, colors, adaj, dp, visit);
                if (res == Integer.MAX_VALUE) return Integer.MAX_VALUE;
                for (int i = 0; i < 26; i++){
                    dp[node][i] = Math.max(dp[node][i], dp[nn][i]);
                }
            }
        }

        dp[node][colors[node] - 'a']++;
        visit[node] = 2;
        return dp[node][colors[node] - 'a'];
    }
}
