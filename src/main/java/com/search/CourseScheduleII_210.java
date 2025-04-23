package com.search;

import java.util.*;

public class CourseScheduleII_210 {
    private List<Integer> l;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new List[numCourses];
        int[] inDeg = new int[numCourses];

        for (int i = 0; i < numCourses; i++){
            graph[i] = new ArrayList<>();
        }
        for (int[] pre: prerequisites){
            // count inDegree. inDegree == 0, it is start point
            inDeg[pre[0]]++;
            // build graph
            graph[pre[1]].add(pre[0]);
        }

        // bfs
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i =0; i < numCourses; i++){
            if (inDeg[i] == 0) {
                queue.add(i);
            }

        }
        int[] res = new int[numCourses];
        int count = 0;
        while (!queue.isEmpty()){
            int course = queue.poll();
            res[count++] = course;

            List<Integer> list = graph[course];
            for (int c : list){
                inDeg[c]--;
                if (inDeg[c] == 0){
                    queue.add(c);
                }
            }
        }
        return count == numCourses ? res: new int[0];

    }


    public static void main(String[] args) {
        CourseScheduleII_210 c = new CourseScheduleII_210();
        // c.findOrder(4, new int[][]{{1,0},{2,0},{3,1},{3,2}});
        c.findOrder(2, new int[][]{{1,0},{0,1}});
    }
}
