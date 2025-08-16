package com.search;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule_207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        // build graph and count in-degree
        int[] inDre =new int[numCourses];
        for (int[] pre: prerequisites){
            inDre[pre[1]]++;
            graph[pre[0]].add(pre[1]);
        }

        // bfs
        int count = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDre[i] == 0) queue.add(i);
        }
        while (!queue.isEmpty()){
            count++;
            int from = queue.poll();
            List<Integer> to = graph[from];
            for (int t: to){
                inDre[t]--; // meet all the prerequisites
                if (inDre[t] == 0) queue.add(t);
            }
        }

        return count == numCourses;
    }
}
