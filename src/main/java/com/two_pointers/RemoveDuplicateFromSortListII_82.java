package com.two_pointers;

import structure.ListNode;

public class RemoveDuplicateFromSortListII_82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode res = new ListNode(0, head);
        ListNode prev = res;

        while (head != null && head.next != null){
            if(head.next.val == head.val){
                while (head.next != null && head.next.val == head.val){
                    head = head.next;
                }
                prev.next = head.next;
            }else {
                prev = prev.next;
            }
            head = head.next;
        }

        return res.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(3);
        ListNode n6 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        ListNode nn1 = new ListNode(1);
        ListNode nn2 = new ListNode(1);
        nn1.next = nn2;
        RemoveDuplicateFromSortListII_82 r = new RemoveDuplicateFromSortListII_82();
        r.deleteDuplicates(nn1);
    }
}
