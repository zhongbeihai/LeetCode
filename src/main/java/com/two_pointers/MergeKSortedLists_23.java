package com.two_pointers;

import structure.ListNode;

public class MergeKSortedLists_23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        int right = lists.length - 1;
        while(right >0){
            int l = 0, r = right;
            while (l < r) {
                lists[l] = merge(lists[l], lists[r]);
                l++;
                r--;
            }
            right = r;
        }
        return lists[0];
    }

    ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode node = null;
        if(l1.val <= l2.val) {
            node = new ListNode(l1.val);
            node.next = merge(l1.next, l2);
        }else {
            node = new ListNode(l2.val);
            node.next = merge(l1, l2.next);
        }
        return node;
    }
}
