package com.binary_tree

import structure.TreeNode

class FlattenBinaryTreeToLinkedList_114 {
    fun flatten(root: TreeNode?): Unit {
        if(root == null) return

        flatten(root.left)
        flatten((root.right))

        var left = root.left
        var right = root.right

        root.right = left
        root.left = null

        // 把原来的右子树放到当前右子树的末端

        var p = root
        while (p?.right != null){
            p = p.right
        }
        p?.right = right
    }

}