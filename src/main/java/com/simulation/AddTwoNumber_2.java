package com.simulation;

import structure.ListNode;

import java.util.List;

public class AddTwoNumber_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode worker = dummy;
        int c = 0;
        while (l1 != null || l2 != null){
            int l1val = l1 == null ? 0 : l1.val;
            int l2val = l2 == null ? 0 : l2.val;
            int tem = l1val+ l2val + c;
            c = tem / 10;
            ListNode n = new ListNode(tem % 10);
            worker.next = n;
            worker = worker.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (c != 0) worker.next = new ListNode(c);

        return dummy.next;
    }
}
