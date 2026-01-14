package com.binary_tree


import structure.TreeNode

class DiameterOfBinaryTree_543 {
    var diameter:Int = Int.MIN_VALUE
    fun diameterOfBinaryTree(root: TreeNode?): Int {
        maxDepth(root)
        return diameter
    }

    fun maxDepth(root: TreeNode?): Int {
        if(root == null) return 0

        var left = maxDepth(root.left)
        var right = maxDepth(root.right)
        // 一次递归两个作用，1. 返回二叉树的深度，2. 更新diameter
        diameter = Math.max(diameter, left + right)
        return 1 + Math.max(left, right)
    }
}