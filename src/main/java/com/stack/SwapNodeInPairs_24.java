package com.stack;

import structure.ListNode;

import java.util.Stack;

public class SwapNodeInPairs_24 {
    public ListNode swapPairs(ListNode head) {
        if(head == null) return head;
        ListNode dummy = new ListNode(-1, head);
        Stack<ListNode> stack = new Stack<>();

        ListNode worker = dummy;
        while (head != null){
            for (int i = 0; i < 2 && head != null; i++) {
                stack.push(head);
                head = head.next;
            }
            while (!stack.isEmpty()){
                worker.next = stack.pop();
                worker = worker.next;
            }
        }
        worker.next = null;

        return dummy.next;
    }

    public static void main(String[] args) {
        SwapNodeInPairs_24 s = new SwapNodeInPairs_24();
        ListNode r1 = new ListNode(1);
        ListNode r2 = new ListNode(2);
        ListNode r3 = new ListNode(3);
        ListNode r4 = new ListNode(4);
        r1.next = r2;
        r2.next = r3;
        r3.next = r4;
        s.swapPairs(r1);
    }
}
