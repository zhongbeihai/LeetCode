package com.simulation;

import structure.ListNode;

public class RotateList_61 {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return null;
        ListNode rear = head;
        int length = 1;
        while(rear.next != null){
            rear = rear.next;
            length++;
        }
        k = k % length;
        for(int i = 0; i < k; i++){
            ListNode r = head;
            ListNode p = null;
            while(r.next != null){
                p = r;
                r = r.next;
            }
            r.next = head;
            head = r;
            p.next = null;
        }
        return head;
    }

        public ListNode rotateRight_1(ListNode head, int k){
            if(head == null) return null;
            ListNode rear = head;
            int length = 1;
            while(rear.next != null){
                rear = rear.next;
                length++;
            }
            k = k % length;
            int count = 1;
            ListNode r = head;
            while (count < length - k){
                r = r.next;
                count++;
            }
            rear.next = head;
            head = r.next;
            r.next = null;
            return head;
        }

}
