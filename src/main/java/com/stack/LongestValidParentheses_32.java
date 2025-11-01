package com.stack;

import java.util.Stack;

/**
 * Given a string containing just the characters '(' and ')',
 * return the length of the longest valid (well-formed) parentheses substring
 * Input: s = ")()())"
 * Output: 4
 * **the top the stack is the first **index** of invalid element**
 */
public class LongestValidParentheses_32 {
    public int longestValidParentheses(String s) {
        if (s.isEmpty()) return 0;

        Stack<Character> stack = new Stack<>();
        char[] ss = s.toCharArray();
        int res = 0, len = 0;
        for (char c: ss){
            if (stack.isEmpty() || c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.peek() == '('){
                    stack.pop();
                    len += 2;
                    res = Math.max(res, len);
                }else {
                    len = 0;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        LongestValidParentheses_32 l = new LongestValidParentheses_32();
        l.longestValidParentheses("()(()");
    }
}
