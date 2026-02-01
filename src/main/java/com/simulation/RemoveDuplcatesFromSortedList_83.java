package com.simulation;

import structure.ListNode;

public class RemoveDuplcatesFromSortedList_83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(-1, head);
        ListNode p1 = head, p2 = head.next;

        while (p1 != null && p2 != null){
            while (p2 != null && p1.val == p2.val) p2 = p2.next;
            p1.next = p2;

            p1 = p1.next;
            if (p2 != null) p2 = p2.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode n3 = new ListNode(1);
        ListNode n2 = new ListNode(1, n3);
        ListNode n1 = new ListNode(1, n2);
        RemoveDuplcatesFromSortedList_83 r = new RemoveDuplcatesFromSortedList_83();
        r.deleteDuplicates(n1);
    }
}
