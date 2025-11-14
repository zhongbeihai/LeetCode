package com.binary_tree;

import structure.TreeNode;

public class SameTree_100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return dfs(p, q);
    }

    public boolean dfs(TreeNode p, TreeNode q){
        if (p == null && q== null) return true;
        if (p == null || q == null || p.val != q.val) return false;

        boolean left = dfs(p.left, q.left);
        boolean right = dfs(p.right, q.right);

        return left && right;
    }
}
