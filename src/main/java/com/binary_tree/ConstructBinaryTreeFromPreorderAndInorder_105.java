package com.binary_tree;

import structure.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorder_105 {
    int[] preOrder, inOrder;
    Map<Integer, Integer> inorderMap = new HashMap<>();
    int preIdx = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) return null;
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        this.preOrder = preorder;
        this.inOrder = inorder;

        return build(0, preorder.length - 1);
    }

    public TreeNode build(int inStart, int inEnd){
        if (inStart > inEnd) return null;

        int val = preOrder[preIdx++];
        TreeNode root = new TreeNode(val);

        int inRootIdx = inorderMap.get(val);

        root.left = build(inStart, inRootIdx - 1);
        root.right = build(inRootIdx + 1, inEnd);
        return root;
    }
}
