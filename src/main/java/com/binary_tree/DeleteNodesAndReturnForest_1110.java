package com.binary_tree;

import com.sun.jmx.remote.internal.ArrayQueue;
import structure.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DeleteNodesAndReturnForest_1110 {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        if (root == null) return null;
        ArrayList<TreeNode> res = new ArrayList<TreeNode>();
        DFS(root, to_delete);
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            if(cur.left != null) q.add(cur.left);
            if(cur.right != null) q.add(cur.right);
            if (cur.left != null) { // 先检查左子节点是否为 null
                if (cur.left.val == -1) cur.left = null;
            }
            if (cur.right != null) { // 先检查右子节点是否为 null
                if (cur.right.val == -1) cur.right = null;
            }
            if(cur.val == -1) {
                if(cur.left != null) res.add(cur.left);
                if(cur.right != null) res.add(cur.right);
            }
            if(cur.equals(root) && root.val != -1) res.add(cur);
        }
        return res;
    }

    public void DFS(TreeNode root, int[] to_delete) {
        if (root == null) return;
        if (Arrays.stream(to_delete).anyMatch(r -> r == root.val)) {
            root.val = -1;
        }
        if (root.left != null) DFS(root.left, to_delete);
        if (root.right != null) DFS(root.right, to_delete);
    }
}
