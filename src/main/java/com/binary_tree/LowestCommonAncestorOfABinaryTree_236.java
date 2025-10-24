package com.binary_tree;

import javafx.util.Pair;
import structure.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class LowestCommonAncestorOfABinaryTree_236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        if (isSpring(p, q)) return p;
        if (isSpring(q, p)) return q;

        return dfs(root, p, q);
    }

    public boolean isSpring(TreeNode parent, TreeNode child){
        if (parent == null) return false;

        boolean left = isSpring(parent.left, child);
        boolean right = isSpring(parent.right, child);

        if (parent.val == child.val) return true;

        return left | right;
    }

    public TreeNode dfs(TreeNode root, TreeNode p, TreeNode q){
        if (root == null) return null;

        TreeNode r = null;
        r = dfs(root.left, p, q);
        if (r != null) return r;
        r = dfs(root.right, p, q);
        if (r != null) return r;

        if (isSpring(root, p) && isSpring(root, q)) r = root;

        return r;
    }



    public static void main(String[] args) {
        LowestCommonAncestorOfABinaryTree_236 l = new LowestCommonAncestorOfABinaryTree_236();
        TreeNode n1 = new TreeNode(-1), n2 = new TreeNode(0), n3 = new TreeNode(3), n4 = new TreeNode(-2), n5 = new TreeNode(4), n6 = new TreeNode(8);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n4.left = n6;
        l.lowestCommonAncestor(n1, n6, n5);
    }

}
