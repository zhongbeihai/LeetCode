package com.search;

import java.util.*;

public class CoursesScheduleIv_1462 {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            graph.get(pre[0]).add(pre[1]);
        }
        boolean[][] isReachable = new boolean[numCourses][numCourses];
        for (int i = 0; i < numCourses; i++) {
            bfs(i,numCourses,  isReachable, graph );
        }

        List<Boolean> res = new ArrayList<>();
        for (int[] query: queries){
            res.add(isReachable[query[0]][query[1]]);
        }

        return res;
    }

    public void bfs(int start, int numCourses, boolean[][] isReachable, List<List<Integer>> graph){
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(start);
        while (!deque.isEmpty()){
            int cur = deque.pollFirst();
            for (int neighbor: graph.get(cur)){
                if (!isReachable[start][neighbor]){
                    isReachable[start][neighbor] = true;
                    deque.add(neighbor);
                }
            }
        }

    }

    public static void main(String[] args) {
        CoursesScheduleIv_1462 c = new CoursesScheduleIv_1462();
        // c.checkIfPrerequisite(6, new int[][]{{0,5},{1,2},{2,3},{5,1}}, new int[][]{{0,3}});
        c.checkIfPrerequisite(5, new int[][]{{3,4},{2,3},{1,2},{0,1}}, new int[][]{{0,4}});
    }
}
