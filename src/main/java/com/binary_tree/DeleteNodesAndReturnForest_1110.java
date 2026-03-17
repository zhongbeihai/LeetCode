package com.binary_tree;

import structure.TreeNode;

import java.util.*;

public class DeleteNodesAndReturnForest_1110 {
    List<TreeNode> res = new ArrayList<>();
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        HashSet<Integer> toDeleteSet = new HashSet<>();
        for (int d: to_delete) toDeleteSet.add(d);
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        // To mark the TreeNode needed to be deleted
        while (!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if (toDeleteSet.contains(cur.val)) cur.val = -1;

            if (cur.left != null) queue.add(cur.left);
            if (cur.right != null) queue.add(cur.right);
        }

        // Do delete
        dfs(root);
        if (root.val != -1) res.add(root);

        return res;
    }

    public void dfs(TreeNode root){
        if (root == null) return;

        dfs(root.left);
        dfs(root.right);

        if (root.left != null && root.left.val == -1) root.left = null;
        if (root.right != null && root.right.val == -1) root.right = null;

        if (root.val == -1){
            if (root.left != null) res.add(root.left);
            if (root.right != null) res.add(root.right);
            root.left = null;
            root.right = null;
        }
    }
}
