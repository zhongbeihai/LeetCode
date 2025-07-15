package com.two_pointers;

import structure.ListNode;

/**
 * Given the head of a linked list, return the node where the cycle begins.
 * If there is no cycle, return null.
 */
public class LinkedListCycleII_142 {
    public ListNode detectCycle(ListNode head) {
        if( head == null|| head.next == null ) return null;
        ListNode fastNode = new ListNode(), slowNode = new ListNode(), h = new ListNode(),
                e = new ListNode();

        fastNode = head;
        slowNode = head;

        // 1. how to know if there is a circle
        // fastnode pass 2 node per step and slownode pass 1 node per step
        // they will encounter inside the circle
        do {
            if(fastNode.next == null || slowNode == null){
                return null;
            }
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
        }while(fastNode != slowNode);

        h = head;
        e = slowNode;
        while (h != e){
            h = h.next;
            e = e.next;
        }
        return h;
    }

    public static void main(String[] args) {
        ListNode l0= new ListNode(), l1 = new ListNode(), l2 = new ListNode(),
                l3 = new ListNode();
        l0.next = l1;
        l1.next = l2;
        l2.next = l3;
        l3.next = l1;
        l0.val = 0;
        l1.val = 1;
        l2.val = 2;
        l3.val = 3;
        LinkedListCycleII_142 lc = new LinkedListCycleII_142();
        System.out.println(lc.detectCycle(l0).val);
    }
}
