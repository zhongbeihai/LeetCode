package com.binary_tree;

import structure.TreeNode;
import sun.reflect.generics.tree.Tree;

public class InvertBinaryTree_226 {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        TreeNode newRoot = new TreeNode(root.val);
        dfs(root, newRoot);
        return newRoot;
    }

    public void dfs(TreeNode root, TreeNode newRoot){
        if(root == null) return;
        if(root.right != null){
            newRoot.left = new TreeNode(root.right.val);
            dfs(root.right, newRoot.left);
        }
        if (root.left != null){
            newRoot.right = new TreeNode(root.left.val);
            dfs(root.left, newRoot.right);
        }
    }

    public static void main(String[] args) {
        InvertBinaryTree_226 i = new InvertBinaryTree_226();
        TreeNode head = new TreeNode(2);
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(3);
        head.left = n1;
        head.right = n2;
        i.invertTree(head);
    }
}
