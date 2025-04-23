package com.simulation;

import java.util.HashMap;
import java.util.LinkedList;

public class CopyListWithRandomPointer_138 {
    private class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        HashMap<Node, Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null){
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        while (cur != null){
            Node n = map.get(cur);
            n.next = map.get(cur.next);
            n.random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }
}
