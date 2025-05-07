package com.binary_tree;

import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.Deque;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
public class PopulateingNextingRightPointersInEachNodeII_117 {
    public Node connect(Node root) {
        if (root == null) return null;

        ArrayDeque<Pair<Node, Integer>> deque = new ArrayDeque<>();
        deque.add(new Pair<>(root, 1));

        while (!deque.isEmpty()){
            Pair<Node, Integer> p = deque.pollFirst();
            Node cn = p.getKey();
            Integer dep = p.getValue();

            if (!deque.isEmpty() && deque.peekFirst().getValue() == dep) cn.next = deque.peekFirst().getKey();
            else cn.next = null;

            if (cn.left != null) deque.addLast(new Pair<>(cn.left, dep + 1));
            if (cn.right != null) deque.addLast(new Pair<>(cn.right, dep + 1));
        }

        return root;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        Node left = new Node(2);
        Node right = new Node(3);
        root.left = left;
        root.right = right;

        PopulateingNextingRightPointersInEachNodeII_117 p = new PopulateingNextingRightPointersInEachNodeII_117();
        p.connect(root);
    }
}
