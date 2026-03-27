package com.simulation;

import structure.ListNode;

public class LinkedListCycle_141 {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode p1 = head, p2 = head.next.next;
        while (p1 != null){
            if (p2 == null || p2.next == null) return false;
            if (p1 == p2) return true;
            p1 = p1.next;
            p2 = p2.next.next;
        }

        return false;
    }
}
