package com.binary_tree;

import com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets;
import structure.Pair;

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
        if (root == null) return root;

        ArrayDeque<Pair<Node, Integer>> queue = new ArrayDeque<>();
        queue.add(new Pair<>(root, 0));
        Pair<Node, Integer> lastPair = new Pair<>(new Node(), -1);
        while (!queue.isEmpty()){
            Pair<Node, Integer> cur = queue.poll();
            Node curNode = cur.getKey();
            int curLevel = cur.getValue();

            if (lastPair.getValue() == curLevel) lastPair.getKey().next = curNode;
            else lastPair.getKey().next = null;
            lastPair = cur;

            if (curNode.left != null) queue.add(new Pair<>(curNode.left, curLevel + 1));
            if (curNode.right != null) queue.add(new Pair<>(curNode.right, curLevel + 1));
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
