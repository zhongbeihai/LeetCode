package com.dequeue_and_priorityqueue;

import structure.ListNode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedList_23 {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(-1);
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(i -> i.val));
        for (ListNode n: lists) if (n != null) pq.add(n);

        ListNode worker = dummy;
        while (!pq.isEmpty()){
            ListNode cur = pq.poll();
            if (cur == null) continue;

            worker.next = cur;
            worker = worker.next;
            cur = cur.next;
            if (cur != null) pq.add(cur);
        }

        return dummy.next;
    }
}
