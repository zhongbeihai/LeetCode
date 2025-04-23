package com.dequeue_and_priorityqueue;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;

/**
 *     0 1 2 3 4
 *  0  / 1 1 1 1
 *  1  1 / 1 1 1
 *  2  1 1 / 1 1
 *  3  1 1 1 / 1
 *  4  1 1 1 1 /
 */
public class DetonateTheMaximumBombs {
    public int maximumDetonation(int[][] bombs) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < bombs.length; i++){
            graph.add(new ArrayList<>());
            for(int j = 0; j < bombs.length; j++){
                if(checkDistance(bombs[i], bombs[j]) == 1 && i != j){
                    graph.get(i).add(j);
                }
            }
        }

        int ans =  0;
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < graph.size(); i++){
            q.offer(i);
            int count = 0;
            boolean[] visited = new boolean[bombs.length];
            while (!q.isEmpty()){
                int cur = q.poll();
                count++;
                visited[cur] = true;
                for(int n : graph.get(cur)){
                    if(!visited[n] && !q.contains(n)){
                        q.offer(n);
                    }
                }
            }
            ans = Math.max(ans, count);
        }


        return ans;
    }

    public int checkDistance(int[] bomb1, int[]bomb2){
        long dx = bomb1[0] - bomb2[0];
        long dy = bomb1[1] - bomb2[1];
        long r = bomb1[2];
        return dx * dx + dy * dy <= r * r ? 1 : 0;
    }

    public static void main(String[] args) {
        DetonateTheMaximumBombs d = new DetonateTheMaximumBombs();
        d.maximumDetonation(new int[][]{{1,2,3},{2,3,1},{3,4,2},{4,5,3},{5,6,4}});
    }
}
