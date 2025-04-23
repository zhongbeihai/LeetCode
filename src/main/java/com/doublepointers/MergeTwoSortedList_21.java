package com.doublepointers;

import structure.ListNode;

public class MergeTwoSortedList_21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        list1 = merge(list1, list2);
        return list1;
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
