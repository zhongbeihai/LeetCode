package com.two_pointers;

import structure.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given the head of a singly linked list and two integers left and right where left <= right,
 * reverse the nodes of the list from position left to position right, and return the reversed list.
 */
public class ReverseLinkedListII_92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1, head);
        ListNode start  = dummy, p = head;
        for (int i = 1; i < left; i++){
            start = start.next;
            p = p.next;
        }
        Stack<ListNode> stack = new Stack<>();
        for (int i = 0; i < right - left + 1; i++){
            stack.push(p);
            p = p.next;
        }
        ListNode end = p;
        while (!stack.isEmpty()){
            start.next = stack.pop();
            start = start.next;
        }
        start.next = end;

        return dummy.next;
    }



    public static void main(String[] args) {
        List<ListNode> ll = new ArrayList<>();
        for(int i = 1; i <=5 ;i++){
            ListNode l1 = new ListNode();
            l1.val = i;
            ll.add(l1);
        }
        for(int i = 0; i <=3; i++){
            ll.get(i).next = ll.get(i + 1);
        }

        ListNode l1 = ll.get(0);
        ReverseLinkedListII_92 r = new ReverseLinkedListII_92();
        r.reverseBetween(ll.get(0), 2, 4);
        while(l1 != null){
            System.out.println(l1.val);
        }
    }
}
