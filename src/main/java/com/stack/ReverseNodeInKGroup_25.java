package com.stack;

import structure.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class ReverseNodeInKGroup_25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1, head);
        ListNode prev = dummy, cur = head;

        Stack<ListNode> stack = new Stack<>();
        while (cur != null){
            int j = 0;
            for (int i = 0; i < k && cur != null; i++){
                stack.push(cur);
                cur = cur.next;
                j++;
            }
            if (j == k){
                while(!stack.isEmpty()){
                    prev.next = stack.pop();
                    prev = prev.next;
                }
            }else {
                List<ListNode> list = new ArrayList<>(stack);
                for (ListNode listNode : list) {
                    prev.next = listNode;
                    prev = prev.next;
                }
            }
        }

        prev.next = null;
        return dummy.next;
    }
}
