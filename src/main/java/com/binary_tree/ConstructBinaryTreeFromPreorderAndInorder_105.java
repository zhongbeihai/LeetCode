package com.binary_tree;

import structure.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorder_105 {
    int[] preorder, inorder;
    int preorderIdx = 0;
    Map<Integer, Integer> inorderIdxMap = new HashMap<>(); // map val to index in inorder
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) return null;

        this.preorder = preorder;
        this.inorder = inorder;
        for (int i = 0; i < inorder.length; i++) {
            inorderIdxMap.put(inorder[i], i);
        }

        return build(0, preorder.length - 1);
    }

    /**
     *
     * @param inL the left bound of current subtree in inorder array
     * @param inR the right bound of current subtree in inorder array
     * @return
     */
    public TreeNode build(int inL, int inR){
        // stop condition
        if (inL > inR) return null;

        int val = preorder[preorderIdx++];
        int idxInorder = inorderIdxMap.get(val);

        TreeNode root = new TreeNode(val);
        root.left = build(inL, idxInorder - 1);
        root.right = build(idxInorder + 1, inR);

        return root;
    }
}
