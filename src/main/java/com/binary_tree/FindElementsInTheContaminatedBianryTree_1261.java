package com.binary_tree;

import structure.TreeNode;

import java.util.HashSet;

public class FindElementsInTheContaminatedBianryTree_1261 {
    private HashSet<Integer> set = new HashSet<>();
    public FindElementsInTheContaminatedBianryTree_1261(TreeNode root) {
        root.val = 0;
        set.add(0);
        dfs(root);
    }

    public void dfs(TreeNode root){
        if (root.left != null){
            root.left.val = 2 * root.val + 1;
            set.add(root.left.val);
            dfs(root.left);
        }

        if (root.right != null){
            root.right.val = 2 * root.val + 2;
            set.add(root.right.val);
            dfs(root.right);
        }
    }

    public boolean find(int target) {
        return set.contains(target);
    }
}
