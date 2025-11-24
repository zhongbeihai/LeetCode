package com.binary_tree;

public class CovertBinarySearchTreeToSortedDoublyLinkedList_426 {
    Node prev, head;
    public Node treeToDoublyList(Node root) {
        if (root == null) return null;

        midOrderDFS(root);

        head.left = prev;
        prev.right = head;

        return head;
    }

    public void midOrderDFS(Node root){
        if (root == null) return;

        midOrderDFS(root.left);
        if (prev == null) head = root;
        if (prev != null){
            prev.right = root;
            root.left = prev;
        }
        prev = root;

        midOrderDFS(root.right);
    }
}
