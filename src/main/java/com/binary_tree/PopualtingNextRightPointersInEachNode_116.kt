package com.binary_tree

class PopualtingNextRightPointersInEachNode_116 {
    class Node(var `val`: Int) {
        var left: Node? = null
        var right: Node? = null
        var next: Node? = null
    }

    fun connect(root: Node?): Node? {
        if(root == null) return null
        connect(root.left, root.right)
        return root
    }

    private fun connect(root1: Node?, root2: Node?){
        if(root1 == null || root2 == null){
            return
        }

        root1.next = root2

        connect(root1.left, root1.right)
        connect(root2.left, root2.right)
        connect(root1.right, root2.left)
    }
}