package com.stack;

import structure.ListNode;

import java.util.Stack;

public class SwapNodeInPairs_24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null|| head.next == null) return head;
        ListNode dummy = new ListNode(-1, head);
        ListNode p = head, q = dummy;
        Stack<ListNode> stack = new Stack<>();
        while (p != null){
            for (int i = 0; i < 2; i++){
                stack.push(p);
                p = p.next;
            }
            while (!stack.isEmpty()){
                q.next = stack.pop();
                q = q.next;
            }
        }


        q.next = null;
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
