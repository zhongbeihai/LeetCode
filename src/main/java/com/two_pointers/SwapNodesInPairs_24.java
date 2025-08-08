package com.two_pointers;

import structure.ListNode;

public class SwapNodesInPairs_24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(-1, head);
        ListNode prev = dummy, cur = head;
        while (cur != null){
            ListNode nn = cur.next.next;
            ListNode n = cur.next;

            n.next = cur;
            cur.next = nn;
            prev.next = n;

            prev = cur;
            cur = nn;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;

        SwapNodesInPairs_24 s=  new SwapNodesInPairs_24();
        s.swapPairs(l1);
    }
}
