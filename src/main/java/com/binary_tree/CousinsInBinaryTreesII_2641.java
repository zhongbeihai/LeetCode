package com.binary_tree;

import structure.TreeNode;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CousinsInBinaryTreesII_2641 {
    private HashMap<Integer, Integer> map = new HashMap<>();
    public TreeNode replaceValueInTree(TreeNode root) {
        getSum(0, root);
        TreeNode n = updateSum(0, root, root, new TreeNode());
        return n;
    }

    public void getSum(int levels, TreeNode root){
        map.put(levels, map.getOrDefault(levels, 0) + root.val);
        if(root.left != null) getSum(levels + 1, root.left);
        if(root.right != null) getSum(levels + 1, root.right);
    }

    public TreeNode updateSum(int levels, TreeNode cur, TreeNode root, TreeNode n){

        TreeNode slide = null;
        if(root.left == cur && root.right != null) {
            slide = root.right;
        } else if (root.right == cur && root.left != null) {
            slide = root.left;
        }else {
            slide = new TreeNode(0);
        }

        n.val = map.get(levels) - slide.val - cur.val;
        if(cur == root) n.val = 0;

        if (cur.left != null) {
            n.left = new TreeNode();
            updateSum(levels + 1, cur.left, cur, n.left);
        }
        if(cur.right != null){
            n.right = new TreeNode();
            updateSum(levels + 1, cur.right, cur, n.right);
        }

        return n;
    }

    public static void main(String[] args) {
        CousinsInBinaryTreesII_2641 c = new CousinsInBinaryTreesII_2641();
        TreeNode n1 = new TreeNode(5), n2 = new TreeNode(4), n3 = new TreeNode(9),
                n4 = new TreeNode(1), n5 = new TreeNode(10), n6 = new TreeNode(7);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        c.replaceValueInTree(n1);

    }
}
