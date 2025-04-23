package com.binary_tree

import structure.ListNode
import structure.TreeNode

class ConvertSortedArrayToBST_109 {
    fun sortedListToBST(head: ListNode?): TreeNode? {
        if (head == null) {
            return null
        }
        var list = ArrayList<Int>();
        var curHead = head
        while (curHead != null) {
            list.add(curHead.`val`)
            curHead = curHead.next
        }
        val array = list.toIntArray()

        return sortedArrayToBST(array, 0, array.size)
    }

    fun sortedArrayToBST(array: IntArray, start:Int, end:Int): TreeNode?{
        if(start == end){
            return null
        }
        var mid = (start + end) / 2
        var root = TreeNode(array[mid])

        root.left = sortedArrayToBST(array, start, mid)
        root.right = sortedArrayToBST(array, mid + 1, end)

        return root
    }
}

fun main(){
    val c = ConvertSortedArrayToBST_109()
    val treeHead = ListNode(-10)
    val node = ListNode(-3)
    val node2 = ListNode(1)
    treeHead.next =node
    node.next = node2
    c.sortedListToBST(treeHead)
}