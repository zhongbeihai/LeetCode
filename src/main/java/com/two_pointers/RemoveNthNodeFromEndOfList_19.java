package com.two_pointers;

import structure.ListNode;

import java.util.List;

public class RemoveNthNodeFromEndOfList_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = new ListNode(-1, head);
        ListNode slow = new ListNode(-1, head);
        while (n > 0){
            if (fast == null) return head;
            fast = fast.next;
            n--;
        }
        while (fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }

        if (fast == head) return null;
        if (slow.next == head) return slow.next.next;
        slow.next = fast;
        return head;
    }
}
