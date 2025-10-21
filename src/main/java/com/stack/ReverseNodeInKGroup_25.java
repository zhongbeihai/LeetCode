package com.stack;

import structure.ListNode;

import java.util.*;

public class ReverseNodeInKGroup_25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        Deque<ListNode> stack = new ArrayDeque<>();

        ListNode dummy = new ListNode(), worker = dummy;
        while (head != null){
            stack.push(head);
            head = head.next;

            if (stack.size() == k){
                while (!stack.isEmpty()){
                    worker.next = stack.pop();
                    worker = worker.next;
                }
            }
        }
        while (!stack.isEmpty()){
            worker.next = stack.pollLast();
            worker = worker.next;
        }
        worker.next = null;

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode dummy = new ListNode(), worker = dummy;
        for (int i = 0; i < 5; i++) {
            worker.next = new ListNode(i + 1);
            worker = worker.next;
        }

        ReverseNodeInKGroup_25 r= new ReverseNodeInKGroup_25();
        r.reverseKGroup(dummy.next, 3);
    }
}
