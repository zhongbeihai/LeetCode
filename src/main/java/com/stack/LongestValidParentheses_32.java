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
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i < s.length(); i++){
            if (stack.isEmpty() || s.charAt(i) == '(') stack.push(i);
            else {
                if (s.charAt(stack.peek()) == '('){
                    stack.pop();
                    res = Math.max(res, i - stack.peek());
                }else {
                    stack.push(i);
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
