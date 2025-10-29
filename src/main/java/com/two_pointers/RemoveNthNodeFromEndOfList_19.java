package com.two_pointers;

import structure.ListNode;

import java.util.List;

public class RemoveNthNodeFromEndOfList_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head), worker = head;
        int total = 0;
        while (worker != null){
            total++;
            worker = worker.next;
        }
        int go = total - n;
        worker = dummy;
        while (go > 0){
            worker = worker.next;
            go--;
        }
        worker.next = worker.next.next;

        return dummy.next;
    }
}
