package com.binary_tree;

import structure.TreeNode;

public class RecoverBinarySearchTree_99 {
    TreeNode first, second, prev;
    public void recoverTree(TreeNode root) {
        midorderDfs(root);

        int tem = first.val;
        first.val = second.val;
        second.val = tem;
    }

    public void midorderDfs(TreeNode cur){
        if (cur == null) return;

        midorderDfs(cur.left);

        if (prev != null && cur.val < prev.val){
            if (first == null) first = prev;
            second = cur;
        }
        prev = cur;

        midorderDfs(cur.right);
    }
}
