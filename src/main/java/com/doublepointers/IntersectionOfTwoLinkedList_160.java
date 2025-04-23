package com.doublepointers;

import structure.ListNode;

public class IntersectionOfTwoLinkedList_160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }

        // pa points to the head node of link list A, so as well pb
        // After that, the two pointers traverse to the end of the linked list at a speed of 1
        // when pa meets the last node ,then jump to headB and keep traverse
        // until pa and pb encounter. pa moves a + (b - c), pb moves b + (a - c)
        ListNode pa = headA, pb = headB;
        while (pa != pb){
            pa = pa == null ? headB : pa.next;
            pb = pb == null ? headA : pb.next;
        }

        return pa;
    }
}
