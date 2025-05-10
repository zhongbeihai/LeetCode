package com.search;

import structure.TreeNode;

public class CountUnivalueSubtrees_250 {
    int count = 0;
    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) return 0;
        dfs(root);
        return count;
    }

    public boolean dfs(TreeNode root){
        if (root == null) return true;

        boolean left = dfs(root.left);
        boolean right = dfs(root.right);

        if (left && right && (root.left == null || root.left.val == root.val) && (root.right == null || root.right.val == root.val)){
            count++;
            return true;
        }else {
            return false;
        }
    }
}
