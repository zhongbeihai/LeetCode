package com.dequeue_and_priorityqueue;

import structure.ListNode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedList_23 {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(i -> i.val));
        for (ListNode n: lists){
            if (n != null) pq.add(n);
        }
        ListNode dummy = new ListNode(-1), worker = dummy;

        while (!pq.isEmpty()){
            ListNode next = pq.poll();
            worker.next = next;
            worker = worker.next;
            if (next.next != null) pq.add(next.next);
        }

        return dummy;
    }
}
