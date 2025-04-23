package com.binary_tree;

import structure.TreeNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class HeightOfBinaryTreeAfterSubtreeRemovalQueries_2458 {
    public int[] treeQueries(TreeNode root, int[] queries) {

        int[] arr = new int[queries.length];
        for(int i = 0; i < queries.length; i++){
            delete(root, queries[i]);
            arr[i] = getHeight(root, 0);
        }


        return arr;
    }

    public void delete(TreeNode root, int target){

        if(root.left.val == target){
            root.left = null;
            return;
        }
        if(root.right.val == target){
            root.right = null;
            return;
        }

        if(root.left != null){
            delete(root, target);
        }
        if(root.right != null){
            delete(root, target);
        }
    }

    public int getHeight(TreeNode root, int count){
        if(root.right == null && root.left == null){
            return count;
        }
        int heightOfLeft  = 0, heightOfRight = 0;
        if(root.left != null ) heightOfLeft = getHeight(root.left, count + 1);
        if(root.right != null) heightOfRight = getHeight(root.right, count + 1);

        return Math.max(heightOfLeft, heightOfRight);
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1), n2 = new TreeNode(3), n3 = new TreeNode(4),
                n4 = new TreeNode(2), n5 = new TreeNode(6), n6 = new TreeNode(5), n7 = new TreeNode(8);
        HeightOfBinaryTreeAfterSubtreeRemovalQueries_2458 h = new HeightOfBinaryTreeAfterSubtreeRemovalQueries_2458();
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n3.left = n5;
        n3.right = n6;
        n6.right = n7;
        int q = h.getHeight(n1, 0);
    }
}
