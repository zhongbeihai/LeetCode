package com.binary_tree;

import structure.TreeNode;

public class ConstructBinaryTreeFromPreorderAndPostorderTraversal_889 {
    private int preInd = 0;
    private int posInd = 0;
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return buildTree(preorder, postorder);
    }

    public TreeNode buildTree(int[] preOrder, int[] postOrder){
         TreeNode root = new TreeNode(preOrder[preInd]);
         preInd++;

         if (root.val != postOrder[posInd]){
             root.left = buildTree(preOrder, postOrder);
         }

         if (root.val != postOrder[posInd]){
             root.right = buildTree(preOrder, postOrder);
         }

         posInd++;
         return root;
    }
}
