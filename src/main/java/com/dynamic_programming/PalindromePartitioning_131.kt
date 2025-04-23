package com.dynamic_programming

class PalindromePartitioning_131 {
    private val res = ArrayList<List<String>>()
    fun partition(s: String): List<List<String>> {
        backTracing(s, 0, ArrayList())

        return res
    }

    fun backTracing(s: String, start: Int, temList: ArrayList<String>): Unit{
        if (start == s.length) {
            res.add(ArrayList(temList))
            return
        }

        for (i in start until s.length) {
            val currentSubstring = s.substring(start, i + 1)
            if (isPalindrome(currentSubstring)) {
                temList.add(currentSubstring)
                backTracing(s, i + 1, temList)
                temList.removeAt(temList.size - 1)
            }
        }
    }

    fun isPalindrome(s:String): Boolean{
        var left = 0
        var right = s.length - 1
        while (left < right) {
            if (s[left] != s[right]) {
                return false
            }
            left++
            right--
        }
        return true
    }
}

fun main(){
    val p = PalindromePartitioning_131()
    println( p.partition("cbbbcc"))

}