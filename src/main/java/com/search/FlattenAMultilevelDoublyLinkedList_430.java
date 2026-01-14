package com.search;


public class FlattenAMultilevelDoublyLinkedList_430 {
    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }

    private Node prevNode;
    public Node flatten(Node head) {
        if (head == null) return head;

        Node dummy = new Node();
        prevNode = dummy;

        dfs(head);

        dummy.next.prev = null;
        return dummy.next;
    }

    public void dfs(Node curNode){
        if (curNode == null) return;

        Node nextNode = curNode.next;

        curNode.prev = prevNode;
        prevNode.next = curNode;
        prevNode = curNode;

        if (curNode.child != null){
            dfs(curNode.child);
            curNode.child = null;
        }
        if (curNode.next != null){
            dfs(nextNode);
        }
    }
}
