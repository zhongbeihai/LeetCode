package com.two_pointers;

import structure.Node;

public class InsertIntoSortedCircularLinkedList_708 {
    public Node insert(Node head, int insertVal) {
        if(head == null) {
            head = new Node(insertVal);
            head.next = head;
            return head;
        }
        Node cur = head;
        while (true){
            if (cur.val <= insertVal && cur.next.val >= insertVal) break;
            if (cur.val > cur.next.val && (insertVal >= cur.val || insertVal <= cur.next.val)) break;

            cur = cur.next;
            if (cur == head) break;
        }

        cur.next = new Node(insertVal, cur.next);

        return head;
    }

    public static void main(String[] args) {
        InsertIntoSortedCircularLinkedList_708 i = new InsertIntoSortedCircularLinkedList_708();
        Node r = new Node(3);
        Node r1 = new Node(3);
        Node r2 = new Node(5, r);
        r.next = r1;
        r1.next = r2;
        r2.next = r;
        i.insert(r1,0);
    }
}
