package com.hashtable;

import structure.ListNode;

import java.util.ArrayList;

public class ConvertBinaryNumberInLinkedListToInteger_1290 {
    public int getDecimalValue(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null){
            sb.append(head.val);
            head = head.next;
        }
        return Integer.parseInt(sb.toString(), 2);
    }
}
