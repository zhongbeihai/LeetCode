package com.monotonic_stack;

import structure.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * For each node in the list, find the value of the next greater node. That is, for each node,
 * find the value of the first node that is next to it and has a strictly larger value than it.
 */
public class NextGreaterNodeInLinkedList_1019 {
    public int[] nextLargerNodes(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        LinkedList<Integer> res = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        ListNode cur = head;
        int i = 0;
        while (cur != null){
            list.add(cur.val);
            res.add(0);
            while (!stack.isEmpty() && list.get(stack.peek()) < cur.val){
                res.set(stack.peek(), cur.val);
                stack.pop();
            }
            stack.push(i);
            cur = cur.next;
            i++;
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(2), n2 = new ListNode(1), n3 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        NextGreaterNodeInLinkedList_1019 n = new NextGreaterNodeInLinkedList_1019();
        n.nextLargerNodes(n1);
    }
}
