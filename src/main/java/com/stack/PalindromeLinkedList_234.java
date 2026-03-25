package com.stack;

import structure.ListNode;

import java.util.ArrayDeque;

public class PalindromeLinkedList_234 {
    public boolean isPalindrome(ListNode head) {
        ArrayDeque<ListNode> stack = new ArrayDeque<>();
        ListNode worker = head;
        while (worker != null){
            stack.push(worker);
            worker = worker.next;
        }

        while (head != null){
            if (stack.isEmpty() || head.val != stack.pop().val) return false;
            head = head.next;
        }

        return stack.isEmpty();
    }
}
