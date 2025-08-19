package com.dequeue_and_priorityqueue;

import structure.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedList_23 {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(i -> i.val));
        for (ListNode n: lists) if (n != null) pq.add(n);

        ListNode dummy = new ListNode(0), tail = dummy;
        while (!pq.isEmpty()){
            ListNode x = pq.poll();
            tail.next = x;
            tail = x;
            if (x.next != null) pq.add(x.next);
        }
        return dummy.next;
    }
}
