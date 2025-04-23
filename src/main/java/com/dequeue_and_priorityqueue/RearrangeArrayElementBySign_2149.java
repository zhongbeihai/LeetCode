package com.dequeue_and_priorityqueue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class RearrangeArrayElementBySign_2149 {
    public int[] rearrangeArray(int[] nums) {
        Queue<Integer> pos = new ArrayDeque<>();
        Queue<Integer> neg = new ArrayDeque<>();
        for (int num : nums) {
            if (num < 0) neg.add(num);
            if (num > 0) pos.add(num);
        }
        ArrayList<Integer> a = new ArrayList<>();
        a.add(pos.poll());
        while(!pos.isEmpty() || !neg.isEmpty()){
            if(!neg.isEmpty()) a.add(neg.poll());
            if(!pos.isEmpty()) a.add(pos.poll());
        }
        return a.stream().mapToInt(i -> i).toArray();
    }
}
