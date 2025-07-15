package com.two_pointers;

import structure.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the head of a singly linked list and two integers left and right where left <= right,
 * reverse the nodes of the list from position left to position right, and return the reversed list.
 */
public class ReverseLinkedListII_92 {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }

        ListNode dummy = new ListNode(0); // Dummy node to handle case when left = 1
        dummy.next = head;
        ListNode preLeft = dummy;

        // Move preLeft to the node just before the left position
        for (int i = 1; i < left; i++) {
            preLeft = preLeft.next;
        }

        // Node at left position
        ListNode leftNode = preLeft.next;
        ListNode curr = leftNode;
        ListNode prev = null;
        ListNode nextNode = null;

        // Reverse the sublist from left to right
        for (int i = left; i <= right; i++) {
            nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        // Connect the reversed sublist back to the original list
        preLeft.next = prev;
        leftNode.next = curr;

        return dummy.next; // Return head of the updated list
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
