package com.doublepointers;

import structure.ListNode;

import java.util.List;

public class RemoveNthNodeFromTheEndOfList_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null){
            return null;
        }
        ListNode dummyA = new ListNode(), dummyB = new ListNode(), dummy = new ListNode();
        dummy.next = head;
        dummyA = dummy.next;
        dummyB = dummy.next;

        int count = 0;
        while(count != n){
            dummyA = dummyA.next;
            count++;
        }

        while(dummyA.next != null){
            dummyA = dummyA.next;
            dummyB = dummyB.next;
        }

        if(dummyB == dummy.next){
            return dummyB.next;
        }
        dummyB.next = dummyB.next.next;

        return dummy.next;
    }
}
