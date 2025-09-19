package com.systemdesign;

import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class TaskManager {
    public static class Task{
        public int userId, taskId, priority;
        public Task(int userId, int taskId, int priority){
            this.userId = userId;
            this.taskId = taskId;
            this.priority = priority;
        }

        public void setPriority(int taskId, int newPriority){
            this.priority = newPriority;
        }
    }

    private HashMap<Integer, Task> map = new HashMap<>(); // <taskId, Task>
    private Queue<Task> pq = new PriorityQueue<>((i, j) -> {
        if (i.priority == j.priority) return j.taskId - i.taskId;
        else  return j.priority - i.priority;
    });

    public TaskManager(List<List<Integer>> tasks) {
        for (List<Integer> t: tasks){
            Task task = new Task(t.get(0), t.get(1), t.get(2));
            pq.add(task);
            map.put(t.get(1), task);
        }
    }

    public void add(int userId, int taskId, int priority) {
        Task task = new Task(userId, taskId, priority);
        pq.add(task);
        map.put(taskId, task);
    }

    public void edit(int taskId, int newPriority) {
        Task t = map.get(taskId);
        Task newTask = new Task(t.userId,taskId, newPriority);
        pq.add(newTask);
        map.put(taskId, newTask);
    }

    public void rmv(int taskId) {
        map.remove(taskId);
    }

    public int execTop() {
        while (!pq.isEmpty()){
            Task top = pq.poll();
            Task topInMap = map.get(top.taskId);

            if (topInMap != null && top.userId == topInMap.userId && top.priority == topInMap.priority){
                map.remove(top.taskId);
                return top.userId;
            }
        }

        return -1;
    }
}
