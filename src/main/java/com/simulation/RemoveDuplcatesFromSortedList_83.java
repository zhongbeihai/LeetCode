package com.simulation;

import structure.ListNode;

public class RemoveDuplcatesFromSortedList_83 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-101, head);
        ListNode prev = dummy;
        while (prev != null){
            while (prev.next != null && prev.val == prev.next.val) prev.next = prev.next.next;
            prev = prev.next;
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
