package com.doublepointers;

import structure.ListNode;

public class RemoveNthNodeFromEndOfList_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //ListNode dummy = new ListNode(-1, head);
        ListNode fast = new ListNode(-1, head), slow = new ListNode(-1, head);
        while (n > 0){
            fast = fast.next;
            n--;
        }
        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        if (fast == head) return null;
        if (slow.next == head) return fast;
        slow.next = slow.next.next;

        return head;
    }
}
