package com.search;

import java.util.*;

public class LoundAndRich_851 {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        if (quiet.length == 1) return new int[]{0};
        // graph[i] stores person who is poorer than i
        int[] res = new int[quiet.length];
        Arrays.fill(res, -1);
        List<Integer>[] graph = new List[quiet.length];
        for (int i = 0; i < quiet.length; i++){
            graph[i] = new ArrayList<>();
        }
        int[] inDeg = new int[quiet.length];
        for (int[] rich: richer){
            inDeg[rich[1]]++;
            graph[rich[0]].add(rich[1]);
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < quiet.length; i++){
            if (inDeg[i] == 0) queue.add(i);
            res[i] = i;
        }

        while(!queue.isEmpty()){
            int p = queue.poll();
            for (int u : graph[p]){
                if (quiet[u] < quiet[p]){
                    quiet[u] = quiet[p];
                    res[u] = res[p];
                }
                inDeg[u]--;
                if (inDeg[u] == 0) queue.add(u);
            }
        }

        return res;
    }


    public static void main(String[] args) {
        LoundAndRich_851 l = new LoundAndRich_851();
    }
}
