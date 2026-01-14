package com.binary_tree;

import structure.TreeNode;

import java.util.HashSet;

public class FlipEquivalentBinaryTress_951 {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) return true;
        if((root1 == null || root2 == null)) return false;
        if(root1.val != root2.val) return false;
        return dfs(root1, root2);
    }

    public boolean dfs(TreeNode root1, TreeNode root2){
        boolean r = true;
        if(countSpring(root1) != countSpring(root2)) r = false;
        if(root1.left != null){
            if(root2.left != null && root1.left.val == root2.left.val){
                r &= dfs(root1.left, root2.left);
            }else if (root2.right != null && root1.left.val == root2.right.val){
                r &= dfs(root1.left, root2.right);
            }else {
                r = false;
            }
        }

        if(root1.right != null){
            if(root2.left != null && root1.right.val == root2.left.val){
                r &= dfs(root1.right, root2.left);
            } else if (root2.right != null && root1.right.val == root2.right.val) {
                r &= dfs(root1.right, root2.right);
            }else{
                r = false;
            }
        }

        return r;
    }

    public int countSpring(TreeNode n){
        int c = 0;
        if(n.left != null) c++;
        if(n.right != null) c++;
        return c;
    }

    public static void main(String[] args) {
        FlipEquivalentBinaryTress_951 f = new FlipEquivalentBinaryTress_951();
        TreeNode n1 = new TreeNode(1), n2 = new TreeNode(2), n3 = new TreeNode(3),
                n4 = new TreeNode(4), n5 = new TreeNode(5), n6 = new TreeNode(6),
                n7 = new TreeNode(7), n8 = new TreeNode(8);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n5.left = n7;
        n5.right = n8;
        n3.left = n6;
        TreeNode m1 = new TreeNode(1), m2 = new TreeNode(2), m3 = new TreeNode(3),
                m4 = new TreeNode(4), m5 = new TreeNode(5), m6 = new TreeNode(6),
                m7 = new TreeNode(7), m8 = new TreeNode(8);
        m1.left = m3;
        m1.right = m2;
        m3.right = m6;
        m2.left = m4;
        m2.right = m5;
        m5.left = m8;
        m5.right = m7;
        f.dfs(n1, m1);
    }
}
