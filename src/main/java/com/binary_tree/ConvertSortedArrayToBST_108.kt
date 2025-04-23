package com.binary_tree//package com.binary_tree
//
//import structure.TreeNode
//
//class ConvertSortedArrayToBST {
//
//    fun sortedArrayToBST(nums: IntArray):TreeNode? {
//        return sortedArrayToBST(nums, 0, nums.size)
//    }
//
//    private fun sortedArrayToBST(nums: IntArray, start:Int, end:Int): TreeNode?{
//        if(start == end){
//            return null
//        }
//
//        var mid = (start + end) / 2
//        var root = TreeNode(nums[mid])
//        root.left = sortedArrayToBST(nums, start, mid)
//        root.right = sortedArrayToBST(nums, mid + 1, end)
//
//        return root
//    }
//
//}
//
//fun main(args: Array<String>){
//    val s = ConvertSortedArrayToBST()
//    println(s.sortedArrayToBST(intArrayOf(-10,-3,0,5,9)).toString())
//}
//
//
