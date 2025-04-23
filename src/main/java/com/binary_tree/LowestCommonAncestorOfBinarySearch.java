package com.binary_tree;

import structure.TreeNode;

public class LowestCommonAncestorOfBinarySearch {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        if (p.val < root.val && q.val < root.val){
            return lowestCommonAncestor(root.left, p, q);
        }

        if (p.val > root.val && q.val > root.val){
            return lowestCommonAncestor(root.right, p ,q);
        }

        return root;
    }

    public int dfs(TreeNode root, TreeNode p, TreeNode q){
        TreeNode tem = null;
        int count = 0;
        if (root.val == p.val || root.val == q.val) count++;

        if (root.left != null) count += dfs(root.left, p, q);
        if (root.right != null) count += dfs(root.right, p, q);

        return count;
    }
}


