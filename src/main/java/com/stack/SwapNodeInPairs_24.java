package com.stack;

import structure.ListNode;

import java.util.Stack;

public class SwapNodeInPairs_24 {
    public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null) return head;

            ListNode dummy = new ListNode(-1, head);
            ListNode prev = dummy, cur = head;

            Stack<ListNode> stack = new Stack<>();
            while (cur != null){
                for (int i = 0; i < 2 && cur != null; i++){
                    stack.push(cur);
                    cur = cur.next;
                }
                while (!stack.isEmpty()){
                    prev.next = stack.pop();
                    prev = prev.next;
                }

            }

            prev.next = null;
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
