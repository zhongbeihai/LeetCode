package com.simulation;

import structure.ListNode;

import java.util.List;
import java.util.Stack;

public class AddTwoNumberII_445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> s1 = new Stack<>();
        Stack<ListNode> s2 = new Stack<>();
        while (l1 != null){
            s1.push(l1);
            l1 = l1.next;
        }
        while (l2 != null){
            s2.push(l2);
            l2 = l2.next;
        }

        ListNode dummy = new ListNode(-1);
        int c = 0;
        while (!s1.isEmpty() || !s2.isEmpty() || c != 0){
            int v1 = s1.isEmpty() ? 0 : s1.pop().val;
            int v2 = s2.isEmpty() ? 0: s2.pop().val;
            int tem = v1 + v2 + c;
            c = tem / 10;
            ListNode n = new ListNode(tem % 10, dummy.next);
            dummy.next = n;
        }

        return dummy.next;
    }
}
