package com.search;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule_207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 1) return true;

        List<Integer>[] graph = new List[numCourses];
        int[] ing = new int[numCourses];
        for (int[] pre: prerequisites){
            if (graph[pre[0]] == null) graph[pre[0]] = new ArrayList<>();
            graph[pre[0]].add(pre[1]);
            ing[pre[1]]++;
        }

        int n = numCourses;
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (ing[i] == 0) {queue.add(i); n--;}
        }

        while (!queue.isEmpty()){
            int cur = queue.poll();
            List<Integer> nexts = graph[cur];
            if (nexts == null) continue;

            for (int next: nexts){
                ing[next]--;
                if (ing[next] == 0) {
                    queue.add(next);
                    n--;
                }
            }
        }

        return n == 0;

    }
}
