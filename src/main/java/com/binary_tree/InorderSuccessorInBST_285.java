package com.binary_tree;

import structure.TreeNode;
import sun.reflect.generics.tree.Tree;

public class InorderSuccessorInBST_285 {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        return helper(root, null, p.val);
    }

    public TreeNode helper(TreeNode root, TreeNode parent, int target){
        if (target > root.val) return helper(root.right, parent, target);
        else if (target < root.val) {
            return helper(root.left, root, target);
        }

        if (root.right != null) return findMin(root.right);
        else return parent;
    }

    public TreeNode findMin(TreeNode root){
        if (root.left == null) return root;

        return findMin(root.left);
    }
}
