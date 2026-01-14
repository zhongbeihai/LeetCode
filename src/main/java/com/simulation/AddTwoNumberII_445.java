package com.simulation;

import structure.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

public class AddTwoNumberII_445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<ListNode> stack1 = new ArrayDeque<>();
        Deque<ListNode> stack2 = new ArrayDeque<>();

        ListNode p = l1;
        while (p != null){
            stack1.push(p);
            p = p.next;
        }

        p = l2;
        while (p != null){
            stack2.push(p);
            p = p.next;
        }

        ListNode dummy = new ListNode(-1);
        int r = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty() || r != 0){
            int n1 = stack1.isEmpty() ? 0 : stack1.pop().val;
            int n2 = stack2.isEmpty() ? 0 : stack2.pop().val;
            ListNode node = new ListNode((n1 + n2 + r) % 10);
            r = (n1 + n2 + r) / 10;

            node.next = dummy.next;
            dummy.next = node;
        }

        return dummy.next;
    }
}
