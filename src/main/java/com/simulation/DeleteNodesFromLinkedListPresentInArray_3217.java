package com.simulation;

import structure.ListNode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class DeleteNodesFromLinkedListPresentInArray_3217 {
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>();
        for (int num: nums) set.add(num);
        if (head == null) return head;

        ListNode dummy = new ListNode(-1, head), prev = dummy, cur = dummy.next;
        while (cur != null){
            if (set.contains(cur.val)){
                prev.next = cur.next;
                cur = prev.next;
            }else {
                prev = cur;
                cur = cur.next;
            }
        }

        return dummy.next;
    }
}
