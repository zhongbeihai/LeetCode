package com.doublepointers;

import structure.ListNode;

import java.util.List;

public class SwapNodesInPairs_24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;

        ListNode p1 = head, p2 = head.next;
        ListNode dummy = p2;
        while (p1.next != null){
            ListNode tem = p2.next;
            p1.next = tem;
            p2.next = p1;

            p2 = tem.next;
            p1 = tem;
        }

        return dummy;
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
