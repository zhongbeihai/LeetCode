package com.dynamic_programming;

import javafx.util.Pair;

import java.util.*;

public class TaskSchedule_621 {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> fre = new HashMap<>();
        for (char task: tasks){
            fre.put(task, fre.getOrDefault(task, 0) + 1);
        }
        PriorityQueue<Pair<Character, Integer>> queue = new PriorityQueue<>(((o1, o2) -> o2.getValue() - o1.getValue()));
        for (Character c : fre.keySet()){
            queue.add(new Pair<>(c, fre.get(c)));
        }
        int res = 0;
        while (!queue.isEmpty()){
            PriorityQueue<Pair<Character, Integer>> used = new PriorityQueue<>(((o1, o2) -> o2.getValue() - o1.getValue()));
            int time = 0;
            int head = 1;
            while (!queue.isEmpty()){
                time++;
                Pair<Character, Integer> task;
                if (!used.isEmpty() && n < time - head) {
                    task = used.poll();
                    head = time;
                }
                else task = queue.poll();
                if (task.getValue() != 1) used.add(new Pair<>(task.getKey(), task.getValue() - 1));
            }
            queue.addAll(used);
            while (!queue.isEmpty() && time < n + 1) time++;
            res += time;
        }

        return res;
    }

    public static void main(String[] args) {
        TaskSchedule_621 t = new TaskSchedule_621();
        t.leastInterval(new char[]{'b','c','d','a','a','a','a','g'}, 1);
    }
}
