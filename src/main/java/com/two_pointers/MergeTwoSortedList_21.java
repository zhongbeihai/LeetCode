package com.two_pointers;

import structure.ListNode;

import java.util.List;

public class MergeTwoSortedList_21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode worker = dummy;
        while (list1 != null && list2 != null){
            if (list1.val <= list2.val) {
                worker.next = new ListNode(list1.val);
                list1 = list1.next;
            }else {
                worker.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            worker = worker.next;
        }
        while (list1 != null) {
            worker.next = new ListNode(list1.val);
            list1 = list1.next;
            worker = worker.next;
        }
        while(list2 != null){
            worker.next = new ListNode(list2.val);
            list2 = list2.next;
            worker = worker.next;
        }
        return dummy.next;
    }

    public ListNode merge(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        ListNode node = null;
        if(l1.val <= l2.val){
            node = new ListNode(l1.val);
            node.next = merge(l1.next, l2);
        }else {
            node = new ListNode(l2.val);
            node.next = merge(l1, l2.next);
        }
        return node;
    }
}
