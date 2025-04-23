package com.binary_tree;

import structure.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class RecoverBinaryTreeFromPreorderTraversal_1028 {
    public Deque<int[]> nodeList = new ArrayDeque<>();
    public TreeNode recoverFromPreorder(String traversal) {
        if (traversal.isEmpty()) return null;
        parseNode(traversal);
        TreeNode root = new TreeNode(nodeList.pollFirst()[1]);
        buildTree(root, 0);

        return root;
    }

    public void buildTree(TreeNode parent, int depth){
        if (!nodeList.isEmpty() && nodeList.peekFirst()[0] == depth + 1){
            TreeNode leftChild = new TreeNode(nodeList.pollFirst()[1]);
            parent.left = leftChild;
            buildTree(parent.left, depth + 1);
        }

        if (!nodeList.isEmpty() && nodeList.peekFirst()[0] == depth + 1){
            TreeNode rightChild = new TreeNode(nodeList.pollFirst()[1]);
            parent.right = rightChild;
            buildTree(parent.right, depth + 1);
        }
    }

    public void parseNode(String traversal){
        char[] t = traversal.toCharArray();
        int p = 0;

        int dc = 0, nc = 0;
        while (p < t.length){
            while (p < t.length && t[p] == '-') {
                dc++;
                p++;
            }

            while (p < t.length && Character.isDigit(t[p])){
                nc = nc * 10 + t[p] - '0';
                p++;
            }

            nodeList.add(new int[]{dc, nc});
            dc = 0;
            nc = 0;
        }
    }

    public static void main(String[] args) {
        RecoverBinaryTreeFromPreorderTraversal_1028 r = new RecoverBinaryTreeFromPreorderTraversal_1028();
        r.parseNode("1-2--3--4-5--6--7");
    }
}
