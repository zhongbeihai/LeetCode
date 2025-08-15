package com.binary_tree;

import structure.TreeNode;
import sun.reflect.generics.tree.Tree;

public class FlattenBinaryTree_114 {
    private TreeNode prev;
    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.right);
        flatten(root.left);

        root.right = prev;
        root.left = null;
        prev = root;
    }

    public TreeNode dfs(TreeNode root){
        if (root == null) return null;
        if (root.left == null && root.right == null) return root;

        TreeNode leftTail = dfs(root.left);
        TreeNode rightTail = dfs(root.right);
        if (root.left != null){
            leftTail.right = root.right;
            root.right = root.left;
            root.left = null;
        }

        return rightTail != null ? rightTail : leftTail;
    }

    public static void main(String[] args) {
        FlattenBinaryTree_114 f = new FlattenBinaryTree_114();
        TreeNode root = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        root.left = t2;
        root.right = t5;
        t2.left = t3;
        t2.right = t4;
        t5.right = t6;

        f.flatten(root);

    }
}
