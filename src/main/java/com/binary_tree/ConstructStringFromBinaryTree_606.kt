package com.binary_tree

import structure.TreeNode

class ConstructStringFromBinaryTree_606 {
    fun tree2str(root: TreeNode?):String {
        return traverse(root)
    }

    fun traverse(root: TreeNode?):String{
        if(root == null) return ""

        val res = StringBuilder()
        res.append(root.`val`)
        if(root.left != null){
            res.append("(").append(traverse(root.left)).append(")")
        }
        if(root.left == null && root.right != null){
            res.append("()").append("(").append(traverse(root.right)).append(")")
        }else if(root.right != null){
            res.append("(").append(traverse(root.right)).append(")")
        }

        return res.toString();
    }
}