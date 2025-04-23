package com.divided;

import com.dynamic_programming.PartitionLabels_763;
import structure.ListNode;

public class MergeKSortedLists_23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        int rightBoundary = lists.length - 1;
        while (rightBoundary > 0){
            int l = 0;
            int r = rightBoundary;
            while (l < r){
                lists[l] = mergeTwoNode(lists[l], lists[r]);
                l++;
                r--;
            }
            rightBoundary = r;
        }
        return lists[0];
    }

    public ListNode mergeTwoNode(ListNode n1, ListNode n2){
        if (n1 == null) return n2;
        if (n2 == null) return n1;
        ListNode node;
        if(n1.val <= n2.val){
            node = new ListNode(n1.val);
            node.next = mergeTwoNode(n1.next, n2);
        }else{
            node = new ListNode(n2.val);
            node.next = mergeTwoNode(n1, n2.next);
        }

        return node;
    }
}
