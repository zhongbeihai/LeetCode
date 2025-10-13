package com.binary_tree;

import structure.TreeNode;

import java.util.EnumMap;

public class CountCompleteTreeNodes_222 {
    public int countNodes(TreeNode root) {
        return dfs(root);
    }

    public int dfs(TreeNode root){
        if (root == null) return 0;

        int left = dfs(root.left);
        int right = dfs(root.right);

        return left + right + 1;
    }
}
